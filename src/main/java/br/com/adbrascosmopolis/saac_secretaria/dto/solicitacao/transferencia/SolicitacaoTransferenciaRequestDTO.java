package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.transferencia;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao.CriarSolicitacaoTransferenciaCommand;
import jakarta.validation.constraints.NotNull;

public class SolicitacaoTransferenciaRequestDTO extends CriarSolicitacaoTransferenciaCommand {

    @NotNull
    private Integer congregacaoSolicitanteId;

    @NotNull
    private Long pessoaId;

    private String historico;

    @NotNull
    private Integer situacaoId;

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
    public Integer getSituacaoId() {
        return situacaoId;
    }

    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
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