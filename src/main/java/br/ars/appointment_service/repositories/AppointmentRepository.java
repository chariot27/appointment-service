package br.ars.appointment_service.repositories;

import br.ars.appointment_service.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    // Se necessário, adicione métodos customizados aqui futuramente.
}
