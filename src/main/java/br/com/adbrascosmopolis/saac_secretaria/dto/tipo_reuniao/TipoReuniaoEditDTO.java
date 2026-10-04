package br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao;

import br.com.adbrascosmopolis.saac_secretaria.models.TipoReuniao;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TipoReuniaoEditDTO {

    private Integer tipoReuniaoId;
    private String descricao;
    private LocalDateTime deletedAt;
    private Integer modifiedBy;

    public static TipoReuniaoEditDTO fromTipoReuniao(TipoReuniao t){
        TipoReuniaoEditDTO dto = new TipoReuniaoEditDTO();

        dto.tipoReuniaoId = t.getTipoReuniaoId();
        dto.descricao = t.getDescricao();
        dto.deletedAt = t.getDeletedAt();
        dto.modifiedBy = t.getModifiedBy();

        return dto;
    }

    public Integer getTipoReuniaoId() {
        return tipoReuniaoId;
    }

    public void setTipoReuniaoId(Integer tipoReuniaoId) {
        this.tipoReuniaoId = tipoReuniaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
