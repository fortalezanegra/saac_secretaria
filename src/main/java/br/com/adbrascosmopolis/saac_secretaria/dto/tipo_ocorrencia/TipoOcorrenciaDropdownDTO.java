package br.com.adbrascosmopolis.saac_secretaria.dto.tipo_ocorrencia;

public class TipoOcorrenciaDropdownDTO {

    private Integer tipoOcorrenciaId;
    private String descricao;

    public TipoOcorrenciaDropdownDTO(Integer tipoOcorrenciaId, String descricao){
        this. tipoOcorrenciaId = tipoOcorrenciaId;
        this.descricao = descricao;
    }

    public Integer getTipoOcorrenciaId() {
        return tipoOcorrenciaId;
    }

    public void setTipoOcorrenciaId(Integer tipoOcorrenciaId) {
        this.tipoOcorrenciaId = tipoOcorrenciaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
