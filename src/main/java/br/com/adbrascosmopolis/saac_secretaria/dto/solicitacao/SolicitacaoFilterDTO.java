package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao;

public class SolicitacaoFilterDTO {

    Long solicitacaoId;

    public SolicitacaoFilterDTO(){}

    public SolicitacaoFilterDTO(Long solicitacaoId){ this.solicitacaoId = solicitacaoId; }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }
}
