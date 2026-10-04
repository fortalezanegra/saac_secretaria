package br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AtaReuniaoDropdownDTO {

    private Long ataReuniaoId;
    private Long reuniaoMinisterialId;
    private String descricao;
    private LocalDate dataAta;

    public AtaReuniaoDropdownDTO(
            Long ataReuniaoId,
            Long reuniaoMinisterialId,
            String descricao,
            LocalDate dataAta){
        this.ataReuniaoId = ataReuniaoId;
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.descricao = descricao;
        this.dataAta = dataAta;
    }

    @JsonProperty("label")
    public String getLabel() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String desc = (descricao != null) ? descricao : "";
        String data = (dataAta != null) ? dataAta.format(fmt) : "";
        String reuniaoId = (reuniaoMinisterialId != null) ? reuniaoMinisterialId.toString() : "";

        return desc + " - " + data + " - Id Reunião: " + reuniaoId;
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
}
