package br.com.adbrascosmopolis.saac_secretaria.dto.motivo_desligamento;

public class MotivoDesligamentoDropdownDTO {

    private Integer motivoDesligamentoId;
    private String descricao;

    public MotivoDesligamentoDropdownDTO(
            Integer motivoDesligamentoId,
            String descricao
    ){
        this.motivoDesligamentoId = motivoDesligamentoId;
        this.descricao = descricao;
    }

    public Integer getMotivoDesligamentoId() {
        return motivoDesligamentoId;
    }

    public void setMotivoDesligamentoId(Integer motivoDesligamentoId) {
        this.motivoDesligamentoId = motivoDesligamentoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
