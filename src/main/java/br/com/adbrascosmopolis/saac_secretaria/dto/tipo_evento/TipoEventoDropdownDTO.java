package br.com.adbrascosmopolis.saac_secretaria.dto.tipo_evento;

public class TipoEventoDropdownDTO {

    private Integer tipoEventoId;
    private String descricao;

    public TipoEventoDropdownDTO(Integer tipoEventoId, String descricao){
        this. tipoEventoId = tipoEventoId;
        this.descricao = descricao;
    }

    public Integer getTipoEventoId() {
        return tipoEventoId;
    }

    public void setTipoEventoId(Integer tipoEventoId) {
        this.tipoEventoId = tipoEventoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
