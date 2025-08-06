package br.ars.appointment_service.services;

import br.ars.appointment_service.dto.AppointmentRequestDTO;
import br.ars.appointment_service.dto.AppointmentResponseDTO;
import br.ars.appointment_service.mappers.AppointmentMapper;
import br.ars.appointment_service.models.Appointment;
import br.ars.appointment_service.repositories.AppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;
    private final AppointmentMapper mapper;

    public AppointmentService(AppointmentRepository repository, AppointmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public AppointmentResponseDTO criarAgendamento(AppointmentRequestDTO dto) {
        Appointment agendamento = mapper.toEntity(dto);
        agendamento.setContatoLiberado(false);
        agendamento.setConfirmadoConsultor(false);
        agendamento.setConfirmadoProfissional(false);
        agendamento.setCancelado(false);
        return mapper.toDto(repository.save(agendamento));
    }

    public List<AppointmentResponseDTO> listarAgendamentos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public AppointmentResponseDTO buscarPorId(UUID id) {
        Appointment agendamento = buscarEntidade(id);
        return mapper.toDto(agendamento);
    }

    @Transactional
    public AppointmentResponseDTO confirmarPorConsultor(UUID id) {
        Appointment agendamento = buscarEntidade(id);
        agendamento.setConfirmadoConsultor(true);
        verificarSeLiberaContato(agendamento);
        return mapper.toDto(repository.save(agendamento));
    }

    @Transactional
    public AppointmentResponseDTO confirmarPorProfissional(UUID id) {
        Appointment agendamento = buscarEntidade(id);
        agendamento.setConfirmadoProfissional(true);
        verificarSeLiberaContato(agendamento);
        return mapper.toDto(repository.save(agendamento));
    }

    @Transactional
    public AppointmentResponseDTO cancelarAgendamento(UUID id) {
        Appointment agendamento = buscarEntidade(id);
        agendamento.setCancelado(true);
        agendamento.setContatoLiberado(false); // não permite contato se cancelado
        return mapper.toDto(repository.save(agendamento));
    }

    @Transactional
    public AppointmentResponseDTO remarcarAgendamento(UUID id, AppointmentRequestDTO novoAgendamentoDTO) {
        Appointment agendamento = buscarEntidade(id);
        
        if (agendamento.isCancelado()) {
            throw new IllegalStateException("Agendamento cancelado não pode ser remarcado.");
        }

        agendamento.setDataHora(novoAgendamentoDTO.getDataHora());
        

        // Ao remarcar, zera as confirmações
        agendamento.setConfirmadoConsultor(false);
        agendamento.setConfirmadoProfissional(false);
        agendamento.setContatoLiberado(false);

        return mapper.toDto(repository.save(agendamento));
    }

    private void verificarSeLiberaContato(Appointment agendamento) {
        if (agendamento.isConfirmadoConsultor() && agendamento.isConfirmadoProfissional()) {
            agendamento.setContatoLiberado(true);
        }
    }

    private Appointment buscarEntidade(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado."));
    }
}
