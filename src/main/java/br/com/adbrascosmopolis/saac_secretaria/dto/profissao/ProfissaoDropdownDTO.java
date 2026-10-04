package br.com.adbrascosmopolis.saac_secretaria.dto.profissao;

public class ProfissaoDropdownDTO {
    private Integer profissaoId;
    private String descricao;

    public ProfissaoDropdownDTO(){}

    public ProfissaoDropdownDTO(Integer profissaoId, String descricao){
        this.profissaoId = profissaoId;
        this.descricao = descricao;
    }

    public Integer getProfissaoId() {
        return profissaoId;
    }

    public void setProfissaoId(Integer profissaoId) {
        this.profissaoId = profissaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
