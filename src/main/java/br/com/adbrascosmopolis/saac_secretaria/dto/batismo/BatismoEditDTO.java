package br.com.adbrascosmopolis.saac_secretaria.dto.batismo;

import br.com.adbrascosmopolis.saac_secretaria.models.Batismo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BatismoEditDTO {

    private Long batismoId;
    private Integer congregacaoId;
    private LocalDate dataBatismo;
    private Integer situacaoId;
    private LocalDateTime deletedAt;

    public static BatismoEditDTO fromBatismo(Batismo b){
        BatismoEditDTO dto = new BatismoEditDTO();

        dto.batismoId = b.getBatismoId();
        dto.congregacaoId = b.getCongregacao() != null ? b.getCongregacao().getCongregacaoId() : null;
        dto.dataBatismo = b.getDataBatismo();
        dto.situacaoId = b.getSituacao() != null ? b.getSituacao().getSituacaoId() : null;
        dto.deletedAt = b.getDeletedAt();

        return dto;
    }

    public Long getBatismoId() {
        return batismoId;
    }

    public void setBatismoId(Long batismoId) {
        this.batismoId = batismoId;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public LocalDate getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDate dataBatismo) {
        this.dataBatismo = dataBatismo;
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
