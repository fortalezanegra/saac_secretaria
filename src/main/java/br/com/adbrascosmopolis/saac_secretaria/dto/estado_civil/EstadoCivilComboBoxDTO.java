package br.com.adbrascosmopolis.saac_secretaria.dto.estado_civil;

public class EstadoCivilComboBoxDTO {

    private Integer estadoCivilId;
    private String descricao;

    public EstadoCivilComboBoxDTO(){}

    public EstadoCivilComboBoxDTO(Integer estadoCivilId, String descricao){
        this.estadoCivilId = estadoCivilId;
        this.descricao = descricao;
    }

    public Integer getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(Integer estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
