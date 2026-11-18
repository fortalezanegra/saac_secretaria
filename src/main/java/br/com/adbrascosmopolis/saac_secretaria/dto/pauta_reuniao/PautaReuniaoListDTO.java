package br.com.adbrascosmopolis.saac_secretaria.dto.pauta_reuniao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoReuniao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.projection.DecisaoMinisterialResumo;

import java.time.LocalDate;
import java.util.Locale;

public class PautaReuniaoListDTO {

    private Long decisaoMinisterialId;
    private TipoReuniao tipoReuniao;
    private LocalDate dataReuniao;
    private Integer congregacaoSolicitanteId;
    private String congregacaoSolicitante;
    private TipoSolicitacao tipoSolicitacao;
    private Long pessoaId;
    private String pessoa;
    private Integer situacaoSolicitacaoId;
    private String situacaoSolicitacao;

    PautaReuniaoListDTO(
            Long decisaoMinisterialId,
            TipoReuniao tipoReuniao,
            LocalDate dataReuniao,
            Integer congregacaoSolicitanteId,
            String congregacaoSolicitante,
            TipoSolicitacao tipoSolicitacao,
            Long pessoaId,
            String pessoa,
            Integer situacaoSolicitacaoId,
            String situacaoSolicitacao
    ){
        this.decisaoMinisterialId = decisaoMinisterialId;
        this.tipoReuniao = tipoReuniao;
        this.dataReuniao = dataReuniao;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.congregacaoSolicitante = congregacaoSolicitante;
        this.tipoSolicitacao = tipoSolicitacao;
        this.pessoaId = pessoaId;
        this.pessoa = pessoa;
        this.situacaoSolicitacaoId = situacaoSolicitacaoId;
        this.situacaoSolicitacao = situacaoSolicitacao;
    }


    public static PautaReuniaoListDTO fromDecisaoMinisterialResumo(
            DecisaoMinisterialResumo d) {

        if (d == null) {
            return null;
        }

        return new PautaReuniaoListDTO(
                d.getDecisaoMinisterialId(),
                converterTipoReuniao(d.getTipoReuniao()),
                d.getDataReuniao(),
                d.getCongregacaoSolicitanteId(),
                d.getCongregacaoSolicitante(),
                converterTipoSolicitacao(d.getTipoSolicitacao()),
                d.getPessoaId(),
                d.getPessoa(),
                d.getSituacaoSolicitacaoId(),
                d.getSituacaoSolicitacao()
        );
    }

    private static TipoReuniao converterTipoReuniao(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        return TipoReuniao.valueOf(valor.trim().toUpperCase(Locale.ROOT));
    }

    private static TipoSolicitacao converterTipoSolicitacao(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        return TipoSolicitacao.valueOf(valor.trim().toUpperCase(Locale.ROOT));
    }

    public Long getDecisaoMinisterialId() {
        return decisaoMinisterialId;
    }

    public void setDecisaoMinisterialId(Long decisaoMinisterialId) {
        this.decisaoMinisterialId = decisaoMinisterialId;
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

    public Integer getSituacaoSolicitacaoId() {
        return situacaoSolicitacaoId;
    }

    public void setSituacaoSolicitacaoId(Integer situacaoSolicitacaoId) {
        this.situacaoSolicitacaoId = situacaoSolicitacaoId;
    }

    public String getSituacaoSolicitacao() {
        return situacaoSolicitacao;
    }

    public void setSituacaoSolicitacao(String situacaoSolicitacao) {
        this.situacaoSolicitacao = situacaoSolicitacao;
    }
}
