package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.transferencia;

import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoTransferencia;

public class SolicitacaoTransferenciaResponseDTO {

    private Long solicitacaoId;
    private Integer congregacaoSolicitanteId;
    private String congregacaoSolicitante;
    private String tipoSolicitacao;
    private Long pessoaId;
    private String pessoa;
    private String historico;
    private Integer situacaoId;
    private String situacao;
    private Integer congregacaoOrigemId;
    private String congregacaoOrigem;
    private Integer congregacaoDestinoId;
    private String congregacaoDestino;

    public SolicitacaoTransferenciaResponseDTO(
            Long solicitacaoId,
            Integer congregacaoSolicitanteId,
            String congregacaoSolicitante,
            String tipoSolicitacao,
            Long pessoaId,
            String pessoa,
            String historico,
            Integer situacaoId,
            String situacao,
            Integer congregacaoOrigemId,
            String congregacaoOrigem,
            Integer congregacaoDestinoId,
            String congregacaoDestino) {

        this.solicitacaoId = solicitacaoId;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.congregacaoSolicitante = congregacaoSolicitante;
        this.tipoSolicitacao = tipoSolicitacao;
        this.pessoaId = pessoaId;
        this.pessoa = pessoa;
        this.historico = historico;
        this.situacaoId = situacaoId;
        this.situacao = situacao;
        this.congregacaoOrigemId = congregacaoOrigemId;
        this.congregacaoOrigem = congregacaoOrigem;
        this.congregacaoDestinoId = congregacaoDestinoId;
        this.congregacaoDestino = congregacaoDestino;
    }

    public static SolicitacaoTransferenciaResponseDTO fromSolicitacao(SolicitacaoTransferencia solicitacao) {

        if (solicitacao == null) {
            return null;
        }

        return new SolicitacaoTransferenciaResponseDTO(

                solicitacao.getSolicitacaoId(),

                solicitacao.getCongregacaoSolicitante() != null
                        ? solicitacao.getCongregacaoSolicitante().getCongregacaoId()
                        : null,
                solicitacao.getCongregacaoSolicitante() != null
                        ? solicitacao.getCongregacaoSolicitante().getNome()
                        : null,

                solicitacao.getTipoSolicitacao() != null
                        ? solicitacao.getTipoSolicitacao().name()
                        : null,

                solicitacao.getPessoa() != null
                        ? solicitacao.getPessoa().getPessoaId()
                        : null,
                solicitacao.getPessoa() != null
                        ? solicitacao.getPessoa().getNome()
                        : null,

                solicitacao.getHistorico(),

                solicitacao.getSituacao() != null
                        ? solicitacao.getSituacao().getSituacaoId()
                        : null,
                solicitacao.getSituacao() != null
                        ? solicitacao.getSituacao().getDescricao()
                        : null,

                solicitacao.getCongregacaoOrigem() != null
                        ? solicitacao.getCongregacaoOrigem().getCongregacaoId()
                        : null,
                solicitacao.getCongregacaoOrigem() != null
                        ? solicitacao.getCongregacaoOrigem().getNome()
                        : null,

                solicitacao.getCongregacaoDestino() != null
                        ? solicitacao.getCongregacaoDestino().getCongregacaoId()
                        : null,
                solicitacao.getCongregacaoDestino() != null
                        ? solicitacao.getCongregacaoDestino().getNome()
                        : null
        );
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public Integer getCongregacaoSolicitanteId() {
        return congregacaoSolicitanteId;
    }

    public void setCongregacaoSolicitanteId(Integer congregacaoSolicitanteId) {
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
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

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getCongregacaoOrigemId() {
        return congregacaoOrigemId;
    }

    public void setCongregacaoOrigemId(Integer congregacaoOrigemId) {
        this.congregacaoOrigemId = congregacaoOrigemId;
    }

    public String getCongregacaoOrigem() {
        return congregacaoOrigem;
    }

    public void setCongregacaoOrigem(String congregacaoOrigem) {
        this.congregacaoOrigem = congregacaoOrigem;
    }

    public Integer getCongregacaoDestinoId() {
        return congregacaoDestinoId;
    }

    public void setCongregacaoDestinoId(Integer congregacaoDestinoId) {
        this.congregacaoDestinoId = congregacaoDestinoId;
    }

    public String getCongregacaoDestino() {
        return congregacaoDestino;
    }

    public void setCongregacaoDestino(String congregacaoDestino) {
        this.congregacaoDestino = congregacaoDestino;
    }

}
