package br.com.adbrascosmopolis.saac_secretaria.dto.deciso_ministerial;

import br.com.adbrascosmopolis.saac_secretaria.models.DecisaoMinisterial;

public class DecisaoMinisterialResponseDTO {

    private Long decisaoMinisterialId;
    private Long reuniaoMinisterialId;
    private Long solicitacaoId;
    private String historico;
    private Integer situacaoId;

    public DecisaoMinisterialResponseDTO(
            Long decisaoMinisterialId,
            Long reuniaoMinisterialId,
            Long solicitacaoId,
            String historico,
            Integer situacaoId
    ){
        this.decisaoMinisterialId = decisaoMinisterialId;
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.solicitacaoId = solicitacaoId;
        this.historico = historico;
        this.situacaoId = situacaoId;
    }

    public static DecisaoMinisterialResponseDTO fromDecisaoMinisterial(DecisaoMinisterial d){
        if(d == null) return null;

        return new DecisaoMinisterialResponseDTO(
                d.getDecisaoMinisterialId(),
                d.getReuniaoMinisterial() != null ? d.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                d.getSolicitacao() != null ? d.getSolicitacao().getSolicitacaoId() : null,
                d.getHistorico(),
                d.getSituacao() != null ? d.getSituacao().getSituacaoId() : null
        );
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
