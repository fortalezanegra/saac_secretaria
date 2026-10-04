package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.models.*;

import java.time.LocalDateTime;

public class SolicitacaoRequestDTO {

    /* Identificacao */
    //private Integer solicitacaoId;
    private Long reuniaoMinisterialId;
    private Integer congregacaoSolicitanteId;
    private Integer tipoSolicitacaoId;
    private Long pessoaId;

    /*Solicitacao União por Batismo*/
    private Long candidatoBatismoId;

    /* Solicitacao União/Mudanca */
    private Integer igrejaOrigemId;
    private Integer cargoIgrejaOrigemId;
    private Integer cargoRecebidoId;

    /* Solicitação Transferencia */
    private Integer congregacaoOrigemId;
    private Integer congregacaoDestinoId;

    /* Solicitação Desligamento */
    private Integer motivoDesligamentoId;

    private String historico;
    private Integer situacaoId;
    private LocalDateTime deletedAt;

    public SolicitacaoRequestDTO(
            Long reuniaoMinisterialId,
            Integer congregacaoSolicitanteId,
            Integer tipoSolicitacaoId,
            Long pessoaId,
            Long candidatoBatismoId,
            Integer igrejaOrigemId,
            Integer cargoIgrejaOrigemId,
            Integer cargoRecebidoId,
            Integer congregacaoOrigemId,
            Integer congregacaoDestinoId,
            Integer motivoDesligamentoId,
            String historico,
            Integer situacaoId,
            LocalDateTime deletedAt
    ){
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.tipoSolicitacaoId = tipoSolicitacaoId;
        this.pessoaId = pessoaId;
        this.candidatoBatismoId = candidatoBatismoId;
        this.igrejaOrigemId = igrejaOrigemId;
        this.cargoIgrejaOrigemId = cargoIgrejaOrigemId;
        this.cargoRecebidoId = cargoRecebidoId;
        this.congregacaoOrigemId = congregacaoOrigemId;
        this.congregacaoDestinoId = congregacaoDestinoId;
        this.motivoDesligamentoId = motivoDesligamentoId;
        this.historico = historico;
        this.situacaoId = situacaoId;
        this.deletedAt = deletedAt;
    }

    public Solicitacao mapToSolicitacao(){

        Solicitacao solicitacao = new Solicitacao();

        solicitacao.setHistorico(this.historico);
        solicitacao.setDeletedAt(this.deletedAt);

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

        //IgrejaOrigem
        if(this.igrejaOrigemId != null){
            IgrejaOrigem igreja = new IgrejaOrigem();
            igreja.setIgrejaOrigemId(this.igrejaOrigemId);
            solicitacao.setIgrejaOrigem(igreja);
        }

        //CargoIgrejaOrigem
        if(this.cargoIgrejaOrigemId != null){
            CargoMinisterial cargoOrigem = new CargoMinisterial();
            cargoOrigem.setCargoMinisterialId(this.cargoIgrejaOrigemId);
            solicitacao.setCargoIgrejaOrigem(cargoOrigem);
        }

        //CargoRecebido
        if(this.cargoRecebidoId != null){
            CargoMinisterial cargoRecebido = new CargoMinisterial();
            cargoRecebido.setCargoMinisterialId(this.cargoRecebidoId);
            solicitacao.setCargoRecebido(cargoRecebido);
        }

        //CongregacaoOrigem
        if(this.congregacaoOrigemId != null){
            Congregacao congregacaoOrigem = new Congregacao();
            congregacaoOrigem.setCongregacaoId(this.congregacaoOrigemId);
            solicitacao.setCongregacaoOrigem(congregacaoOrigem);
        }

        //CongregacaoDestino
        if(this.congregacaoDestinoId != null){
            Congregacao congregacaoDestino = new Congregacao();
            congregacaoDestino.setCongregacaoId(this.congregacaoDestinoId);
            solicitacao.setCongregacaoDestino(congregacaoDestino);
        }

        //MotivoDesligamento
        if(this.motivoDesligamentoId != null){
            MotivoDesligamento motivo = new MotivoDesligamento();
            motivo.setMotivoDesligamentoId(this.motivoDesligamentoId);
            solicitacao.setMotivoDesligamento(motivo);
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

    public Integer getIgrejaOrigemId() {
        return igrejaOrigemId;
    }

    public void setIgrejaOrigemId(Integer igrejaOrigemId) {
        this.igrejaOrigemId = igrejaOrigemId;
    }

    public Integer getCargoIgrejaOrigemId() {
        return cargoIgrejaOrigemId;
    }

    public void setCargoIgrejaOrigemId(Integer cargoIgrejaOrigemId) {
        this.cargoIgrejaOrigemId = cargoIgrejaOrigemId;
    }

    public Integer getCargoRecebidoId() {
        return cargoRecebidoId;
    }

    public void setCargoRecebidoId(Integer cargoRecebidoId) {
        this.cargoRecebidoId = cargoRecebidoId;
    }

    public Integer getCongregacaoOrigemId() {
        return congregacaoOrigemId;
    }

    public void setCongregacaoOrigemId(Integer congregacaoOrigemId) {
        this.congregacaoOrigemId = congregacaoOrigemId;
    }

    public Integer getCongregacaoDestinoId() {
        return congregacaoDestinoId;
    }

    public void setCongregacaoDestinoId(Integer congregacaoDestinoId) {
        this.congregacaoDestinoId = congregacaoDestinoId;
    }

    public Integer getMotivoDesligamentoId() {
        return motivoDesligamentoId;
    }

    public void setMotivoDesligamentoId(Integer motivoDesligamentoId) {
        this.motivoDesligamentoId = motivoDesligamentoId;
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
