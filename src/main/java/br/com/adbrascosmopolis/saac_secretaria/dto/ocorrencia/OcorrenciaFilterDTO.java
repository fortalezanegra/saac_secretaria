package br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoOcorrencia;

public class OcorrenciaFilterDTO {

    private Long ocorrenciaId;
    private Integer congregacaoId;
    private Long eventoId;
    private TipoOcorrencia tipoOcorrencia;

    public OcorrenciaFilterDTO(){}

    public OcorrenciaFilterDTO(Long ocorrenciaId, Integer congregacaoId, Long eventoId, TipoOcorrencia tipoOcorrencia){
        this.ocorrenciaId = ocorrenciaId;
        this.congregacaoId = congregacaoId;
        this.eventoId = eventoId;
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public Long getOcorrenciaId() {
        return ocorrenciaId;
    }

    public void setOcorrenciaId(Long ocorrenciaId) {
        this.ocorrenciaId = ocorrenciaId;
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
}
