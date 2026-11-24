package br.com.adbrascosmopolis.saac_secretaria.a_process_management.consolidar_reuniao_ministerial.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.adbrascosmopolis.saac_secretaria.models.Historico;
import br.com.adbrascosmopolis.saac_secretaria.models.ItemHistorico;
import br.com.adbrascosmopolis.saac_secretaria.models.CargoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoDesligamento;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoMudanca;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoTransferencia;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoPessoa;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoHistorico;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoVinculo;
import br.com.adbrascosmopolis.saac_secretaria.repository.CargoMinisterialRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.HistoricoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.ItemHistoricoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.PessoaRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.ReuniaoMinisterialRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SolicitacaoRepository;
import lombok.RequiredArgsConstructor;

import javax.management.RuntimeMBeanException;

@Service
@RequiredArgsConstructor
public class ConsolidacaoReuniaoMinisterialService {

    private static final ZoneId ZONA_SP = ZoneId.of("America/Sao_Paulo");

    /** Cargo MEMBRO (seção 4.5 e 4.6). */
    private static final Long CARGO_MEMBRO_ID = 2L;

    private final ReuniaoMinisterialRepository reuniaoMinisterialRepository;
    private final SolicitacaoRepository solicitacaoRepository;
    private final PessoaRepository pessoaRepository;
    private final HistoricoRepository historicoRepository;
    private final ItemHistoricoRepository itemHistoricoRepository;
    private final CargoMinisterialRepository cargoMinisterialRepository;

    public ConsolidacaoReuniaoMinisterialService(
            ReuniaoMinisterialRepository reuniaoMinisterialRepository,
            SolicitacaoRepository solicitacaoRepository,
            PessoaRepository pessoaRepository,
            HistoricoRepository historicoRepository,
            ItemHistoricoRepository itemHistoricoRepository,
            CargoMinisterialRepository cargoMinisterialRepository
    ){
        this.reuniaoMinisterialRepository = reuniaoMinisterialRepository;
        this.solicitacaoRepository = solicitacaoRepository;
        this.pessoaRepository = pessoaRepository;
        this.historicoRepository = historicoRepository;
        this.itemHistoricoRepository = itemHistoricoRepository;
        this.cargoMinisterialRepository = cargoMinisterialRepository;
    }

    /**
     * Consolida uma reunião. Tudo roda em uma única transação:
     * qualquer RuntimeException desfaz todas as alterações e a reunião
     * permanece CONCLUIDA.
     */
    @Transactional
    public void consolidar(Long reuniaoId) {
        ReuniaoMinisterial reuniao = reuniaoMinisterialRepository.findById(reuniaoId)
                .orElseThrow(() -> new RuntimeException("Reunião não encontrada."));

        if (reuniao.getSituacao() != SituacaoReuniaoMinisterial.CONCLUIDA) {
            throw new RuntimeException("Só é possível consolidar reunião CONCLUIDA.");
        }

        List<Solicitacao> solicitacoes = solicitacaoRepository.searchRequestsForReuniaoAndSituacao(reuniaoId, SituacaoSolicitacao.APROVADA);

        for (Solicitacao solicitacao : solicitacoes) {
            processarSolicitacao(solicitacao, reuniao);
        }

        reuniao.setSituacao(SituacaoReuniaoMinisterial.CONSOLIDADA);
    }

    private void processarSolicitacao(Solicitacao solicitacao, ReuniaoMinisterial reuniao) {
        Pessoa pessoa = pessoaRepository.findById(solicitacao.getPessoa().getPessoaId())
                .orElseThrow(() -> new RuntimeException(
                        "Pessoa da solicitação " + solicitacao.getSolicitacaoId() + " não encontrada."));

        String descricao = switch (solicitacao.getTipoSolicitacao()) {
            case DESLIGAMENTO -> procedimentoDesligamento(
                    (SolicitacaoDesligamento) solicitacao, pessoa, reuniao);
            case TRANSFERENCIA -> procedimentoTransferencia(
                    (SolicitacaoTransferencia) solicitacao, pessoa);
            case MUDANCA -> procedimentoMudanca(
                    (SolicitacaoMudanca) solicitacao, pessoa);
            case UNIAO -> procedimentoUniao(solicitacao, pessoa);
            case RECONCILIACAO -> procedimentoReconciliacao(solicitacao, pessoa);
        };

        registrarHistorico(solicitacao, pessoa, descricao);
    }

    /* ==================== Procedimentos por tipo ==================== */

