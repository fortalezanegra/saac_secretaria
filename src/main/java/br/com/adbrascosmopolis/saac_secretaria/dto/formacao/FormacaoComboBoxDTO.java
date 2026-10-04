package br.com.adbrascosmopolis.saac_secretaria.dto.formacao;

public class FormacaoComboBoxDTO {

    private Integer formacaoId;
    private String descricao;

    public FormacaoComboBoxDTO(){}

    public FormacaoComboBoxDTO(Integer formacaoId, String descricao){
        this.formacaoId = formacaoId;
        this.descricao = descricao;
    }

    public Integer getFormacaoId() {
        return formacaoId;
    }

    public void setFormacaoId(Integer formacaoId) {
        this.formacaoId = formacaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
