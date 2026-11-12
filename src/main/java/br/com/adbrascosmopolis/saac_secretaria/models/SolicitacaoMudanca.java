package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "SolicitacaoMudanca")
@PrimaryKeyJoinColumn(name = "solicitacaoId", referencedColumnName = "solicitacaoId")
public class SolicitacaoMudanca extends Solicitacao{


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "igrejaOrigemId", nullable = false, referencedColumnName = "igrejaOrigemId")
    private IgrejaOrigem igrejaOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargoIgrejaOrigemId", nullable = true, referencedColumnName = "cargoMinisterialId")
    private CargoMinisterial cargoIgrejaOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargoRecebidoId", nullable = true, referencedColumnName = "cargoMinisterialId")
    private CargoMinisterial cargoRecebido;

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
}
