package br.com.adbrascosmopolis.saac_secretaria.dto.cargo_ministerial;


public class CargoMinisterialDropdownDTO {

    public Integer cargoMinisterialId;
    public String descricao;

    public CargoMinisterialDropdownDTO(){}

    public CargoMinisterialDropdownDTO(Integer cargoMinisterialId, String descricao){
        this.cargoMinisterialId = cargoMinisterialId;
        this.descricao = descricao;
    }

    public Integer getCargoMinisterialId() {
        return cargoMinisterialId;
    }

    public void setCargoMinisterialId(Integer cargoMinisterialId) {
        this.cargoMinisterialId = cargoMinisterialId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
