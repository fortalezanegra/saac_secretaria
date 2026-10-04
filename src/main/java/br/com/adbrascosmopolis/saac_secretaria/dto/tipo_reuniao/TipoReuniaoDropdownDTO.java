package br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao;

public class TipoReuniaoDropdownDTO {

    private Integer tipoReuniaoId;
    private String descricao;

    public TipoReuniaoDropdownDTO(Integer tipoReuniaoId, String descricao){
        this.tipoReuniaoId = tipoReuniaoId;
        this.descricao = descricao;
    }

    public Integer getTipoReuniaoId() {
        return tipoReuniaoId;
    }

    public void setTipoReuniaoId(Integer tipoReuniaoId) {
        this.tipoReuniaoId = tipoReuniaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
