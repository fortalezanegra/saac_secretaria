package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Profissao")
public class Profissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // importante: usa AUTO_INCREMENT do MySQL
    @Column(name = "profissaoId")
    private Integer profissaoId;

    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @Column(name = "createdAt")
    private LocalDate createdAt;

    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    @Column(name = "deletedAt")
    private LocalDate deletedAt;

    @Column(name = "modifiedBy")
    private Integer modifiedBy;

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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDate deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
