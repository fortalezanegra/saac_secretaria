package br.com.adbrascosmopolis.saac_secretaria.dto.sexo;

public class SexoComboBoxDTO {

    private Integer sexoId;
    private String descricao;

    public SexoComboBoxDTO(){}

    public SexoComboBoxDTO(Integer sexoId, String descricao){
        this.sexoId = sexoId;
        this.descricao = descricao;
    }

    public Integer getSexoId() {
        return sexoId;
    }

    public void setSexoId(Integer sexoId) {
        this.sexoId = sexoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
