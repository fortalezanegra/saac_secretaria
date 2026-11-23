package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoUniao;

public class SolicitacaoUniaoEditDTO {

    private Long solicitacaoId;
    private Integer congregacaoSolicitanteId;
    private TipoSolicitacao tipoSolicitacao;
    private Long pessoaId;
    private String historico;
    private SituacaoSolicitacao situacao;

    public SolicitacaoUniaoEditDTO(
            Long solicitacaoId,
            Integer congregacaoSolicitanteId,
            TipoSolicitacao tipoSolicitacao,
            Long pessoaId,
            String historico,
            SituacaoSolicitacao situacao
    ){
        this.solicitacaoId = solicitacaoId;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.tipoSolicitacao = tipoSolicitacao;
        this.pessoaId = pessoaId;
        this.historico = historico;
        this.situacao = situacao;
    }

    public static SolicitacaoUniaoEditDTO fromSolicitacaoUniao(SolicitacaoUniao s){

        if(s == null){
            return null;
        }

        return new SolicitacaoUniaoEditDTO(

                s.getSolicitacaoId(),
                s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                s.getTipoSolicitacao(),
                s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                s.getHistorico(),
                s.getSituacao()
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

    public SituacaoSolicitacao getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoSolicitacao situacao) {
        this.situacao = situacao;
    }
}
