package br.com.adbrascosmopolis.saac_secretaria.dto.tipo_solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.models.TipoSolicitacao;

public class TipoSolicitacaoDropdownDTO {

    private Integer tipoSolicitacaoId;
    private String descricao;

    public TipoSolicitacaoDropdownDTO(
            Integer tipoSolicitacaoId,
            String descricao
    ){
        this.tipoSolicitacaoId = tipoSolicitacaoId;
        this.descricao = descricao;
    }

    public Integer getTipoSolicitacaoId() {
        return tipoSolicitacaoId;
    }

    public void setTipoSolicitacaoId(Integer tipoSolicitacaoId) {
        this.tipoSolicitacaoId = tipoSolicitacaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
