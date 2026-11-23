package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao.CriarSolicitacaoUniaoCommand;
import jakarta.validation.constraints.NotNull;

public class SolicitacaoUniaoRequestDTO extends CriarSolicitacaoUniaoCommand {

    @NotNull
    private Integer congregacaoSolicitanteId;

    @NotNull
    private TipoSolicitacao tipoSolicitacao;

    @NotNull
    private Long pessoaId;

    private String historico;

    private SituacaoSolicitacao situacao;

    @Override
    public Integer getCongregacaoSolicitanteId() {
        return congregacaoSolicitanteId;
    }

    @Override
    public void setCongregacaoSolicitanteId(Integer congregacaoSolicitanteId) {
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
    }

    @Override
    public TipoSolicitacao getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
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
}
