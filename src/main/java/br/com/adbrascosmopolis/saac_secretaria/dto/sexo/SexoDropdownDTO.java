package br.com.adbrascosmopolis.saac_secretaria.dto.sexo;

public class SexoDropdownDTO {

    private Integer sexoId;
    private String descricao;

    public SexoDropdownDTO(){}

    public SexoDropdownDTO(Integer sexoId, String descricao){
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
