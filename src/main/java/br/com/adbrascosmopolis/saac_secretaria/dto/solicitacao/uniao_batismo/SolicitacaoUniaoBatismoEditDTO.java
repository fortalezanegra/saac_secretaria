package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_batismo;

import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import java.time.LocalDateTime;

public class SolicitacaoUniaoBatismoEditDTO {

    private Long solicitacaoId;
    private Long reuniaoMinisterialId;
    private Integer congregacaoSolicitanteId;
    private Integer tipoSolicitacaoId;
    private Long pessoaId;
    private Long candidatoBatismoId;
    private String  historico;
    private Integer situacaoId;
    private LocalDateTime deletedAt;

    public static SolicitacaoUniaoBatismoEditDTO fromSolicitacao(Solicitacao s){

        SolicitacaoUniaoBatismoEditDTO dto = new SolicitacaoUniaoBatismoEditDTO();

        dto.solicitacaoId = s.getSolicitacaoId();
        dto.reuniaoMinisterialId = s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null;
        dto.congregacaoSolicitanteId = s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null;
        dto.tipoSolicitacaoId = s.getTipoSolicitacao() != null ? s.getTipoSolicitacao().getTipoSolicitacaoId() : null;
        dto.pessoaId = s.getPessoa() != null ? s.getPessoa().getPessoaId() : null;
        dto.candidatoBatismoId = s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getCandidatoBatismoId() : null;
        dto.historico = s.getHistorico();
        dto.situacaoId = s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null;
        dto.deletedAt = s.getDeletedAt();

        return dto;
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public Integer getCongregacaoSolicitanteId() {
        return congregacaoSolicitanteId;
    }

    public void setCongregacaoSolicitanteId(Integer congregacaoSolicitanteId) {
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
    }

    public Integer getTipoSolicitacaoId() {
        return tipoSolicitacaoId;
    }

    public void setTipoSolicitacaoId(Integer tipoSolicitacaoId) {
        this.tipoSolicitacaoId = tipoSolicitacaoId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Long getCandidatoBatismoId() {
        return candidatoBatismoId;
    }

    public void setCandidatoBatismoId(Long candidatoBatismoId) {
        this.candidatoBatismoId = candidatoBatismoId;
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
