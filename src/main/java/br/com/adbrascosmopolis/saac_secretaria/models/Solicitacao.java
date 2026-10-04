package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Solicitacao")
public class Solicitacao{

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

    /* Solicitação de União por Batismo */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidatoBatismoId", referencedColumnName = "candidatoBatismoId")
    private CandidatoBatismo candidatoBatismo;

    /* Solicitação de Mudança/União */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "igrejaOrigemId", referencedColumnName = "igrejaOrigemId")
    private IgrejaOrigem igrejaOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargoIgrejaOrigemId", referencedColumnName = "cargoMinisterialId")
    private CargoMinisterial cargoIgrejaOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargoRecebidoId", referencedColumnName = "cargoMinisterialId")
    private CargoMinisterial cargoRecebido;

    /* Solicitação de Transferencia */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "congregacaoOrigemId", referencedColumnName = "congregacaoId")
    private Congregacao congregacaoOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "congregacaoDestinoId", referencedColumnName = "congregacaoId")
    private Congregacao congregacaoDestino;

    /* Solicitação de Desligamento/Reconciliacao */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motivoDesligamentoId", referencedColumnName = "motivoDesligamentoId")
    private MotivoDesligamento motivoDesligamento;

    /* Pessoa */
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
    private Integer modifiedBy;

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

    public CandidatoBatismo getCandidatoBatismo() {
        return candidatoBatismo;
    }

    public void setCandidatoBatismo(CandidatoBatismo candidatoBatismo) {
        this.candidatoBatismo = candidatoBatismo;
    }

    public IgrejaOrigem getIgrejaOrigem() {
        return igrejaOrigem;
    }

    public void setIgrejaOrigem(IgrejaOrigem igrejaOrigem) {
        this.igrejaOrigem = igrejaOrigem;
    }

    public CargoMinisterial getCargoIgrejaOrigem() {
        return cargoIgrejaOrigem;
    }

    public void setCargoIgrejaOrigem(CargoMinisterial cargoIgrejaOrigem) {
        this.cargoIgrejaOrigem = cargoIgrejaOrigem;
    }

    public CargoMinisterial getCargoRecebido() {
        return cargoRecebido;
    }

    public void setCargoRecebido(CargoMinisterial cargoRecebido) {
        this.cargoRecebido = cargoRecebido;
    }

    public Congregacao getCongregacaoOrigem() {
        return congregacaoOrigem;
    }

    public void setCongregacaoOrigem(Congregacao congregacaoOrigem) {
        this.congregacaoOrigem = congregacaoOrigem;
    }

    public Congregacao getCongregacaoDestino() {
        return congregacaoDestino;
    }

    public void setCongregacaoDestino(Congregacao congregacaoDestino) {
        this.congregacaoDestino = congregacaoDestino;
    }

    public MotivoDesligamento getMotivoDesligamento() {
        return motivoDesligamento;
    }

    public void setMotivoDesligamento(MotivoDesligamento motivoDesligamento) {
        this.motivoDesligamento = motivoDesligamento;
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

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
