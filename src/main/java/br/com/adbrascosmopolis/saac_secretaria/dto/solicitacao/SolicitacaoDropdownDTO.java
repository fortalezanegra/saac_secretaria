package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;

public class SolicitacaoDropdownDTO {

    private Long solicitacaoId;
    private String congregacaoSolicitante;
    private TipoSolicitacao tipoSolicitacao;
    private String pessoa;
    private String situacao;

    public SolicitacaoDropdownDTO(){}

    public SolicitacaoDropdownDTO(
            Long solicitacaoId,
            String congregacaoSolicitante,
            TipoSolicitacao tipoSolicitacao,
            String pessoa,
            String situacao
    ){
        this.solicitacaoId = solicitacaoId;
        this.congregacaoSolicitante = congregacaoSolicitante;
        this.tipoSolicitacao = tipoSolicitacao;
        this.pessoa = pessoa;
        this.situacao = situacao;
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public String getCongregacaoSolicitante() {
        return congregacaoSolicitante;
    }

    public void setCongregacaoSolicitante(String congregacaoSolicitante) {
        this.congregacaoSolicitante = congregacaoSolicitante;
    }

    public TipoSolicitacao getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
