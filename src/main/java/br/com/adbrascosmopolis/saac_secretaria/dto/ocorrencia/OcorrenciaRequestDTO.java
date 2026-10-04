package br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia;

import br.com.adbrascosmopolis.saac_secretaria.models.Evento;
import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoEvento;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoOcorrencia;

public class OcorrenciaRequestDTO {

    private Integer eventoId;
    private Integer tipoOcorrenciaId;
    private Integer quantidade;

    public OcorrenciaRequestDTO(
            Integer eventoId,
            Integer tipoOcorrenciaId,
            Integer quantidade
    ){
        this.eventoId = eventoId;
        this.tipoOcorrenciaId = tipoOcorrenciaId;
        this.quantidade = quantidade;
    }

    public Ocorrencia mapToOcorrencia(){
        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setQuantidade(this.quantidade);

        //Relacionamento
        if(this.eventoId != null){
            Evento evento = new Evento();
            evento.setEventoId(this.eventoId);
            ocorrencia.setEvento(evento);
        }

        if(this.tipoOcorrenciaId != null){
            TipoOcorrencia tipo = new TipoOcorrencia();
            tipo.setTipoOcorrenciaId(this.tipoOcorrenciaId);
            ocorrencia.setTipoOcorrencia(tipo);
        }

        return  ocorrencia;
    }

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public Integer getTipoOcorrenciaId() {
        return tipoOcorrenciaId;
    }

    public void setTipoOcorrenciaId(Integer tipoOcorrenciaId) {
        this.tipoOcorrenciaId = tipoOcorrenciaId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
