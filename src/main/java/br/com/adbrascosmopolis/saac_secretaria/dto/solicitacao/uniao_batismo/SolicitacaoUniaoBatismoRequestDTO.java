package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_batismo;

import br.com.adbrascosmopolis.saac_secretaria.models.*;

import java.time.LocalDateTime;

public class SolicitacaoUniaoBatismoRequestDTO {

    private Long reuniaoMinisterialId;
    private Integer congregacaoSolicitanteId;
    private Integer tipoSolicitacaoId;
    private Long pessoaId;
    private Long candidatoBatismoId;
    private String historico;
    private Integer situacaoId;

    public SolicitacaoUniaoBatismoRequestDTO(
            Long reuniaoMinisterialId,
            Integer congregacaoSolicitanteId,
            Integer tipoSolicitacaoId,
            Long pessoaId,
            Long candidatoBatismoId,
            String historico,
            Integer situacaoId
    ){
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.tipoSolicitacaoId = tipoSolicitacaoId;
        this.pessoaId = pessoaId;
        this.candidatoBatismoId = candidatoBatismoId;
        this.historico = historico;
        this.situacaoId = situacaoId;
    }

    public Solicitacao mapToSolicitacao(){
        Solicitacao solicitacao = new Solicitacao();

        solicitacao.setHistorico(this.historico);

        /* ********************* */
        /* ** Relacionamentos ** */
        /* ********************* */

        //ReuniaoMinisterial
        if(this.reuniaoMinisterialId != null){
            ReuniaoMinisterial reuniao = new ReuniaoMinisterial();
            reuniao.setReuniaoMinisterialId(this.reuniaoMinisterialId);
            solicitacao.setReuniaoMinisterial(reuniao);
        }

        //CongregacaoSolicitante
        if(this.congregacaoSolicitanteId != null){
            Congregacao solicitante = new Congregacao();
            solicitante.setCongregacaoId(this.congregacaoSolicitanteId);
            solicitacao.setCongregacaoSolicitante(solicitante);
        }

        //TipoSolicitacao
        if(this.tipoSolicitacaoId != null){
            TipoSolicitacao tipo = new TipoSolicitacao();
            tipo.setTipoSolicitacaoId(this.tipoSolicitacaoId);
            solicitacao.setTipoSolicitacao(tipo);
        }

        //Pessoa
        if(this.pessoaId != null ){
            Pessoa pessoa = new Pessoa();
            pessoa.setPessoaId(this.pessoaId);
            solicitacao.setPessoa(pessoa);
        }

        //CandidatoBatismo
        if(this.candidatoBatismoId != null){
            CandidatoBatismo candidato = new CandidatoBatismo();
            candidato.setCandidatoBatismoId(this.candidatoBatismoId);
            solicitacao.setCandidatoBatismo(candidato);
        }

        //Situacao
        if(this.situacaoId != null){
            Situacao situacao = new Situacao();
            situacao.setSituacaoId(this.situacaoId);
            solicitacao.setSituacao(situacao);
        }

        return solicitacao;
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public Integer getCongregacaoSolicitanteId() {
        return congregacaoSolicitanteId;
    }

    public void setCongregacaoSolicitanteId(Integer congregacaoSolicitanteId) {
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
    }

    public Integer getTipoSolicitacaoId() {
        return tipoSolicitacaoId;
    }

    public void setTipoSolicitacaoId(Integer tipoSolicitacaoId) {
        this.tipoSolicitacaoId = tipoSolicitacaoId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Long getCandidatoBatismoId() {
        return candidatoBatismoId;
    }

    public void setCandidatoBatismoId(Long candidatoBatismoId) {
        this.candidatoBatismoId = candidatoBatismoId;
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
