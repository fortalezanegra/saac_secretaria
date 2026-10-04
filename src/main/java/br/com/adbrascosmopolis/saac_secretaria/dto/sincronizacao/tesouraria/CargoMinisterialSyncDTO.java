package br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria;

public class CargoMinisterialSyncDTO {

    private Integer cargoMinisterialId;
    private String descricao;

    public CargoMinisterialSyncDTO(Integer cargoMinisterialId, String descricao){
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
