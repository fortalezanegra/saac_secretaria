package br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;

/**
 * Classe-base abstrata com os dados comuns a todos os comandos
 * de criação de solicitação.
 */
public abstract class CriarSolicitacaoCommand {

    private Integer congregacaoSolicitanteId;
    private Long pessoaId;
    private String historico;
    private Integer situacaoId;

    protected CriarSolicitacaoCommand() {
    }

    protected CriarSolicitacaoCommand(
            Integer congregacaoSolicitanteId,
            Long pessoaId,
            String historico,
            Integer situacaoId) {

        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.pessoaId = pessoaId;
        this.historico = historico;
        this.situacaoId = situacaoId;
    }

    public Integer getCongregacaoSolicitanteId() {
        return congregacaoSolicitanteId;
    }

    public void setCongregacaoSolicitanteId(Integer congregacaoSolicitanteId) {
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
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

    public abstract TipoSolicitacao getTipoSolicitacao();
}
