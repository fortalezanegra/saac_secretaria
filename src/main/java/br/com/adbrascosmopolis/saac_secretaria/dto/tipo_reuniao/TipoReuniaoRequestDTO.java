package br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao;

import br.com.adbrascosmopolis.saac_secretaria.models.TipoReuniao;

public class TipoReuniaoRequestDTO {

    private String descricao;

    public TipoReuniaoRequestDTO(String descricao){
        this.descricao = descricao;
    }

    public TipoReuniao mapToTipoReuniao(){
        TipoReuniao tipoReuniao = new TipoReuniao();

        tipoReuniao.setDescricao(this.descricao);

        return tipoReuniao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
