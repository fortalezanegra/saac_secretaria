package br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.*;
import br.com.adbrascosmopolis.saac_secretaria.repository.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SolicitacaoDesligamentoCreator {

    private final SolicitacaoRepository solicitacaoRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final PessoaRepository pessoaRepository;
    private final SituacaoRepository situacaoRepository;
    private final MotivoDesligamentoRepository motivoDesligamentoRepository;

    public SolicitacaoDesligamentoCreator(
            SolicitacaoRepository solicitacaoRepository,
            CongregacaoRepository congregacaoRepository,
            PessoaRepository pessoaRepository,
            SituacaoRepository situacaoRepository,
            MotivoDesligamentoRepository motivoDesligamentoRepository) {
        this.solicitacaoRepository = solicitacaoRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.pessoaRepository = pessoaRepository;
        this.situacaoRepository = situacaoRepository;
        this.motivoDesligamentoRepository = motivoDesligamentoRepository;
    }

    @Transactional
    public Solicitacao criar(CriarSolicitacaoCommand command) {
        if (!(command instanceof CriarSolicitacaoDesligamentoCommand dados)) {
            throw new IllegalArgumentException(
                    "Os dados informados não correspondem a uma solicitação de desligamento.");
        }

        validarDadosComuns(command);

        if (dados.getMotivoDesligamentoId() == null) {
            throw new IllegalArgumentException(
                    "O ID do motivo do desligamento é obrigatório.");
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

        MotivoDesligamento motivo = motivoDesligamentoRepository
                .findById(dados.getMotivoDesligamentoId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Motivo de desligamento não encontrado. ID: "
                                + dados.getMotivoDesligamentoId()));

        SolicitacaoDesligamento solicitacao = new SolicitacaoDesligamento();
        solicitacao.setCongregacaoSolicitante(congregacaoSolicitante);
        solicitacao.setPessoa(pessoa);
        solicitacao.setSituacao(situacao);
        solicitacao.setTipoSolicitacao(TipoSolicitacao.DESLIGAMENTO);
        solicitacao.setHistorico(command.getHistorico());
        solicitacao.setMotivoDesligamento(motivo);

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