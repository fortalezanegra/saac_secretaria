package br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria;

public class TipoVinculoSyncDTO {

    private Integer tipoVinculoId;
    private String descricao;

    public TipoVinculoSyncDTO(Integer tipoVinculoId, String descricao){
        this.tipoVinculoId = tipoVinculoId;
        this.descricao = descricao;
    }

    public Integer getTipoVinculoId() {
        return tipoVinculoId;
    }

    public void setTipoVinculoId(Integer tipoVinculoId) {
        this.tipoVinculoId = tipoVinculoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
