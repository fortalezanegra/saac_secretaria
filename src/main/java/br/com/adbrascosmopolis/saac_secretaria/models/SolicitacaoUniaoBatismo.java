package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;
@Entity
@Table(name = "SolicitacaoUniaoBatismo")
@PrimaryKeyJoinColumn(name = "solicitacaoId", referencedColumnName = "solicitacaoId")
public class SolicitacaoUniaoBatismo extends Solicitacao {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "candidatoBatismoId", nullable = false)
    private CandidatoBatismo candidatoBatismo;

    public CandidatoBatismo getCandidatoBatismo() {
        return candidatoBatismo;
    }

    public void setCandidatoBatismo(CandidatoBatismo candidatoBatismo) {
        this.candidatoBatismo = candidatoBatismo;
    }
}


