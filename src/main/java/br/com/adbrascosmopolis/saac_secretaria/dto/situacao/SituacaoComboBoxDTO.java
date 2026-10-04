package br.com.adbrascosmopolis.saac_secretaria.dto.situacao;

public class SituacaoComboBoxDTO {

    private Integer situacaoId;
    private String descricao;

    public SituacaoComboBoxDTO(){}

    public SituacaoComboBoxDTO(Integer situacaoId, String descricao){
        this.situacaoId = situacaoId;
        this.descricao = descricao;
    }

    public Integer getSituacaoId() {
        return situacaoId;
    }

    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
