package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoReuniao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;

import java.time.LocalDate;

public class SolicitacaoResponseDTO {

    private Long solicitacaoId;
    private Long reuniaoMinisterialId;
    private TipoReuniao tipoReuniao;
    private LocalDate dataReuniao;
    private Integer congregacaoSolicitanteId;
    private String congregacaoSolicitante;
    private TipoSolicitacao tipoSolicitacao;
    private Long pessoaId;
    private String pessoa;
    private SituacaoSolicitacao situacao;

    public SolicitacaoResponseDTO(
            Long solicitacaoId,
            Long reuniaoMinisterialId,
            TipoReuniao tipoReuniao,
            LocalDate dataReuniao,
            Integer congregacaoSolicitanteId,
            String congregacaoSolicitante,
            TipoSolicitacao tipoSolicitacao,
            Long pessoaId,
            String pessoa,
            SituacaoSolicitacao situacao
    ){
        this.solicitacaoId = solicitacaoId;
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.tipoReuniao = tipoReuniao;
        this.dataReuniao = dataReuniao;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.congregacaoSolicitante = congregacaoSolicitante;
        this.tipoSolicitacao = tipoSolicitacao;
        this.pessoaId = pessoaId;
        this.pessoa = pessoa;
        this.situacao = situacao;
    }

    public static SolicitacaoResponseDTO fromSolicitacao(Solicitacao s){

        if(s == null) return null;

        return new SolicitacaoResponseDTO(
                s.getSolicitacaoId(),
                s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getTipoReuniao() : null,
                s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getDataReuniao() : null,
                s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getNome() : null,
                s.getTipoSolicitacao(),
                s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                s.getPessoa() != null ? s.getPessoa().getNome() : null,
                s.getSituacao()
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

    public TipoReuniao getTipoReuniao() {
        return tipoReuniao;
    }

    public void setTipoReuniao(TipoReuniao tipoReuniao) {
        this.tipoReuniao = tipoReuniao;
    }

    public LocalDate getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(LocalDate dataReuniao) {
        this.dataReuniao = dataReuniao;
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

    public SituacaoSolicitacao getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoSolicitacao situacao) {
        this.situacao = situacao;
    }
}
