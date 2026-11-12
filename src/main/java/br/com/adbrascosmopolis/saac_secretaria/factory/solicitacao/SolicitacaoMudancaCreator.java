package br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.*;
import br.com.adbrascosmopolis.saac_secretaria.repository.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SolicitacaoMudancaCreator {

    private final SolicitacaoRepository solicitacaoRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final PessoaRepository pessoaRepository;
    private final SituacaoRepository situacaoRepository;
    private final IgrejaOrigemRepository igrejaOrigemRepository;
    private final CargoMinisterialRepository cargoMinisterialRepository;

    public SolicitacaoMudancaCreator(
            SolicitacaoRepository solicitacaoRepository,
            CongregacaoRepository congregacaoRepository,
            PessoaRepository pessoaRepository,
            SituacaoRepository situacaoRepository,
            IgrejaOrigemRepository igrejaOrigemRepository,
            CargoMinisterialRepository cargoMinisterialRepository) {
        this.solicitacaoRepository = solicitacaoRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.pessoaRepository = pessoaRepository;
        this.situacaoRepository = situacaoRepository;
        this.igrejaOrigemRepository = igrejaOrigemRepository;
        this.cargoMinisterialRepository = cargoMinisterialRepository;
    }

    @Transactional
    public Solicitacao criar(CriarSolicitacaoCommand command) {
        if (!(command instanceof CriarSolicitacaoMudancaCommand dados)) {
            throw new IllegalArgumentException(
                    "Os dados informados não correspondem a uma solicitação de mudança.");
        }

        validarDadosComuns(command);

        if (dados.getIgrejaOrigemId() == null) {
            throw new IllegalArgumentException("O ID da igreja de origem é obrigatório.");
        }

        Congregacao congregacaoSolicitante = congregacaoRepository
                .findById(command.getCongregacaoSolicitanteId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Congregação solicitante não encontrada. ID: "
                                + command.getCongregacaoSolicitanteId()));

        Pessoa pessoa = pessoaRepository
                .findById(command.getPessoaId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Pessoa não encontrada. ID: " + command.getPessoaId()));

        Situacao situacao = situacaoRepository
                .findById(command.getSituacaoId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Situação não encontrada. ID: " + command.getSituacaoId()));

        IgrejaOrigem igrejaOrigem = igrejaOrigemRepository
                .findById(dados.getIgrejaOrigemId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Igreja de origem não encontrada. ID: " + dados.getIgrejaOrigemId()));

        CargoMinisterial cargoOrigem = null;
        if (dados.getCargoIgrejaOrigemId() != null) {
            cargoOrigem = cargoMinisterialRepository
                    .findById(dados.getCargoIgrejaOrigemId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Cargo de origem não encontrado. ID: "
                                    + dados.getCargoIgrejaOrigemId()));
        }

        CargoMinisterial cargoRecebido = null;
        if (dados.getCargoRecebidoId() != null) {
            cargoRecebido = cargoMinisterialRepository
                    .findById(dados.getCargoRecebidoId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Cargo recebido não encontrado. ID: "
                                    + dados.getCargoRecebidoId()));
        }

        SolicitacaoMudanca solicitacao = new SolicitacaoMudanca();
        solicitacao.setCongregacaoSolicitante(congregacaoSolicitante);
        solicitacao.setPessoa(pessoa);
        solicitacao.setSituacao(situacao);
        solicitacao.setTipoSolicitacao(TipoSolicitacao.MUDANCA);
        solicitacao.setHistorico(command.getHistorico());
        solicitacao.setIgrejaOrigem(igrejaOrigem);
        solicitacao.setCargoIgrejaOrigem(cargoOrigem);
        solicitacao.setCargoRecebido(cargoRecebido);

        return solicitacaoRepository.save(solicitacao);
    }

    private void validarDadosComuns(CriarSolicitacaoCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("Os dados da solicitação são obrigatórios.");
        }
        if (command.getCongregacaoSolicitanteId() == null) {
            throw new IllegalArgumentException(
                    "O ID da congregação solicitante é obrigatório.");
        }
        if (command.getPessoaId() == null) {
            throw new IllegalArgumentException("O ID da pessoa é obrigatório.");
        }
        if (command.getSituacaoId() == null) {
            throw new IllegalArgumentException("O ID da situação é obrigatório.");
        }
    }
}