package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.transferencia;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao.CriarSolicitacaoTransferenciaCommand;
import jakarta.validation.constraints.NotNull;

public class SolicitacaoTransferenciaRequestDTO extends CriarSolicitacaoTransferenciaCommand {

    @NotNull
    private Integer congregacaoSolicitanteId;

    @NotNull
    private Long pessoaId;

    private String historico;

    private SituacaoSolicitacao situacao;

    @NotNull
    private Integer congregacaoOrigemId;

    @NotNull
    private Integer congregacaoDestinoId;

    @Override
    public Integer getCongregacaoSolicitanteId() {
        return congregacaoSolicitanteId;
    }

    public void setCongregacaoSolicitanteId(Integer congregacaoSolicitanteId) {
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
    }

    @Override
    public TipoSolicitacao getTipoSolicitacao() {
        return TipoSolicitacao.TRANSFERENCIA;
    }

    @Override
    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    @Override
    public SituacaoSolicitacao getSituacao() {
        return situacao;
    }

    @Override
    public void setSituacao(SituacaoSolicitacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public Integer getCongregacaoOrigemId() {
        return congregacaoOrigemId;
    }

    public void setCongregacaoOrigemId(Integer congregacaoOrigemId) {
        this.congregacaoOrigemId = congregacaoOrigemId;
    }

    @Override
    public Integer getCongregacaoDestinoId() {
        return congregacaoDestinoId;
    }

    public void setCongregacaoDestinoId(Integer congregacaoDestinoId) {
        this.congregacaoDestinoId = congregacaoDestinoId;
    }
}