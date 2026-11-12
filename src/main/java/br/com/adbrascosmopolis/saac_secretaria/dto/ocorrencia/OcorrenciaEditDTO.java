package br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoOcorrencia;
import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;

import java.time.LocalDateTime;

public class OcorrenciaEditDTO {

    private Long ocorrenciaId;
    private Integer congregacaoId;
    private Long atividadeId;
    private TipoOcorrencia tipoOcorrencia;
    private Integer quantidade;
    private LocalDateTime deletedAt;

    public OcorrenciaEditDTO fromOcorrencia(Ocorrencia o){

        OcorrenciaEditDTO dto = new OcorrenciaEditDTO();

        dto.ocorrenciaId = o.getOcorrenciaId();
        dto.congregacaoId = o.getCongregacao() != null ? o.getCongregacao().getCongregacaoId() : null;
        dto.atividadeId = o.getAtividade() != null ? o.getAtividade().getAtividadeId() : null;
        dto.tipoOcorrencia = o.getTipoOcorrencia();
        dto.quantidade = o.getQuantidade();
        dto.deletedAt = o.getDeletedAt();

        return dto;
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

    public Long getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Long atividadeId) {
        this.atividadeId = atividadeId;
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
