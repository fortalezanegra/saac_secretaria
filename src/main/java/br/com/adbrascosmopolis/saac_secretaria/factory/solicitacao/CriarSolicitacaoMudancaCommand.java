package br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;

public abstract class CriarSolicitacaoMudancaCommand extends CriarSolicitacaoCommand {

    public abstract Integer getIgrejaOrigemId();

    public abstract Integer getCargoIgrejaOrigemId();

    public abstract Integer getCargoRecebidoId();

    @Override
    public TipoSolicitacao getTipoSolicitacao() {
        return TipoSolicitacao.MUDANCA;
    }
}