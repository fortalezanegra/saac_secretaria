package br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;

public abstract class CriarSolicitacaoDesligamentoCommand extends CriarSolicitacaoCommand {

    public abstract Integer getMotivoDesligamentoId();

    @Override
    public TipoSolicitacao getTipoSolicitacao() {
        return TipoSolicitacao.DESLIGAMENTO;
    }
}