package br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao;

import br.com.adbrascosmopolis.saac_secretaria.models.AtaReuniao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AtaReuniaoEditDTO {

    private Long ataReuniaoId;
    private Long reuniaoMinisterialId;
    private String descricao;
    private LocalDate dataAta;
    private String urlData;
    private Integer situacaoId;
    private LocalDateTime deletedAt;

    public static AtaReuniaoEditDTO fromAtaReuniao(AtaReuniao a){
        AtaReuniaoEditDTO dto = new AtaReuniaoEditDTO();

        dto.ataReuniaoId = a.getAtaReuniaoId();
        dto.reuniaoMinisterialId = a.getReuniaoMinisterial().getReuniaoMinisterialId();
        dto.descricao = a.getDescricao();
        dto.dataAta = a.getDataAta();
        dto.urlData = a.getUrlAta();
        dto.situacaoId = a.getSituacao().getSituacaoId();
        dto.deletedAt = a.getDeletedAt();

        return dto;
    }

    public Long getAtaReuniaoId() {
        return ataReuniaoId;
    }

    public void setAtaReuniaoId(Long ataReuniaoId) {
        this.ataReuniaoId = ataReuniaoId;
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAta() {
        return dataAta;
    }

    public void setDataAta(LocalDate dataAta) {
        this.dataAta = dataAta;
    }

    public String getUrlData() {
        return urlData;
    }

    public void setUrlData(String urlData) {
        this.urlData = urlData;
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
