package br.ars.appointment_service.mappers;

import br.ars.appointment_service.dto.AppointmentRequestDTO;
import br.ars.appointment_service.dto.AppointmentResponseDTO;
import br.ars.appointment_service.models.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    // Converte DTO de requisição para entidade
    Appointment toEntity(AppointmentRequestDTO dto);

    // Converte entidade para DTO de resposta
    AppointmentResponseDTO toDto(Appointment appointment);
}
