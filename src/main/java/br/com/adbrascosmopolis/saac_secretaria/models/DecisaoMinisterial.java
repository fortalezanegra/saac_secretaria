package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "DecisaoMinisterial")
public class DecisaoMinisterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "decisaoMinisterialId")
    private Long decisaoMinisterialId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reuniaoMinisterialId", referencedColumnName = "reuniaoMinisterialId")
    private ReuniaoMinisterial reuniaoMinisterial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitacaoId", referencedColumnName = "solicitacaoId")
    private Solicitacao solicitacao;

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

    public Long getDecisaoMinisterialId() {
        return decisaoMinisterialId;
    }

    public void setDecisaoMinisterialId(Long decisaoMinisterialId) {
        this.decisaoMinisterialId = decisaoMinisterialId;
    }

    public ReuniaoMinisterial getReuniaoMinisterial() {
        return reuniaoMinisterial;
    }

    public void setReuniaoMinisterial(ReuniaoMinisterial reuniaoMinisterial) {
        this.reuniaoMinisterial = reuniaoMinisterial;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
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

