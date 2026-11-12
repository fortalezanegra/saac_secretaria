package br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;

public abstract class CriarSolicitacaoTransferenciaCommand extends CriarSolicitacaoCommand {

    public abstract Integer getCongregacaoOrigemId();

    public abstract Integer getCongregacaoDestinoId();

    @Override
    public TipoSolicitacao getTipoSolicitacao() {
        return TipoSolicitacao.TRANSFERENCIA;
    }
}