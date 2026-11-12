package br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import org.springframework.stereotype.Service;

@Service
public class SolicitacaoManagerService {

    private final SolicitacaoUniaoCreator solicitacaoUniaoCreator;
    private final SolicitacaoMudancaCreator solicitacaoMudancaCreator;
    private final SolicitacaoReconciliacaoCreator solicitacaoReconciliacaoCreator;
    private final SolicitacaoTransferenciaCreator solicitacaoTransferenciaCreator;
    private final SolicitacaoDesligamentoCreator solicitacaoDesligamentoCreator;

    public SolicitacaoManagerService(
            SolicitacaoUniaoCreator solicitacaoUniaoCreator,
            SolicitacaoMudancaCreator solicitacaoMudancaCreator,
            SolicitacaoReconciliacaoCreator solicitacaoReconciliacaoCreator,
            SolicitacaoTransferenciaCreator solicitacaoTransferenciaCreator,
            SolicitacaoDesligamentoCreator solicitacaoDesligamentoCreator) {
        this.solicitacaoUniaoCreator = solicitacaoUniaoCreator;
        this.solicitacaoMudancaCreator = solicitacaoMudancaCreator;
        this.solicitacaoReconciliacaoCreator = solicitacaoReconciliacaoCreator;
        this.solicitacaoTransferenciaCreator = solicitacaoTransferenciaCreator;
        this.solicitacaoDesligamentoCreator = solicitacaoDesligamentoCreator;
    }

    public Solicitacao criar(CriarSolicitacaoCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("A solicitação é obrigatória.");
        }

        TipoSolicitacao tipo = command.getTipoSolicitacao();

        if (tipo == null) {
            throw new IllegalArgumentException(
                    "O tipo da solicitação é obrigatório.");
        }

        return switch (tipo) {
            case UNIAO -> solicitacaoUniaoCreator.criar(command);
            case MUDANCA -> solicitacaoMudancaCreator.criar(command);
            case RECONCILIACAO -> solicitacaoReconciliacaoCreator.criar(command);
            case TRANSFERENCIA -> solicitacaoTransferenciaCreator.criar(command);
            case DESLIGAMENTO -> solicitacaoDesligamentoCreator.criar(command);
        };
    }
}