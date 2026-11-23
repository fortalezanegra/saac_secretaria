package br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoReuniao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;

import java.time.LocalDate;

public class ReuniaoMinisterialResponseDTO {

    private Long reuniaoMinisterialId;
    private TipoReuniao tipoReuniao;
    private Integer congregacaoId;
    private String congregacao;
    private LocalDate dataReuniao;
    private SituacaoReuniaoMinisterial situacao;

    public ReuniaoMinisterialResponseDTO(
            Long reuniaoMinisterialId,
            TipoReuniao tipoReuniao,
            Integer congregacaoId,
            String congregacao,
            LocalDate dataReuniao,
            SituacaoReuniaoMinisterial situacao
    ){
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.tipoReuniao = tipoReuniao;
        this.congregacaoId = congregacaoId;
        this.congregacao = congregacao;
        this.dataReuniao = dataReuniao;
        this.situacao = situacao;
    }

    public static ReuniaoMinisterialResponseDTO fromReuniaoMinisterial(ReuniaoMinisterial r){
        if(r == null) return null;

        return new ReuniaoMinisterialResponseDTO(
                r.getReuniaoMinisterialId(),
                r.getTipoReuniao(),
                r.getCongregacao() != null ? r.getCongregacao().getCongregacaoId() : null,
                r.getCongregacao() != null ? r.getCongregacao().getNome() : null,
                r.getDataReuniao(),
                r.getSituacao()
        );
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public TipoReuniao getTipoReuniao() {
        return tipoReuniao;
    }

    public void setTipoReuniao(TipoReuniao tipoReuniao) {
        this.tipoReuniao = tipoReuniao;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
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

    public SituacaoReuniaoMinisterial getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoReuniaoMinisterial situacao) {
        this.situacao = situacao;
    }
}
