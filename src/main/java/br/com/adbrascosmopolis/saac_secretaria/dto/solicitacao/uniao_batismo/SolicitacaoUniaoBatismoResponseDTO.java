package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_batismo;

import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;

public class SolicitacaoUniaoBatismoResponseDTO {

    private Long solicitacaoId;
    private Long reuniaoMinisterialId;
    private String reuniaoMinisterial;
    private Integer congregacaoSolicitanteId;
    private String congregacaoSolicitante;
    private Integer tipoSolicitacaoId;
    private String tipoSolicitacao;
    private Long pessoaId;
    private String pessoa;
    private Long candidatoBatismoId;
    private String candidatoBatismo;
    private String historico;
    private Integer situacaoId;
    private String situacao;

    public SolicitacaoUniaoBatismoResponseDTO(
            Long solicitacaoId,
            Long reuniaoMinisterialId,
            String  reuniaoMinisterial,
            Integer congregacaoSolicitanteId,
            String  congregacaoSolicitante,
            Integer tipoSolicitacaoId,
            String tipoSolicitacao,
            Long pessoaId,
            String pessoa,
            Long candidatoBatismoId,
            String candidatoBatismo,
            String historico,
            Integer situacaoId,
            String situacao
    ){
        this.solicitacaoId = solicitacaoId;
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.reuniaoMinisterial = reuniaoMinisterial;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.congregacaoSolicitante = congregacaoSolicitante;
        this.tipoSolicitacaoId = tipoSolicitacaoId;
        this.tipoSolicitacao = tipoSolicitacao;
        this.pessoaId = pessoaId;
        this.pessoa = pessoa;
        this.candidatoBatismoId = candidatoBatismoId;
        this.candidatoBatismo = candidatoBatismo;
        this.historico = historico;
        this.situacaoId = situacaoId;
        this.situacao = situacao;
    }

    public static SolicitacaoUniaoBatismoResponseDTO fromSolicitacao(Solicitacao s){
        if(s == null) return null;

        return new SolicitacaoUniaoBatismoResponseDTO(
                s.getSolicitacaoId(),
                s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getTipoReuniao().getDescricao() : null,
                s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                s.getCongregacaoSolicitante().getNome(),
                s.getTipoSolicitacao() != null ? s.getTipoSolicitacao().getTipoSolicitacaoId() : null,
                s.getTipoSolicitacao().getDescricao(),
                s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                s.getPessoa() != null ? s.getPessoa().getNome() : null,
                s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getCandidatoBatismoId() : null,
                s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getPessoa().getNome() : null,
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

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public String getReuniaoMinisterial() {
        return reuniaoMinisterial;
    }

    public void setReuniaoMinisterial(String reuniaoMinisterial) {
        this.reuniaoMinisterial = reuniaoMinisterial;
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

    public Integer getTipoSolicitacaoId() {
        return tipoSolicitacaoId;
    }

    public void setTipoSolicitacaoId(Integer tipoSolicitacaoId) {
        this.tipoSolicitacaoId = tipoSolicitacaoId;
    }

    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(String tipoSolicitacao) {
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

    public Long getCandidatoBatismoId() {
        return candidatoBatismoId;
    }

    public void setCandidatoBatismoId(Long candidatoBatismoId) {
        this.candidatoBatismoId = candidatoBatismoId;
    }

    public String getCandidatoBatismo() {
        return candidatoBatismo;
    }

    public void setCandidatoBatismo(String candidatoBatismo) {
        this.candidatoBatismo = candidatoBatismo;
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
