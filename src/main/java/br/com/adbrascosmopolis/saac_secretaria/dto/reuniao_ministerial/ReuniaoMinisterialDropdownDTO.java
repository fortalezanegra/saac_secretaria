package br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReuniaoMinisterialDropdownDTO {

    private Long reuniaoMinisterialId;
    private String tipoReuniao;
    private String congregacao;
    private LocalDate dataReuniao;

    public ReuniaoMinisterialDropdownDTO(
            Long reuniaoMinisterialId,
            String tipoReuniao,
            String congregacao,
            LocalDate dataReuniao) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.tipoReuniao = tipoReuniao;
        this.congregacao = congregacao;
        this.dataReuniao = dataReuniao;
    }

    private static final DateTimeFormatter DATE_FMT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @JsonProperty("label")
    public String getLabel() {

        String tipo = (tipoReuniao != null) ? tipoReuniao : "";
        String cong = (congregacao != null) ? congregacao : "";
        String data = (dataReuniao != null)
                ? dataReuniao.format(DATE_FMT)
                : "";

        return String.format("%s - %s - %s", tipo, cong, data);
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public String getTipoReuniao() {
        return tipoReuniao;
    }

    public void setTipoReuniao(String tipoReuniao) {
        this.tipoReuniao = tipoReuniao;
    }

    public String getCongregacao() {
        return congregacao;
    }

    public void setCongregacao(String congregacao) {
        this.congregacao = congregacao;
    }

    public LocalDate getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(LocalDate dataReuniao) {
        this.dataReuniao = dataReuniao;
    }


}
