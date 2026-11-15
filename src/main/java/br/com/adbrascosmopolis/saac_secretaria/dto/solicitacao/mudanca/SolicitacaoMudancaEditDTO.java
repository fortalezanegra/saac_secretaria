package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.mudanca;

import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoMudanca;

public class SolicitacaoMudancaEditDTO {

    private Long solicitacaoId;
    private Integer congregacaoSolicitanteId;
    private Long pessoaId;
    private String historico;
    private Integer situacaoId;;
    private Integer igrejaOrigemId;
    private Integer cargoIgrejaOrigemId;
    private Integer cargoRecebidoId;

    public SolicitacaoMudancaEditDTO(
            Long solicitacaoId,
            Integer congregacaoSolicitanteId,
            Long pessoaId,
            String historico,
            Integer situacaoId,
            Integer igrejaOrigemId,
            Integer cargoIgrejaOrigemId,
            Integer cargoRecebidoId
    ){
        this.solicitacaoId = solicitacaoId;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.pessoaId = pessoaId;
        this.historico = historico;
        this.situacaoId = situacaoId;
        this.igrejaOrigemId = igrejaOrigemId;
        this.cargoIgrejaOrigemId = cargoIgrejaOrigemId;
        this.cargoRecebidoId = cargoRecebidoId;
    }

    public static SolicitacaoMudancaEditDTO fromSolicitacaoMudanca(SolicitacaoMudanca s){

        if (s == null) {
            return null;
        }

        return new SolicitacaoMudancaEditDTO(
                s.getSolicitacaoId(),
                s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                s.getHistorico(),
                s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null,
                s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getIgrejaOrigemId() : null,
                s.getCargoIgrejaOrigem() != null ? s.getCargoIgrejaOrigem().getCargoMinisterialId() : null,
                s.getCargoRecebido() != null ? s.getCargoRecebido().getCargoMinisterialId() : null
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
}
