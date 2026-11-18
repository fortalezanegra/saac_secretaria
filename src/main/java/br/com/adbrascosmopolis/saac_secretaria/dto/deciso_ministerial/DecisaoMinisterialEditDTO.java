package br.com.adbrascosmopolis.saac_secretaria.dto.deciso_ministerial;

import br.com.adbrascosmopolis.saac_secretaria.models.DecisaoMinisterial;

public class DecisaoMinisterialEditDTO {

    private Long decisaoMinisterialId;
    private Long reuniaoMinisterialId;
    private Long solicitacaoId;
    private String historico;
    private Integer situacaoId;

    private static DecisaoMinisterialEditDTO fromDecisaoMinisterial(DecisaoMinisterial d){

        DecisaoMinisterialEditDTO dto = new DecisaoMinisterialEditDTO();

        dto.decisaoMinisterialId = d.getDecisaoMinisterialId();
        dto.reuniaoMinisterialId = d.getReuniaoMinisterial() != null ? d.getReuniaoMinisterial().getReuniaoMinisterialId() : null;
        dto.solicitacaoId = d.getSolicitacao() != null ? d.getSolicitacao().getSolicitacaoId() : null;
        dto.historico = d.getHistorico();
        dto.situacaoId = d.getSituacao() != null ? d.getSituacao().getSituacaoId() : null;

        return dto;
    }

    public Long getDecisaoMinisterialId() {
        return decisaoMinisterialId;
    }

    public void setDecisaoMinisterialId(Long decisaoMinisterialId) {
        this.decisaoMinisterialId = decisaoMinisterialId;
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Integer getSituacaoId() {
        return situacaoId;
    }

    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
    }
}
