package br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoOcorrencia;
import br.com.adbrascosmopolis.saac_secretaria.models.Evento;
import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;

public class OcorrenciaRequestDTO {

    private Integer congregacaoId;
    private Long eventoId;
    private TipoOcorrencia tipoOcorrencia;
    private Integer quantidade;

    public OcorrenciaRequestDTO(
            Integer congregacaoId,
            Long eventoId,
            TipoOcorrencia tipoOcorrencia,
            Integer quantidade
    ){
        this.congregacaoId = congregacaoId;
        this.eventoId = eventoId;
        this.tipoOcorrencia = tipoOcorrencia;
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

        return  ocorrencia;
    }


    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public TipoOcorrencia getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
