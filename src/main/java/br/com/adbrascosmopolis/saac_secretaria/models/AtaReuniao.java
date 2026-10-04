package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "AtaReuniao")
public class AtaReuniao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ataReuniaoId")
    private Long ataReuniaoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reuniaoMinisterialId", referencedColumnName = "reuniaoMinisterialId")
    private ReuniaoMinisterial reuniaoMinisterial;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "dataAta")
    private LocalDate dataAta;

    @Column(name = "urlAta")
    private String urlAta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "situacaoId", referencedColumnName = "situacaoId")
    private Situacao situacao;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;

    @Column(name = "modifiedBy")
    private Integer modifiedBy;

    public Long getAtaReuniaoId() {
        return ataReuniaoId;
    }

    public void setAtaReuniaoId(Long ataReuniaoId) {
        this.ataReuniaoId = ataReuniaoId;
    }

    public ReuniaoMinisterial getReuniaoMinisterial() {
        return reuniaoMinisterial;
    }

    public void setReuniaoMinisterial(ReuniaoMinisterial reuniaoMinisterial) {
        this.reuniaoMinisterial = reuniaoMinisterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAta() {
        return dataAta;
    }

    public void setDataAta(LocalDate dataAta) {
        this.dataAta = dataAta;
    }

    public String getUrlAta() {
        return urlAta;
    }

    public void setUrlAta(String urlAta) {
        this.urlAta = urlAta;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
