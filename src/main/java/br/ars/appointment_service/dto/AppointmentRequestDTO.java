package br.ars.appointment_service.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppointmentRequestDTO {

    private UUID matchId;
    private UUID consultorId;
    private UUID profissionalId;
    private LocalDateTime dataHora;

    public UUID getMatchId() {
        return matchId;
    }

    public void setMatchId(UUID matchId) {
        this.matchId = matchId;
    }

    public UUID getConsultorId() {
        return consultorId;
    }

    public void setConsultorId(UUID consultorId) {
        this.consultorId = consultorId;
    }

    public UUID getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(UUID profissionalId) {
        this.profissionalId = profissionalId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
