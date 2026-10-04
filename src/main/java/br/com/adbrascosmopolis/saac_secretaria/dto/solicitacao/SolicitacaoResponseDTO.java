package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;

import java.time.LocalDateTime;

public class SolicitacaoResponseDTO {

    /* Identificacao */
    private Long solicitacaoId;
    private Long reuniaoMinisterialId;
    private String congregacaoSolicitante;
    private String tipoSolicitacao;
    private String pessoa;

    /*Solicitacao União por Batismo*/
    private String candidatoBatismo;

    /* Solicitacao União/Mudanca */
    private String igrejaOrigem;
    private String cargoIgrejaOrigem;
    private String cargoRecebido;

    /* Solicitação Transferencia */
    private String congregacaoOrigem;
    private String congregacaoDestino;

    /* Solicitação Desligamento */
    private String motivoDesligamento;

    private String historico;
    private String situacao;

    public SolicitacaoResponseDTO(
            Long solicitacaoId,
            Long reuniaoMinisterialId,
            String congregacaoSolicitante,
            String tipoSolicitacao,
            String pessoa,
            String candidatoBatismo,
            String igrejaOrigem,
            String cargoIgrejaOrigem,
            String cargoRecebido,
            String congregacaoOrigem,
            String congregacaoDestino,
            String motivoDesligamento,
            String historico,
            String situacao
    ){
        this.solicitacaoId = solicitacaoId;
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.congregacaoSolicitante = congregacaoSolicitante;
        this.tipoSolicitacao = tipoSolicitacao;
        this.pessoa = pessoa;
        this.candidatoBatismo = candidatoBatismo;
        this.igrejaOrigem = igrejaOrigem;
        this.cargoIgrejaOrigem = cargoIgrejaOrigem;
        this.cargoRecebido = cargoRecebido;
        this.congregacaoOrigem = congregacaoOrigem;
        this.congregacaoDestino = congregacaoDestino;
        this.motivoDesligamento = motivoDesligamento;
        this.historico = historico;
        this.situacao = situacao;
    }

    public static SolicitacaoResponseDTO fromSolicitacao(Solicitacao s){
        if(s == null) return null;

        return new SolicitacaoResponseDTO(
                s.getSolicitacaoId(),
                s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                s.getCongregacaoSolicitante().getNome(),
                s.getTipoSolicitacao() != null ? s.getTipoSolicitacao().getDescricao() : null,
                s.getPessoa() != null ? s.getPessoa().getNome() : null,
                s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getPessoa().getNome() : null,
                s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getDescricao() : null,
                s.getCargoIgrejaOrigem() != null ? s.getIgrejaOrigem().getDescricao() : null,
                s.getCargoRecebido() != null ? s.getCargoRecebido().getDescricao() : null,
                s.getCongregacaoOrigem() != null ? s.getCongregacaoOrigem().getNome() : null,
                s.getCongregacaoDestino() != null ? s.getCongregacaoDestino().getNome() : null,
                s.getMotivoDesligamento()!= null ? s.getMotivoDesligamento().getDescricao() : null,
                s.getHistorico(),
                s.getSituacao() != null ? s.getSituacao().getDescricao() : null
        );
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

    public String getCongregacaoSolicitante() {
        return congregacaoSolicitante;
    }

    public void setCongregacaoSolicitante(String congregacaoSolicitante) {
        this.congregacaoSolicitante = congregacaoSolicitante;
    }

    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(String tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getCandidatoBatismo() {
        return candidatoBatismo;
    }

    public void setCandidatoBatismo(String candidatoBatismo) {
        this.candidatoBatismo = candidatoBatismo;
    }

    public String getIgrejaOrigem() {
        return igrejaOrigem;
    }

    public void setIgrejaOrigem(String igrejaOrigem) {
        this.igrejaOrigem = igrejaOrigem;
    }

    public String getCargoIgrejaOrigem() {
        return cargoIgrejaOrigem;
    }

    public void setCargoIgrejaOrigem(String cargoIgrejaOrigem) {
        this.cargoIgrejaOrigem = cargoIgrejaOrigem;
    }

    public String getCargoRecebido() {
        return cargoRecebido;
    }

    public void setCargoRecebido(String cargoRecebido) {
        this.cargoRecebido = cargoRecebido;
    }

    public String getCongregacaoOrigem() {
        return congregacaoOrigem;
    }

    public void setCongregacaoOrigem(String congregacaoOrigem) {
        this.congregacaoOrigem = congregacaoOrigem;
    }

    public String getCongregacaoDestino() {
        return congregacaoDestino;
    }

    public void setCongregacaoDestino(String congregacaoDestino) {
        this.congregacaoDestino = congregacaoDestino;
    }

    public String getMotivoDesligamento() {
        return motivoDesligamento;
    }

    public void setMotivoDesligamento(String motivoDesligamento) {
        this.motivoDesligamento = motivoDesligamento;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
