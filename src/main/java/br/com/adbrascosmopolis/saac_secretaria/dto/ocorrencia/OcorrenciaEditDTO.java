package br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia;

import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;

import java.time.LocalDateTime;

public class OcorrenciaEditDTO {

    private Integer ocorrenciaId;
    private Integer eventoId;
    private Integer tipoOcorrenciaId;
    private Integer quantidade;
    private LocalDateTime deletedAt;

    public OcorrenciaEditDTO fromOcorrencia(Ocorrencia o){

        OcorrenciaEditDTO dto = new OcorrenciaEditDTO();

        dto.ocorrenciaId = o.getOcorrenciaId();
        dto.eventoId = o.getEvento() != null ? o.getEvento().getEventoId() : null;
        dto.tipoOcorrenciaId = o.getTipoOcorrencia() != null ? o.getTipoOcorrencia().getTipoOcorrenciaId() : null;
        dto.quantidade = o.getQuantidade();
        dto.deletedAt = o.getDeletedAt();

        return dto;
    }

    public Integer getOcorrenciaId() {
        return ocorrenciaId;
    }

    public void setOcorrenciaId(Integer ocorrenciaId) {
        this.ocorrenciaId = ocorrenciaId;
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
