package br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem;

import br.com.adbrascosmopolis.saac_secretaria.models.IgrejaOrigem;

import java.time.LocalDateTime;

public class IgrejaOrigemEditDTO {

    private Integer igrejaOrigemId;
    private String descricao;
    private LocalDateTime deletedAt;

    public static IgrejaOrigemEditDTO fromIgrejaOrigem(IgrejaOrigem i){

        IgrejaOrigemEditDTO dto = new IgrejaOrigemEditDTO();

        dto.igrejaOrigemId = i.getIgrejaOrigemId();
        dto.descricao = i.getDescricao();
        dto.deletedAt = i.getDeletedAt();

        return dto;
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
