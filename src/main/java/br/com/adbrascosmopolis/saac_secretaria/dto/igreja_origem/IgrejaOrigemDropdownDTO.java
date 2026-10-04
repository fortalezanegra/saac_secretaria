package br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem;

public class IgrejaOrigemDropdownDTO {

    private Integer igrejaOrigemId;
    private String descricao;

    public IgrejaOrigemDropdownDTO(
            Integer igrejaOrigemId,
            String descricao
    ){
        this.igrejaOrigemId = igrejaOrigemId;
        this.descricao = descricao;
    }

    public Integer getIgrejaOrigemId() {
        return igrejaOrigemId;
    }

    public void setIgrejaOrigemId(Integer igrejaOrigemId) {
        this.igrejaOrigemId = igrejaOrigemId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
