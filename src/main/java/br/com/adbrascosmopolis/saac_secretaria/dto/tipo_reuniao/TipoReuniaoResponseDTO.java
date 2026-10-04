package br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao;

import br.com.adbrascosmopolis.saac_secretaria.models.TipoReuniao;

public class TipoReuniaoResponseDTO {

    private Integer tipoReuniaoId;
    private String descricao;

    public TipoReuniaoResponseDTO(Integer tipoReuniaoId, String descricao){
        this.tipoReuniaoId = tipoReuniaoId;
        this.descricao = descricao;
    }

    public static TipoReuniaoResponseDTO fromTipoReuniao(TipoReuniao t){
        if(t == null) return null;

        return new TipoReuniaoResponseDTO(
                t.getTipoReuniaoId(),
                t.getDescricao()
        );
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
