package br.ars.appointment_service.controllers;

import br.ars.appointment_service.dto.AppointmentRequestDTO;
import br.ars.appointment_service.dto.AppointmentResponseDTO;
import br.ars.appointment_service.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> criarAgendamento(@RequestBody AppointmentRequestDTO dto) {
        AppointmentResponseDTO response = service.criarAgendamento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> listarAgendamentos() {
        return ResponseEntity.ok(service.listarAgendamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PatchMapping("/{id}/confirmar/consultor")
    public ResponseEntity<AppointmentResponseDTO> confirmarPorConsultor(@PathVariable UUID id) {
        return ResponseEntity.ok(service.confirmarPorConsultor(id));
    }

    @PatchMapping("/{id}/confirmar/profissional")
    public ResponseEntity<AppointmentResponseDTO> confirmarPorProfissional(@PathVariable UUID id) {
        return ResponseEntity.ok(service.confirmarPorProfissional(id));
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<AppointmentResponseDTO> cancelarAgendamento(@PathVariable UUID id) {
        return ResponseEntity.ok(service.cancelarAgendamento(id));
    }

    @PutMapping("/{id}/remarcar")
    public ResponseEntity<AppointmentResponseDTO> remarcarAgendamento(@PathVariable UUID id, @RequestBody AppointmentRequestDTO novoAgendamentoDTO) {
        return ResponseEntity.ok(service.remarcarAgendamento(id, novoAgendamentoDTO));
    }
}
