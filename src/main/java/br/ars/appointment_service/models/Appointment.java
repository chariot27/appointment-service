package br.ars.appointment_service.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "match_id", nullable = false)
    private UUID matchId;

    @Column(name = "consultor_id", nullable = false)
    private UUID consultorId;

    @Column(name = "profissional_id", nullable = false)
    private UUID profissionalId;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "confirmado_consultor")
    private boolean confirmadoConsultor;

    @Column(name = "confirmado_profissional")
    private boolean confirmadoProfissional;

    @Column(name = "contato_liberado")
    private boolean contatoLiberado;

    @Column(name = "cancelado")
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
