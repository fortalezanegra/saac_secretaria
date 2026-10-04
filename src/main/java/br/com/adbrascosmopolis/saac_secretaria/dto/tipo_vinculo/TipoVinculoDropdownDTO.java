package br.com.adbrascosmopolis.saac_secretaria.dto.tipo_vinculo;

public class TipoVinculoDropdownDTO {

    private Integer tipoVinculoId;
    private String descricao;

    public TipoVinculoDropdownDTO(){}

    public TipoVinculoDropdownDTO(Integer tipoVinculoId, String descricao){
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

