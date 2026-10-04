package br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem;

import br.com.adbrascosmopolis.saac_secretaria.models.IgrejaOrigem;

public class IgrejaOrigemResponseDTO {

    private Integer igrejaOrigemId;
    private String descricao;

    public IgrejaOrigemResponseDTO(
            Integer igrejaOrigemId,
            String descricao){
        this.igrejaOrigemId = igrejaOrigemId;
        this.descricao = descricao;
    }

    public static IgrejaOrigemResponseDTO fromIgrejaOrigem(IgrejaOrigem i){
        if(i == null) return null;

        return new IgrejaOrigemResponseDTO(
                i.getIgrejaOrigemId(),
                i.getDescricao()
        );
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
