package br.com.adbrascosmopolis.saac_secretaria.dto.evento;

import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Evento;
import br.com.adbrascosmopolis.saac_secretaria.models.Situacao;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoEvento;

import java.time.LocalDate;

public class EventoRequestDTO {

    private Integer congregacaoId;
    private Integer tipoEventoId;
    private String descricao;
    private Integer participantes;
    private Integer visitantes;
    private LocalDate dataEvento;
    private Integer situacaoId;

    public EventoRequestDTO(
            Integer congregacaoId,
            Integer tipoEventoId,
            String descricao,
            Integer participantes,
            Integer visitantes,
            LocalDate dataEvento,
            Integer situacaoId){
        this.congregacaoId = congregacaoId;
        this.tipoEventoId = tipoEventoId;
        this.descricao = descricao;
        this.participantes = participantes;
        this.visitantes = visitantes;
        this.dataEvento = dataEvento;
        this.situacaoId = situacaoId;
    }

    public Evento mapToEvento(){
        Evento evento = new Evento();

        evento.setDescricao(this.descricao);
        evento.setParticipantes(this.participantes);
        evento.setVisitantes(this.visitantes);
        evento.setDataEvento(dataEvento);

        //Relacionamentos
        if(this.congregacaoId != null){
            Congregacao congregacao = new Congregacao();
            congregacao.setCongregacaoId(this.congregacaoId);
            evento.setCongregacao(congregacao);
        }

        if(this.tipoEventoId != null){
            TipoEvento tipo = new TipoEvento();
            tipo.setTipoEventoId(this.tipoEventoId);
            evento.setTipoEvento(tipo);
        }

        if(this.situacaoId != null){
            Situacao situacao = new Situacao();
            situacao.setSituacaoId(this.situacaoId);
            evento.setSituacao(situacao);
        }

        return evento;
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
}
