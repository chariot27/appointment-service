package br.ars.appointment_service.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppointmentResponseDTO {

    private UUID id;
    private UUID matchId;
    private UUID consultorId;
    private UUID profissionalId;
    private LocalDateTime dataHora;
    private boolean confirmadoConsultor;
    private boolean confirmadoProfissional;
    private boolean contatoLiberado;
    private boolean cancelado;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public boolean isConfirmadoConsultor() {
        return confirmadoConsultor;
    }

    public void setConfirmadoConsultor(boolean confirmadoConsultor) {
        this.confirmadoConsultor = confirmadoConsultor;
    }

    public boolean isConfirmadoProfissional() {
        return confirmadoProfissional;
    }

    public void setConfirmadoProfissional(boolean confirmadoProfissional) {
        this.confirmadoProfissional = confirmadoProfissional;
    }

    public boolean isContatoLiberado() {
        return contatoLiberado;
    }

    public void setContatoLiberado(boolean contatoLiberado) {
        this.contatoLiberado = contatoLiberado;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
}
