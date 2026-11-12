package br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;

public abstract class CriarSolicitacaoReconciliacaoCommand extends CriarSolicitacaoCommand {

    @Override
    public TipoSolicitacao getTipoSolicitacao() {
        return TipoSolicitacao.RECONCILIACAO;
    }
}