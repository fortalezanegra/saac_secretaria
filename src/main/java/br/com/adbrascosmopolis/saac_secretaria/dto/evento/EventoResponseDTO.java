package br.com.adbrascosmopolis.saac_secretaria.dto.evento;

import br.com.adbrascosmopolis.saac_secretaria.models.Evento;

import java.time.LocalDate;

public class EventoResponseDTO {

    private Long eventoId;
    private Integer congregacaoId;
    private String congregacao;
    private Integer tipoEventoId;
    private String tipoEvento;
    private String descricao;
    private Integer participantes;
    private Integer visitantes;
    private LocalDate dataEvento;
    private String situacao;

    public EventoResponseDTO(
            Long eventoId,
            Integer congregacaoId,
            String congregacao,
            Integer tipoEventoId,
            String tipoEvento,
            String descricao,
            Integer participantes,
            Integer visitantes,
            LocalDate dataEvento,
            String situacao
    ){
        this.eventoId = eventoId;
        this.congregacaoId = congregacaoId;
        this.congregacao = congregacao;
        this.tipoEventoId = tipoEventoId;
        this.tipoEvento = tipoEvento;
        this.descricao = descricao;
        this.participantes = participantes;
        this.visitantes = visitantes;
        this.dataEvento = dataEvento;
        this.situacao = situacao;
    }

    public static EventoResponseDTO fromEvento(Evento e){
        if(e == null) return null;

        return new EventoResponseDTO(
                e.getEventoId(),
                e.getCongregacao() != null ? e.getCongregacao().getCongregacaoId() : null,
                e.getCongregacao() != null ? e.getCongregacao().getNome() : null,
                e.getTipoEvento() != null ? e.getTipoEvento().getTipoEventoId() : null,
                e.getTipoEvento() != null ? e.getTipoEvento().getDescricao() : null,
                e.getDescricao(),
                e.getParticipantes(),
                e.getVisitantes(),
                e.getDataEvento(),
                e.getSituacao() != null ? e.getSituacao().getDescricao() : null
        );
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public String getCongregacao() {
        return congregacao;
    }

    public void setCongregacao(String congregacao) {
        this.congregacao = congregacao;
    }

    public Integer getTipoEventoId() {
        return tipoEventoId;
    }

    public void setTipoEventoId(Integer tipoEventoId) {
        this.tipoEventoId = tipoEventoId;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
