package br.com.adbrascosmopolis.saac_secretaria.dto.situacao;

public class SituacaoDropdownDTO {

    private Integer situacaoId;
    private String descricao;
    private String contexto;

    public SituacaoDropdownDTO(){}

    public SituacaoDropdownDTO(Integer situacaoId, String descricao, String contexto){
        this.situacaoId = situacaoId;
        this.descricao = descricao;
        this.contexto = contexto;
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

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }
}
