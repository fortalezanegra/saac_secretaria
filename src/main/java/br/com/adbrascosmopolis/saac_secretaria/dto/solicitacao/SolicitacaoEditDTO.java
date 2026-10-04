package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;

import java.time.LocalDateTime;

public class SolicitacaoEditDTO {

    /* Identificacao */
    private Long solicitacaoId;
    private Long reuniaoMinisterialId;
    private Integer congregacaoSolicitanteId;
    private Integer tipoSolicitacaoId;
    private Long pessoaId;

    /*Solicitacao União por Batismo*/
    private Long candidatoBatismoId;

    /* Solicitacao União/Mudanca */
    private Integer igrejaOrigemId;
    private Integer cargoIgrejaOrigemId;
    private Integer cargoRecebidoId;

    /* Solicitação Transferencia */
    private Integer congregacaoOrigemId;
    private Integer congregacaoDestinoId;

    /* Solicitação Desligamento */
    private Integer motivoDesligamentoId;

    private String historico;
    private Integer situacaoId;
    private LocalDateTime deletedAt;

    public static SolicitacaoEditDTO fromSolicitacao(Solicitacao s){

        SolicitacaoEditDTO dto = new SolicitacaoEditDTO();

        dto.solicitacaoId = s.getSolicitacaoId();
        dto.reuniaoMinisterialId = s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null;
        dto.congregacaoSolicitanteId = s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null;
        dto.tipoSolicitacaoId = s.getTipoSolicitacao() != null ? s.getTipoSolicitacao().getTipoSolicitacaoId() : null;
        dto.pessoaId = s.getPessoa() != null ? s.getPessoa().getPessoaId() : null;
        dto.candidatoBatismoId = s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getCandidatoBatismoId() : null;
        dto.igrejaOrigemId = s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getIgrejaOrigemId() : null;
        dto.cargoIgrejaOrigemId = s.getCargoIgrejaOrigem() != null ? s.getCargoIgrejaOrigem().getCargoMinisterialId() : null;
        dto.cargoRecebidoId = s.getCargoRecebido() != null ? s.getCargoRecebido().getCargoMinisterialId() : null;
        dto.congregacaoOrigemId = s.getCongregacaoOrigem() != null ? s.getCongregacaoOrigem().getCongregacaoId() : null;
        dto.congregacaoDestinoId = s.getCongregacaoDestino() != null ? s.getCongregacaoDestino().getCongregacaoId() : null;
        dto.motivoDesligamentoId = s.getMotivoDesligamento() != null ? s.getMotivoDesligamento().getMotivoDesligamentoId() : null;
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

    public Integer getIgrejaOrigemId() {
        return igrejaOrigemId;
    }

    public void setIgrejaOrigemId(Integer igrejaOrigemId) {
        this.igrejaOrigemId = igrejaOrigemId;
    }

    public Integer getCargoIgrejaOrigemId() {
        return cargoIgrejaOrigemId;
    }

    public void setCargoIgrejaOrigemId(Integer cargoIgrejaOrigemId) {
        this.cargoIgrejaOrigemId = cargoIgrejaOrigemId;
    }

    public Integer getCargoRecebidoId() {
        return cargoRecebidoId;
    }

    public void setCargoRecebidoId(Integer cargoRecebidoId) {
        this.cargoRecebidoId = cargoRecebidoId;
    }

    public Integer getCongregacaoOrigemId() {
        return congregacaoOrigemId;
    }

    public void setCongregacaoOrigemId(Integer congregacaoOrigemId) {
        this.congregacaoOrigemId = congregacaoOrigemId;
    }

    public Integer getCongregacaoDestinoId() {
        return congregacaoDestinoId;
    }

    public void setCongregacaoDestinoId(Integer congregacaoDestinoId) {
        this.congregacaoDestinoId = congregacaoDestinoId;
    }

    public Integer getMotivoDesligamentoId() {
        return motivoDesligamentoId;
    }

    public void setMotivoDesligamentoId(Integer motivoDesligamentoId) {
        this.motivoDesligamentoId = motivoDesligamentoId;
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


