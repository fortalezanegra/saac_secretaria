package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.reconciliacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoReconciliacao;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoUniao;

public class SolicitacaoReconciliacaoEditDTO {

    private Long solicitacaoId;
    private Integer congregacaoSolicitanteId;
    private TipoSolicitacao tipoSolicitacao;
    private Long pessoaId;
    private String historico;
    private Integer situacaoId;

    public SolicitacaoReconciliacaoEditDTO(
            Long solicitacaoId,
            Integer congregacaoSolicitanteId,
            TipoSolicitacao tipoSolicitacao,
            Long pessoaId,
            String historico,
            Integer situacaoId
    ){
        this.solicitacaoId = solicitacaoId;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.tipoSolicitacao = tipoSolicitacao;
        this.pessoaId = pessoaId;
        this.historico = historico;
        this.situacaoId = situacaoId;
    }

    public static SolicitacaoReconciliacaoEditDTO fromSolicitacaoReconciliacao(SolicitacaoReconciliacao s){

        if(s == null){
            return null;
        }

        return new SolicitacaoReconciliacaoEditDTO(

                s.getSolicitacaoId(),
                s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                s.getTipoSolicitacao(),
                s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                s.getHistorico(),
                s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null
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

    public TipoSolicitacao getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
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
}
