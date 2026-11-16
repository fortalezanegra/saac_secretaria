package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.desligamento;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoDesligamento;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoUniao;

public class SolicitacaoDesligamentoResponseDTO {

    private Long solicitacaoId;
    private Integer congregacaoSolicitanteId;
    private String congregacaoSolicitante;
    private TipoSolicitacao tipoSolicitacao;
    private Long pessoaId;
    private String pessoa;
    private Integer motivoDesligamentoId;
    private String motivoDesligamento;
    private String historico;
    private Integer situacaoId;
    private String situacao;

    public SolicitacaoDesligamentoResponseDTO(
            Long solicitacaoId,
            Integer congregacaoSolicitanteId,
            String congregacaoSolicitante,
            TipoSolicitacao tipoSolicitacao,
            Long pessoaId,
            String pessoa,
            Integer motivoDesligamentoId,
            String motivoDesligamento,
            String historico,
            Integer situacaoId,
            String situacao
    ){
        this.solicitacaoId = solicitacaoId;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.congregacaoSolicitante = congregacaoSolicitante;
        this.tipoSolicitacao = tipoSolicitacao;
        this.pessoaId = pessoaId;
        this.pessoa = pessoa;
        this.motivoDesligamentoId = motivoDesligamentoId;
        this.motivoDesligamento = motivoDesligamento;
        this.historico = historico;
        this.situacaoId = situacaoId;
        this.situacao = situacao;
    }

    public static SolicitacaoDesligamentoResponseDTO fromSolicitacaoDesligamento(SolicitacaoDesligamento s){

        if(s == null){
            return null;
        }

        return new SolicitacaoDesligamentoResponseDTO(

                s.getSolicitacaoId(),
                s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getNome() : null,
                s.getTipoSolicitacao(),
                s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                s.getPessoa() != null ? s.getPessoa().getNome() : null,
                s.getMotivoDesligamento() != null ? s.getMotivoDesligamento().getMotivoDesligamentoId() : null,
                s.getMotivoDesligamento() != null ? s.getMotivoDesligamento().getDescricao() : null,
                s.getHistorico(),
                s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null,
                s.getSituacao() != null ? s.getSituacao().getDescricao() : null
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

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getMotivoDesligamentoId() {
        return motivoDesligamentoId;
    }

    public void setMotivoDesligamentoId(Integer motivoDesligamentoId) {
        this.motivoDesligamentoId = motivoDesligamentoId;
    }

    public String getMotivoDesligamento() {
        return motivoDesligamento;
    }

    public void setMotivoDesligamento(String motivoDesligamento) {
        this.motivoDesligamento = motivoDesligamento;
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
}
