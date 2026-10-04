package br.com.adbrascosmopolis.saac_secretaria.dto.evento;

import br.com.adbrascosmopolis.saac_secretaria.models.Evento;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventoEditDTO {

    private Integer eventoId;
    private Integer congregacaoId;
    private Integer tipoEventoId;
    private String descricao;
    private Integer participantes;
    private Integer visitantes;
    private LocalDate dataEvento;
    private Integer situacaoId;
    private LocalDateTime deletedAt;

    public static EventoEditDTO fromEvento(Evento e){

        EventoEditDTO dto = new EventoEditDTO();

        dto.eventoId = e.getEventoId();
        dto.congregacaoId = e.getCongregacao() != null ? e.getCongregacao().getCongregacaoId() : null;
        dto.tipoEventoId = e.getTipoEvento() != null ? e.getTipoEvento().getTipoEventoId() : null;
        dto.descricao = e.getDescricao();
        dto.participantes = e.getParticipantes();
        dto.visitantes = e.getVisitantes();
        dto.dataEvento = e.getDataEvento();
        dto.situacaoId = e.getSituacao() != null ? e.getSituacao().getSituacaoId() : null;
        dto.deletedAt = e.getDeletedAt();

        return dto;
    }

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public Integer getTipoEventoId() {
        return tipoEventoId;
    }

    public void setTipoEventoId(Integer tipoEventoId) {
        this.tipoEventoId = tipoEventoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Integer participantes) {
        this.participantes = participantes;
    }

    public Integer getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(Integer visitantes) {
        this.visitantes = visitantes;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Integer getSituacaoId() {
        return situacaoId;
    }

    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
