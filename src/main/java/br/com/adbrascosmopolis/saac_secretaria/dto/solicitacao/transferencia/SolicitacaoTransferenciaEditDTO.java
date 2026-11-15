package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.transferencia;

import br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao.CriarSolicitacaoTransferenciaCommand;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoTransferencia;

public class SolicitacaoTransferenciaEditDTO extends CriarSolicitacaoTransferenciaCommand {

    private Long solicitacaoId;
    private Integer congregacaoSolicitanteId;
    private Long pessoaId;
    private String historico;
    private Integer situacaoId;
    private Integer congregacaoOrigemId;
    private Integer congregacaoDestinoId;

    public static SolicitacaoTransferenciaEditDTO fromSolicitacaoTransferencia(SolicitacaoTransferencia s){

        SolicitacaoTransferenciaEditDTO dto = new SolicitacaoTransferenciaEditDTO();

        dto.solicitacaoId = s.getSolicitacaoId();
        dto.congregacaoSolicitanteId = s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null;
        dto.pessoaId = s.getPessoa() != null ? s.getPessoa().getPessoaId() : null;
        dto.historico = s.getHistorico();
        dto.situacaoId = s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null;
        dto.congregacaoOrigemId = s.getCongregacaoOrigem() != null ? s.getCongregacaoOrigem().getCongregacaoId() : null;
        dto.congregacaoDestinoId = s.getCongregacaoDestino() != null ? s.getCongregacaoDestino().getCongregacaoId() : null;

        return dto;
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    @Override
    public Integer getCongregacaoSolicitanteId() {
        return congregacaoSolicitanteId;
    }

    @Override
    public void setCongregacaoSolicitanteId(Integer congregacaoSolicitanteId) {
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
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
    public Integer getSituacaoId() {
        return situacaoId;
    }

    @Override
    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
    }

    @Override
    public Integer getCongregacaoOrigemId() {
        return congregacaoOrigemId;
    }

    public void setCongregacaoOrigemId(Integer congregacaoOrigemId) {
        this.congregacaoOrigemId = congregacaoOrigemId;
    }

    @Override
    public Integer getCongregacaoDestinoId() {
        return congregacaoDestinoId;
    }

    public void setCongregacaoDestinoId(Integer congregacaoDestinoId) {
        this.congregacaoDestinoId = congregacaoDestinoId;
    }
}