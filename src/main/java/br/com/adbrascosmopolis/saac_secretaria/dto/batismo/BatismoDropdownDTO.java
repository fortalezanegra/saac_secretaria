package br.com.adbrascosmopolis.saac_secretaria.dto.batismo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BatismoDropdownDTO {

    private Long batismoId;
    private String congregacao;
    private LocalDate dataBatismo;

    public BatismoDropdownDTO(
            Long batismoId,
            String congregacao,
            LocalDate dataBatismo
    ){
        this.batismoId = batismoId;
        this.congregacao = congregacao;
        this.dataBatismo = dataBatismo;
    }

    private static final DateTimeFormatter DATE_FMT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @JsonProperty("label")
    public String getLabel() {

        String cong = (congregacao != null) ? congregacao : "";
        String data = (dataBatismo != null)
                ? dataBatismo.format(DATE_FMT)
                : "";

        return String.format("%s - %s", cong, data);
    }

    public Long getBatismoId() {
        return batismoId;
    }

    public void setBatismoId(Long batismoId) {
        this.batismoId = batismoId;
    }

    public String getCongregacao() {
        return congregacao;
    }

    public void setCongregacao(String congregacao) {
        this.congregacao = congregacao;
    }

    public LocalDate getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDate dataBatismo) {
        this.dataBatismo = dataBatismo;
    }
}
