package br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem;

import br.com.adbrascosmopolis.saac_secretaria.models.IgrejaOrigem;

public class IgrejaOrigemRequestDTO {

    private String descricao;

    public IgrejaOrigemRequestDTO(String descricao){
        this.descricao = descricao;
    }

    public IgrejaOrigem mapToIgrejaOrigem(){
        IgrejaOrigem igreja = new IgrejaOrigem();

        igreja.setDescricao(this.descricao);

        return igreja;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
