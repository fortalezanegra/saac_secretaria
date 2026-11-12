package br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.*;
import br.com.adbrascosmopolis.saac_secretaria.repository.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SolicitacaoTransferenciaCreator {

    private final SolicitacaoRepository solicitacaoRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final PessoaRepository pessoaRepository;
    private final SituacaoRepository situacaoRepository;

    public SolicitacaoTransferenciaCreator(
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
        if (!(command instanceof CriarSolicitacaoTransferenciaCommand dados)) {
            throw new IllegalArgumentException(
                    "Os dados informados não correspondem a uma solicitação de transferência.");
        }

        validarDadosComuns(command);

        Integer origemId = dados.getCongregacaoOrigemId();
        Integer destinoId = dados.getCongregacaoDestinoId();

        if (origemId == null || destinoId == null) {
            throw new IllegalArgumentException(
                    "Os IDs das congregações de origem e destino são obrigatórios.");
        }

        if (origemId.equals(destinoId)) {
            throw new IllegalArgumentException(
                    "A congregação de origem deve ser diferente da congregação de destino.");
        }

        Congregacao congregacaoSolicitante = congregacaoRepository
                .findById(command.getCongregacaoSolicitanteId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Congregação solicitante não encontrada. ID: "
                                + command.getCongregacaoSolicitanteId()));

        Congregacao congregacaoOrigem = congregacaoRepository
                .findById(origemId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Congregação de origem não encontrada. ID: " + origemId));

        Congregacao congregacaoDestino = congregacaoRepository
                .findById(destinoId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Congregação de destino não encontrada. ID: " + destinoId));

        Pessoa pessoa = pessoaRepository
                .findById(command.getPessoaId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Pessoa não encontrada. ID: " + command.getPessoaId()));

        Situacao situacao = situacaoRepository
                .findById(command.getSituacaoId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Situação não encontrada. ID: " + command.getSituacaoId()));

        SolicitacaoTransferencia solicitacao = new SolicitacaoTransferencia();
        solicitacao.setCongregacaoSolicitante(congregacaoSolicitante);
        solicitacao.setPessoa(pessoa);
        solicitacao.setSituacao(situacao);
        solicitacao.setTipoSolicitacao(TipoSolicitacao.TRANSFERENCIA);
        solicitacao.setHistorico(command.getHistorico());
        solicitacao.setCongregacaoOrigem(congregacaoOrigem);
        solicitacao.setCongregacaoDestino(congregacaoDestino);

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