package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.mudanca;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao.CriarSolicitacaoMudancaCommand;
import jakarta.validation.constraints.NotNull;

public class SolicitacaoMudancaRequestDTO extends CriarSolicitacaoMudancaCommand {

    @NotNull
    private Integer congregacaoSolicitanteId;

    @NotNull
    private Long pessoaId;

    private String historico;

    private SituacaoSolicitacao situacao;

    @NotNull
    private Integer igrejaOrigemId;

    private Integer cargoIgrejaOrigemId;

    private Integer cargoRecebidoId;

    @Override
    public Integer getCongregacaoSolicitanteId() {
        return congregacaoSolicitanteId;
    }

    @Override
    public void setCongregacaoSolicitanteId(Integer congregacaoSolicitanteId) {
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
    }

    @Override
    public Long getPessoaId() {
        return pessoaId;
    }

    @Override
    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String getHistorico() {
        return historico;
    }

    @Override
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
    public Integer getIgrejaOrigemId() {
        return igrejaOrigemId;
    }

    public void setIgrejaOrigemId(Integer igrejaOrigemId) {
        this.igrejaOrigemId = igrejaOrigemId;
    }

    @Override
    public Integer getCargoIgrejaOrigemId() {
        return cargoIgrejaOrigemId;
    }

    public void setCargoIgrejaOrigemId(Integer cargoIgrejaOrigemId) {
        this.cargoIgrejaOrigemId = cargoIgrejaOrigemId;
    }

    @Override
    public Integer getCargoRecebidoId() {
        return cargoRecebidoId;
    }

    public void setCargoRecebidoId(Integer cargoRecebidoId) {
        this.cargoRecebidoId = cargoRecebidoId;
    }
}
