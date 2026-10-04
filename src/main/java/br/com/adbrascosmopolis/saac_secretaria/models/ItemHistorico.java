package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ItemHistorico")
public class ItemHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // importante: usa AUTO_INCREMENT do MySQL
    @Column(name = "itemHistoricoId")
    private Long itemHistoricoId;

    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER se quiser carregar junto
    @JoinColumn(name = "historicoId", referencedColumnName = "historicoId")
    private Historico historico;

    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER se quiser carregar junto
    @JoinColumn(name = "tipoHistoricoId", referencedColumnName = "tipoHistoricoId")
    private TipoHistorico tipoHistorico;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "dataHistorico")
    private LocalDate dataHistorico;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @Column(name = "deletedAt")
    private Date deletedAt;

    @Column(name = "modifiedBy")
    private Integer modifiedBy;

    public Long getItemHistoricoId() {
        return itemHistoricoId;
    }

    public void setItemHistoricoId(Long itemHistoricoId) {
        this.itemHistoricoId = itemHistoricoId;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    public TipoHistorico getTipoHistorico() {
        return tipoHistorico;
    }

    public void setTipoHistorico(TipoHistorico tipoHistorico) {
        this.tipoHistorico = tipoHistorico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataHistorico() {
        return dataHistorico;
    }

    public void setDataHistorico(LocalDate dataHistorico) {
        this.dataHistorico = dataHistorico;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
