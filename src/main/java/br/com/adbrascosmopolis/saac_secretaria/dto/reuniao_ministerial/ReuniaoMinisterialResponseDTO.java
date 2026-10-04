package br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial;

import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReuniaoMinisterialResponseDTO {

    private Long reuniaoMinisterialId;
    private String tipoReuniao;
    private String congregacao;
    private LocalDate dataReuniao;
    private String situacao;

    public ReuniaoMinisterialResponseDTO(
            Long reuniaoMinisterialId,
            String tipoReuniao,
            String congregacao,
            LocalDate dataReuniao,
            String situacao
    ){
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.tipoReuniao = tipoReuniao;
        this.congregacao = congregacao;
        this.dataReuniao = dataReuniao;
        this.situacao = situacao;
    }

    public static ReuniaoMinisterialResponseDTO fromReuniaoMinisterial(ReuniaoMinisterial r){
        if(r == null) return null;

        return new ReuniaoMinisterialResponseDTO(
                r.getReuniaoMinisterialId(),
                r.getTipoReuniao() != null ? r.getTipoReuniao().getDescricao() : null,
                r.getCongregacao() != null ? r.getCongregacao().getNome() : null,
                r.getDataReuniao(),
                r.getSituacao() != null ? r.getSituacao().getDescricao() : null
        );
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
