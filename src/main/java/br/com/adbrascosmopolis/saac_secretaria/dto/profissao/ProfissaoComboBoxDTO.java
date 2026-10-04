package br.com.adbrascosmopolis.saac_secretaria.dto.profissao;

public class ProfissaoComboBoxDTO {
    private Integer profissaoId;
    private String descricao;

    public ProfissaoComboBoxDTO(){}

    public ProfissaoComboBoxDTO(Integer profissaoId, String descricao){
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
