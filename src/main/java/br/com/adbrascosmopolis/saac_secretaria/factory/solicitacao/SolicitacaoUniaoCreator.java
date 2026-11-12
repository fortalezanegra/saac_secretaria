package br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.*;
import br.com.adbrascosmopolis.saac_secretaria.repository.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SolicitacaoUniaoCreator {

    private final SolicitacaoRepository solicitacaoRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final PessoaRepository pessoaRepository;
    private final SituacaoRepository situacaoRepository;

    public SolicitacaoUniaoCreator(
            SolicitacaoRepository solicitacaoRepository,
            CongregacaoRepository congregacaoRepository,
            PessoaRepository pessoaRepository,
            SituacaoRepository situacaoRepository) {
        this.solicitacaoRepository = solicitacaoRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.pessoaRepository = pessoaRepository;
        this.situacaoRepository = situacaoRepository;
    }

    @Transactional
    public Solicitacao criar(CriarSolicitacaoCommand command) {
        if (!(command instanceof CriarSolicitacaoUniaoCommand)) {
            throw new IllegalArgumentException(
                    "Os dados informados não correspondem a uma solicitação de união.");
        }

        validarDadosComuns(command);

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

        SolicitacaoUniao solicitacao = new SolicitacaoUniao();
        solicitacao.setCongregacaoSolicitante(congregacaoSolicitante);
        solicitacao.setPessoa(pessoa);
        solicitacao.setSituacao(situacao);
        solicitacao.setTipoSolicitacao(TipoSolicitacao.UNIAO);
        solicitacao.setHistorico(command.getHistorico());

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