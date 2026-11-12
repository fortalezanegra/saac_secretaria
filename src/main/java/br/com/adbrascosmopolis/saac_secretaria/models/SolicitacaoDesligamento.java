package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "SolicitacaoDesligamento")
@PrimaryKeyJoinColumn(name = "solicitacaoId", referencedColumnName = "solicitacaoId")
public class SolicitacaoDesligamento extends Solicitacao{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motivoDesligamentoId", nullable = false, referencedColumnName = "motivoDesligamentoId")
    private MotivoDesligamento motivoDesligamento;

    public MotivoDesligamento getMotivoDesligamento() {
        return motivoDesligamento;
    }

    public void setMotivoDesligamento(MotivoDesligamento motivoDesligamento) {
        this.motivoDesligamento = motivoDesligamento;
    }
}
