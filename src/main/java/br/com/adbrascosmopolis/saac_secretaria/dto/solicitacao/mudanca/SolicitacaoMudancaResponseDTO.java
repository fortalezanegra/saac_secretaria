package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.mudanca;

import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoMudanca;
import jakarta.validation.constraints.NotNull;

public class SolicitacaoMudancaResponseDTO {

    private Long solicitacaoId;
    private Integer congregacaoSolicitanteId;
    private String congregacaoSolicitante;
    private Long pessoaId;
    private String pessoa;
    private String historico;
    private Integer situacaoId;
    private String situacao;
    private Integer igrejaOrigemId;
    private String igrejaOrigem;
    private Integer cargoIgrejaOrigemId;
    private String cargoIgrejaOrigem;
    private Integer cargoRecebidoId;
    private String cargoRecebido;

    public SolicitacaoMudancaResponseDTO(
            Long solicitacaoId,
            Integer congregacaoSolicitanteId,
            String congregacaoSolicitante,
            Long pessoaId,
            String pessoa,
            String historico,
            Integer situacaoId,
            String situacao,
            Integer igrejaOrigemId,
            String igrejaOrigem,
            Integer cargoIgrejaOrigemId,
            String cargoIgrejaOrigem,
            Integer cargoRecebidoId,
            String cargoRecebido
    ){
        this.solicitacaoId = solicitacaoId;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.congregacaoSolicitante = congregacaoSolicitante;
        this.pessoaId = pessoaId;
        this.pessoa = pessoa;
        this.historico = historico;
        this.situacaoId = situacaoId;
        this.situacao = situacao;
        this.igrejaOrigemId = igrejaOrigemId;
        this.igrejaOrigem = igrejaOrigem;
        this.cargoIgrejaOrigemId = cargoIgrejaOrigemId;
        this.cargoIgrejaOrigem = cargoIgrejaOrigem;
        this.cargoRecebidoId = cargoRecebidoId;
        this.cargoRecebido = cargoRecebido;
    }

    public static SolicitacaoMudancaResponseDTO fromSolicitacaoMudanca(SolicitacaoMudanca s){

        if (s == null) {
            return null;
        }

        return new SolicitacaoMudancaResponseDTO(
                s.getSolicitacaoId(),
                s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getNome() : null,
                s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                s.getPessoa() != null ? s.getPessoa().getNome() : null,
                s.getHistorico(),
                s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null,
                s.getSituacao() != null ? s.getSituacao().getDescricao() : null,
                s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getIgrejaOrigemId() : null,
                s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getDescricao() : null,
                s.getCargoIgrejaOrigem() != null ? s.getCargoIgrejaOrigem().getCargoMinisterialId() : null,
                s.getCargoIgrejaOrigem() != null ? s.getCargoIgrejaOrigem().getDescricao() : null,
                s.getCargoRecebido() != null ? s.getCargoRecebido().getCargoMinisterialId() : null,
                s.getCargoRecebido() != null ? s.getCargoRecebido().getDescricao() : null
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

    public Integer getIgrejaOrigemId() {
        return igrejaOrigemId;
    }

    public void setIgrejaOrigemId(Integer igrejaOrigemId) {
        this.igrejaOrigemId = igrejaOrigemId;
    }

    public String getIgrejaOrigem() {
        return igrejaOrigem;
    }

    public void setIgrejaOrigem(String igrejaOrigem) {
        this.igrejaOrigem = igrejaOrigem;
    }

    public Integer getCargoIgrejaOrigemId() {
        return cargoIgrejaOrigemId;
    }

    public void setCargoIgrejaOrigemId(Integer cargoIgrejaOrigemId) {
        this.cargoIgrejaOrigemId = cargoIgrejaOrigemId;
    }

    public String getCargoIgrejaOrigem() {
        return cargoIgrejaOrigem;
    }

    public void setCargoIgrejaOrigem(String cargoIgrejaOrigem) {
        this.cargoIgrejaOrigem = cargoIgrejaOrigem;
    }

    public Integer getCargoRecebidoId() {
        return cargoRecebidoId;
    }

    public void setCargoRecebidoId(Integer cargoRecebidoId) {
        this.cargoRecebidoId = cargoRecebidoId;
    }

    public String getCargoRecebido() {
        return cargoRecebido;
    }

    public void setCargoRecebido(String cargoRecebido) {
        this.cargoRecebido = cargoRecebido;
    }

}
