package br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia;

import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;

public class OcorrenciaResponseDTO {

    private Integer ocorrenciaId;
    private String evento;
    private Integer eventoId;
    private String tipoOcorrencia;
    private Integer tipoOcorrenciaId;
    private Integer quantidade;

    public OcorrenciaResponseDTO(
            Integer ocorrenciaId,
            String evento,
            Integer eventoId,
            String tipoOcorrencia,
            Integer tipoOcorrenciaId,
            Integer quantidade
    ){
        this.ocorrenciaId = ocorrenciaId;
        this.evento = evento;
        this.eventoId = eventoId;
        this.tipoOcorrencia = tipoOcorrencia;
        this.tipoOcorrenciaId = tipoOcorrenciaId;
        this.quantidade = quantidade;
    }

    public static OcorrenciaResponseDTO fromOcorrencia(Ocorrencia o){
        if(o == null) return null;

        return new OcorrenciaResponseDTO(

                o.getOcorrenciaId(),
                o.getEvento() != null ? o.getEvento().getDescricao()  : null,
                o.getEvento() != null ? o.getEvento().getEventoId() : null,
                o.getTipoOcorrencia() != null ? o.getTipoOcorrencia().getDescricao() : null,
                o.getTipoOcorrencia() != null ? o.getTipoOcorrencia().getTipoOcorrenciaId() : null,
                o.getQuantidade()
        );
    }

    public Integer getOcorrenciaId() {
        return ocorrenciaId;
    }

    public void setOcorrenciaId(Integer ocorrenciaId) {
        this.ocorrenciaId = ocorrenciaId;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public String getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(String tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
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
