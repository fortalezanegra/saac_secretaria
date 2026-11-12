package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "SolicitacaoTransferencia")
@PrimaryKeyJoinColumn(name = "solicitacaoId", referencedColumnName = "solicitacaoId")
public class SolicitacaoTransferencia extends Solicitacao{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "congregacaoOrigemId", nullable = false, referencedColumnName = "congregacaoId")
    private Congregacao congregacaoOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "congregacaoDestinoId",nullable = false, referencedColumnName = "congregacaoId")
    private Congregacao congregacaoDestino;

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
}
