package br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial;

import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReuniaoMinisterialEditDTO {

    private Long reuniaoMinisterialId;
    private Integer tipoReuniaoId;
    private Integer congregacaoId;
    private LocalDate dataReuniao;
    private Integer situacaoId;
    private LocalDateTime deletedAt;

    public static ReuniaoMinisterialEditDTO fromReuniaoMinisterial(ReuniaoMinisterial r){

        ReuniaoMinisterialEditDTO dto = new ReuniaoMinisterialEditDTO();

        dto.reuniaoMinisterialId = r.getReuniaoMinisterialId();
        dto.tipoReuniaoId = r.getTipoReuniao() != null ? r.getTipoReuniao().getTipoReuniaoId() : null;
        dto.congregacaoId = r.getCongregacao() != null ? r.getCongregacao().getCongregacaoId() : null;
        dto.dataReuniao = r.getDataReuniao();
        dto.situacaoId = r.getSituacao() != null ? r.getSituacao().getSituacaoId() : null;
        dto.deletedAt = r.getDeletedAt();

        return dto;
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public Integer getTipoReuniaoId() {
        return tipoReuniaoId;
    }

    public void setTipoReuniaoId(Integer tipoReuniaoId) {
        this.tipoReuniaoId = tipoReuniaoId;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public LocalDate getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(LocalDate dataReuniao) {
        this.dataReuniao = dataReuniao;
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
