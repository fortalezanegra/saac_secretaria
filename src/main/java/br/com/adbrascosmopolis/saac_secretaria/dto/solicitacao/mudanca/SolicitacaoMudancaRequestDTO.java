package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.mudanca;

import br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao.CriarSolicitacaoMudancaCommand;
import jakarta.validation.constraints.NotNull;

public class SolicitacaoMudancaRequestDTO extends CriarSolicitacaoMudancaCommand {

    @NotNull
    private Integer congregacaoSolicitanteId;

    @NotNull
    private Long pessoaId;

    private String historico;

    @NotNull
    private Integer situacaoId;

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
    public Integer getSituacaoId() {
        return situacaoId;
    }

    @Override
    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
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