    /** Seção 4.2. */
    private String procedimentoDesligamento(SolicitacaoDesligamento solicitacao,
                                            Pessoa pessoa,
                                            ReuniaoMinisterial reuniao) {
        pessoa.setSituacao(SituacaoPessoa.INATIVO);
        pessoa.setTipoVinculo(TipoVinculo.MEMBRO);

        String motivo = solicitacao.getMotivoDesligamento().getDescricao();

        return String.format("Desligamento aprovado por %s, na %s - %s",
                motivo,
                reuniao.getTipoReuniao(),
                reuniao.getDataReuniao());
    }

    /** Seção 4.3. */
    private String procedimentoTransferencia(SolicitacaoTransferencia solicitacao,
                                             Pessoa pessoa) {
        if (solicitacao.getCongregacaoOrigem().getCongregacaoId().equals(solicitacao.getCongregacaoDestino().getCongregacaoId())) {
            throw new RuntimeException(
                    "Transferência com congregação de origem igual à de destino.");
        }

        pessoa.setCongregacao(solicitacao.getCongregacaoDestino());
        pessoa.setTipoVinculo(TipoVinculo.MEMBRO);

        return descricaoPendente(TipoSolicitacao.TRANSFERENCIA);
    }

    /** Seção 4.4. */
    private String procedimentoMudanca(SolicitacaoMudanca solicitacao, Pessoa pessoa) {
        validarCargo(solicitacao.getCargoRecebido().getCargoMinisterialId());

        pessoa.setCargoMinisterial(solicitacao.getCargoRecebido());
        pessoa.setCongregacao(solicitacao.getCongregacaoSolicitante());
        pessoa.setTipoVinculo(TipoVinculo.MEMBRO);

        return descricaoPendente(TipoSolicitacao.MUDANCA);
    }

    /** Seção 4.5. */
    private String procedimentoUniao(Solicitacao solicitacao, Pessoa pessoa) {

        CargoMinisterial cargo = cargoMinisterialRepository.getReferenceById(pessoa.getCargoMinisterial().getCargoMinisterialId());

        validarCargo(cargo.getCargoMinisterialId());

        pessoa.setSituacao(SituacaoPessoa.ATIVO);
        pessoa.setTipoVinculo(TipoVinculo.MEMBRO);
        pessoa.setCargoMinisterial(cargo);

        return descricaoPendente(TipoSolicitacao.UNIAO);
    }

    /** Seção 4.6. */
    private String procedimentoReconciliacao(Solicitacao solicitacao, Pessoa pessoa) {

        CargoMinisterial cargo = cargoMinisterialRepository.getReferenceById(pessoa.getCargoMinisterial().getCargoMinisterialId());

        validarCargo(cargo.getCargoMinisterialId());

        pessoa.setSituacao(SituacaoPessoa.ATIVO);
        pessoa.setTipoVinculo(TipoVinculo.MEMBRO);
        pessoa.setCargoMinisterial(cargo);

        return descricaoPendente(TipoSolicitacao.RECONCILIACAO);
    }

    /* ==================== Histórico ==================== */

    /** Seção 5: um Historico por pessoa, criado se não existir. */
    private void registrarHistorico(Solicitacao solicitacao, Pessoa pessoa, String descricao) {
        if (itemHistoricoRepository.existsById(solicitacao.getSolicitacaoId())) {
            throw new RuntimeException(
                    "Solicitação " + solicitacao.getSolicitacaoId() + " já possui item de histórico.");
        }

        Historico historico = historicoRepository.findByPessoaPessoaId(pessoa.getPessoaId())
                .orElseGet(() -> {
                    Historico novo = new Historico();
                    novo.setPessoa(pessoa);
                    return historicoRepository.save(novo);
                });


        ItemHistorico item = new ItemHistorico();
        item.setSolicitacao(solicitacao);
        item.setHistorico(historico);
        item.setTipoHistorico(TipoHistorico.INFORMATIVO);
        item.setDescricao(descricao);
        item.setDataHistorico(LocalDate.now(ZONA_SP));

        itemHistoricoRepository.save(item);
    }

    /* ==================== Auxiliares ==================== */

    private void validarCargo(Integer cargoId) {
        if (cargoId == null || !cargoMinisterialRepository.existsById(cargoId)) {
            throw new RuntimeException("Cargo ministerial " + cargoId + " não existe.");
        }
    }

    /**
     * Texto de ItemHistorico.descricao ainda não definido (seção 9, item 1).
     * Bloqueia a consolidação até que o texto seja definido, para não gravar
     * histórico com conteúdo provisório.
     */
    private String descricaoPendente(TipoSolicitacao tipo) {
        throw new RuntimeException(
                "Texto de histórico para " + tipo + " ainda não foi definido.");
    }
}
