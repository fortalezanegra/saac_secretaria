package br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoReuniao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReuniaoMinisterialDropdownDTO {

    private static final DateTimeFormatter DATE_FMT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long reuniaoMinisterialId;
    private TipoReuniao tipoReuniao;
    private String congregacao;
    private LocalDate dataReuniao;

    public ReuniaoMinisterialDropdownDTO() {
    }

    public ReuniaoMinisterialDropdownDTO(
            Long reuniaoMinisterialId,
            TipoReuniao tipoReuniao,
            String congregacao,
            LocalDate dataReuniao) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.tipoReuniao = tipoReuniao;
        this.congregacao = congregacao;
        this.dataReuniao = dataReuniao;
    }

    @JsonProperty("label")
    public String getLabel() {
        String tipo = tipoReuniao != null ? tipoReuniao.name() : "";
        String nomeCongregacao = congregacao != null ? congregacao : "";
        String data = dataReuniao != null
                ? dataReuniao.format(DATE_FMT)
                : "";

        return String.format("%s - %s - %s", tipo, nomeCongregacao, data);
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    @JsonIgnore
    public TipoReuniao getTipoReuniao() {
        return tipoReuniao;
    }

    public void setTipoReuniao(TipoReuniao tipoReuniao) {
        this.tipoReuniao = tipoReuniao;
    }

    @JsonIgnore
    public String getCongregacao() {
        return congregacao;
    }

    public void setCongregacao(String congregacao) {
        this.congregacao = congregacao;
    }

    @JsonIgnore
    public LocalDate getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(LocalDate dataReuniao) {
        this.dataReuniao = dataReuniao;
    }
}
