package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Entity
@Table(name = "Solicitacao")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Solicitacao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solicitacaoId")
    private Long solicitacaoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reuniaoMinisterialId", referencedColumnName = "reuniaoMinisterialId")
    private ReuniaoMinisterial reuniaoMinisterial;

    /* Identificacao */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "congregacaoSolicitanteId", referencedColumnName = "congregacaoId")
    private Congregacao congregacaoSolicitante;

    //Observação Crítica: Esta coluna gera varias queries de filtro de pessoa/situacao em função do tipo de solicitação
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoSolicitacaoId", referencedColumnName = "tipoSolicitacaoId")
    private TipoSolicitacao tipoSolicitacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoaId", referencedColumnName = "pessoaId")
    private Pessoa pessoa;

    @Column(name = "historico")
    private String historico;

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
    private Long modifiedBy;

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public ReuniaoMinisterial getReuniaoMinisterial() {
        return reuniaoMinisterial;
    }

    public void setReuniaoMinisterial(ReuniaoMinisterial reuniaoMinisterial) {
        this.reuniaoMinisterial = reuniaoMinisterial;
    }

    public Congregacao getCongregacaoSolicitante() {
        return congregacaoSolicitante;
    }

    public void setCongregacaoSolicitante(Congregacao congregacaoSolicitante) {
        this.congregacaoSolicitante = congregacaoSolicitante;
    }

    public TipoSolicitacao getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
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

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
