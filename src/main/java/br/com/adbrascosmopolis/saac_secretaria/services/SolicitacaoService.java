package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.SolicitacaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.SolicitacaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.SolicitacaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_batismo.SolicitacaoUniaoBatismoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_batismo.SolicitacaoUniaoBatismoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_batismo.SolicitacaoUniaoBatismoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_mudanca.SolicitacaoUniaoMudancaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_mudanca.SolicitacaoUniaoMudancaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_mudanca.SolicitacaoUniaoMudancaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitacaoService {

    private final SolicitacaoRepository solicitacaoRepository;
    private final ReuniaoMinisterialRepository reuniaoMinisterialRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final TipoSolicitacaoRepository tipoSolicitacaoRepository;
    private final PessoaRepository pessoaRepository;
    private final CandidatoBatismoRepository candidatoBatismoRepository;
    private final IgrejaOrigemRepository igrejaOrigemRepository;
    private final CargoMinisterialRepository cargoMinisterialRepository;
    private final MotivoDesligamentoRepository motivoDesligamentoRepository;
    private final SituacaoRepository situacaoRepository;

    public SolicitacaoService(
            SolicitacaoRepository solicitacaoRepository,
            ReuniaoMinisterialRepository reuniaoMinisterialRepository,
            CongregacaoRepository congregacaoRepository,
            TipoSolicitacaoRepository tipoSolicitacaoRepository,
            PessoaRepository pessoaRepository,
            CandidatoBatismoRepository candidatoBatismoRepository,
            IgrejaOrigemRepository igrejaOrigemRepository,
            CargoMinisterialRepository cargoMinisterialRepository,
            MotivoDesligamentoRepository motivoDesligamentoRepository,
            SituacaoRepository situacaoRepository
    ){
        this.solicitacaoRepository = solicitacaoRepository;
        this.reuniaoMinisterialRepository = reuniaoMinisterialRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.tipoSolicitacaoRepository = tipoSolicitacaoRepository;
        this.pessoaRepository = pessoaRepository;
        this.candidatoBatismoRepository = candidatoBatismoRepository;
        this.igrejaOrigemRepository = igrejaOrigemRepository;
        this.cargoMinisterialRepository = cargoMinisterialRepository;
        this.motivoDesligamentoRepository = motivoDesligamentoRepository;
        this.situacaoRepository = situacaoRepository;
    }

    /* ************************************************
    ******** SOLICITAÇÃO DE UNIÃO POR BATISMO *********
    ************************************************* */

    // Buscar todas as Solicitações de União por Batismo
    public List<SolicitacaoUniaoBatismoResponseDTO> listarTodasSolicitacoesUniaoBatismo(){
        List<Solicitacao> solicitacoes = solicitacaoRepository.buscarTodasSolicitacoesUniaoBatismo();
        return solicitacoes.stream()
                .map(s -> new SolicitacaoUniaoBatismoResponseDTO(
                        s.getSolicitacaoId(),
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getTipoReuniao().getDescricao() : null,
                        s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                        s.getCongregacaoSolicitante().getNome(),
                        s.getTipoSolicitacao() != null ? s.getTipoSolicitacao().getTipoSolicitacaoId() : null,
                        s.getTipoSolicitacao().getDescricao(),
                        s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                        s.getPessoa() != null ? s.getPessoa().getNome() : null,
                        s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getCandidatoBatismoId() : null,
                        s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getPessoa().getNome() : null,
                        s.getHistorico(),
                        s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null,
                        s.getSituacao() != null ? s.getSituacao().getDescricao() : null
                )).toList();
    }

    // Buscar Todas as Solicitações União Batismo por Congregação
    public List<SolicitacaoUniaoBatismoResponseDTO>  listarSolicitacoesUniaoBatismoPorCongregacao(Integer congregacaoSolicitante){
        List<Solicitacao> solicitacoes = solicitacaoRepository.buscarSolicitacoesUniaoBatismoPorCongregacao(congregacaoSolicitante);
        return solicitacoes.stream()
                .map(s -> new SolicitacaoUniaoBatismoResponseDTO(
                        s.getSolicitacaoId(),
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getTipoReuniao().getDescricao() : null,
                        s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                        s.getCongregacaoSolicitante().getNome(),
                        s.getTipoSolicitacao() != null ? s.getTipoSolicitacao().getTipoSolicitacaoId() : null,
                        s.getTipoSolicitacao().getDescricao(),
                        s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                        s.getPessoa() != null ? s.getPessoa().getNome() : null,
                        s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getCandidatoBatismoId() : null,
                        s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getPessoa().getNome() : null,
                        s.getHistorico(),
                        s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null,
                        s.getSituacao() != null ? s.getSituacao().getDescricao() : null
                )).toList();
    }

    // Buscar Todas as Solicitações Uniao Batismo por Situação
    public List<SolicitacaoUniaoBatismoResponseDTO>  listarSolicitacoesUniaoBatismoPorSituacao(String descricaoSituacao){
        List<Solicitacao> solicitacoes = solicitacaoRepository.buscarTodasSolicitacoesUniaoBatismoPorSituacao(descricaoSituacao);
        return solicitacoes.stream()
                .map(s -> new SolicitacaoUniaoBatismoResponseDTO(
                        s.getSolicitacaoId(),
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getTipoReuniao().getDescricao() : null,
                        s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                        s.getCongregacaoSolicitante().getNome(),
                        s.getTipoSolicitacao() != null ? s.getTipoSolicitacao().getTipoSolicitacaoId() : null,
                        s.getTipoSolicitacao().getDescricao(),
                        s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                        s.getPessoa() != null ? s.getPessoa().getNome() : null,
                        s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getCandidatoBatismoId() : null,
                        s.getCandidatoBatismo() != null ? s.getCandidatoBatismo().getPessoa().getNome() : null,
                        s.getHistorico(),
                        s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null,
                        s.getSituacao() != null ? s.getSituacao().getDescricao() : null
                )).toList();
    }

    /* Buscar Solicitação Uniao Batismo por ID */
    public SolicitacaoUniaoBatismoResponseDTO listarSolicitacaoUniaoBatismoPorId(Long id){
        Solicitacao solicitacao = solicitacaoRepository.BuscarSolicitacaoUniaoBatismoPorId(id);
        return SolicitacaoUniaoBatismoResponseDTO.fromSolicitacao(solicitacao);
    }

    /* Create União Batismo */
    @Transactional
    public SolicitacaoUniaoBatismoResponseDTO createUniaoBatismo(SolicitacaoUniaoBatismoRequestDTO dto) {
        Solicitacao solicitacao = new Solicitacao();

        solicitacao.setHistorico(dto.getHistorico());

        // Buscar entidades relacionadas pelo ID
        if (dto.getReuniaoMinisterialId() != null) {
            solicitacao.setReuniaoMinisterial(
                    reuniaoMinisterialRepository.findById(dto.getReuniaoMinisterialId())
                            .orElseThrow(() -> new RuntimeException("Reunião Ministerial não encontrada"))
            );
        }

        if (dto.getCongregacaoSolicitanteId() != null) {
            solicitacao.setCongregacaoSolicitante(
                    congregacaoRepository.findById(dto.getCongregacaoSolicitanteId())
                            .orElseThrow(() -> new RuntimeException("Congregacao Solicitante não encontrada"))
            );
        }

        if (dto.getTipoSolicitacaoId() != null) {
            solicitacao.setTipoSolicitacao(
                    tipoSolicitacaoRepository.findById(dto.getTipoSolicitacaoId())
                            .orElseThrow(() -> new RuntimeException("Tipo Solicitação não encontrada"))
            );
        }

        if (dto.getPessoaId() != null) {
            solicitacao.setPessoa(
                    pessoaRepository.findById(dto.getPessoaId())
                            .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"))
            );
        }

        if (dto.getCandidatoBatismoId() != null) {
            solicitacao.setCandidatoBatismo(
                    candidatoBatismoRepository.findById(dto.getCandidatoBatismoId())
                            .orElseThrow(() -> new RuntimeException("Candidato(a) Batismo não encontrado(a)"))
            );
        }

        if (dto.getSituacaoId() != null) {
            solicitacao.setSituacao(
                    situacaoRepository.findById(dto.getSituacaoId())
                            .orElseThrow(() -> new RuntimeException("Igreja de Origem não encontrada"))
            );
        }

        Solicitacao salvo = solicitacaoRepository.save(solicitacao);

        Solicitacao completo = solicitacaoRepository.findByIdFetchAll(salvo.getSolicitacaoId())
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        return SolicitacaoUniaoBatismoResponseDTO.fromSolicitacao(completo);
    }

    /* Update União Batismo */
    @Transactional
    public SolicitacaoUniaoBatismoResponseDTO updateUniaoBatismo(SolicitacaoUniaoBatismoEditDTO dto) {

        if (dto.getSolicitacaoId() == null) {
            throw new RuntimeException("SolicitacaoId não pode ser null");
        }

        Solicitacao result = solicitacaoRepository.findById(dto.getSolicitacaoId())
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        // Campos simples
        result.setHistorico(dto.getHistorico());

        // Relacionamentos (
        if (dto.getReuniaoMinisterialId() != null)
            result.setReuniaoMinisterial(
                    reuniaoMinisterialRepository.getReferenceById(dto.getReuniaoMinisterialId())
            );

        if (dto.getCongregacaoSolicitanteId() != null)
            result.setCongregacaoSolicitante(
                    congregacaoRepository.getReferenceById(dto.getCongregacaoSolicitanteId())
            );

        if (dto.getTipoSolicitacaoId() != null)
            result.setTipoSolicitacao(
                    tipoSolicitacaoRepository.getReferenceById(dto.getTipoSolicitacaoId())
            );

        if (dto.getPessoaId() != null)
            result.setPessoa(
                    pessoaRepository.getReferenceById(dto.getPessoaId())
            );

        if (dto.getCandidatoBatismoId() != null)
            result.setCandidatoBatismo(
                    candidatoBatismoRepository.getReferenceById(dto.getCandidatoBatismoId())
            );

        if (dto.getSituacaoId() != null)
            result.setSituacao(
                    situacaoRepository.getReferenceById(dto.getSituacaoId())
            );

        var solicitacaoAtualizada = solicitacaoRepository.save(result);

        return SolicitacaoUniaoBatismoResponseDTO.fromSolicitacao(solicitacaoAtualizada);
    }

    /* Delete União Batismo */
    @Transactional
    public SolicitacaoUniaoBatismoResponseDTO deleteUniaoBatismo(SolicitacaoUniaoBatismoEditDTO dto){

        if (dto.getSolicitacaoId() == null) {
            throw new RuntimeException("SolicitacaoId não pode ser null");
        }

        Solicitacao result = solicitacaoRepository.findById(dto.getSolicitacaoId())
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        // Campos simples
        result.setDeletedAt(LocalDateTime.now());

        var solicitacaoAtualizada =  solicitacaoRepository.save(result);

        return SolicitacaoUniaoBatismoResponseDTO.fromSolicitacao(solicitacaoAtualizada);
    }

    /* ******* FIM SOLICITAÇÃO DE UNIÃO POR BATISMO ******** */


    /* ************************************************
    ******** SOLICITAÇÃO DE UNIÃO POR MUDANÇA *********
    ************************************************* */

    // Buscar todas as Solicitações de Mudança por Batismo
    public List<SolicitacaoUniaoMudancaResponseDTO> listarTodasSolicitacoesUniaoMudanca(){
        List<Solicitacao> solicitacoes = solicitacaoRepository.buscarTodasSolicitacoesUniaoMudanca();
        return solicitacoes.stream()
                .map(s -> new SolicitacaoUniaoMudancaResponseDTO(
                        s.getSolicitacaoId(),
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getTipoReuniao().getDescricao() : null,
                        s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                        s.getCongregacaoSolicitante().getNome(),
                        s.getTipoSolicitacao() != null ? s.getTipoSolicitacao().getTipoSolicitacaoId() : null,
                        s.getTipoSolicitacao().getDescricao(),
                        s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                        s.getPessoa() != null ? s.getPessoa().getNome() : null,
                        s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getIgrejaOrigemId() : null,
                        s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getDescricao() : null,
                        s.getCargoIgrejaOrigem() != null ? s.getCargoIgrejaOrigem().getCargoMinisterialId() : null,
                        s.getCargoIgrejaOrigem() != null ? s.getCargoIgrejaOrigem().getDescricao() : null,
                        s.getCargoRecebido() != null ? s.getCargoRecebido().getCargoMinisterialId() : null,
                        s.getCargoRecebido() != null ? s.getCargoRecebido().getDescricao() : null,
                        s.getHistorico(),
                        s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null,
                        s.getSituacao() != null ? s.getSituacao().getDescricao() : null
                )).toList();
    }

    // Buscar Todas as Solicitações União Mudança por Congregação
    public List<SolicitacaoUniaoMudancaResponseDTO>  listarSolicitacoesUniaoMudancaPorCongregacao(Integer congregacaoSolicitante){
        List<Solicitacao> solicitacoes = solicitacaoRepository.buscarSolicitacoesUniaoMudancaPorCongregacao(congregacaoSolicitante);
        return solicitacoes.stream()
                .map(s -> new SolicitacaoUniaoMudancaResponseDTO(
                        s.getSolicitacaoId(),
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getTipoReuniao().getDescricao() : null,
                        s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                        s.getCongregacaoSolicitante().getNome(),
                        s.getTipoSolicitacao() != null ? s.getTipoSolicitacao().getTipoSolicitacaoId() : null,
                        s.getTipoSolicitacao().getDescricao(),
                        s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                        s.getPessoa() != null ? s.getPessoa().getNome() : null,
                        s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getIgrejaOrigemId() : null,
                        s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getDescricao() : null,
                        s.getCargoIgrejaOrigem() != null ? s.getCargoIgrejaOrigem().getCargoMinisterialId() : null,
                        s.getCargoIgrejaOrigem() != null ? s.getCargoIgrejaOrigem().getDescricao() : null,
                        s.getCargoRecebido() != null ? s.getCargoRecebido().getCargoMinisterialId() : null,
                        s.getCargoRecebido() != null ? s.getCargoRecebido().getDescricao() : null,
                        s.getHistorico(),
                        s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null,
                        s.getSituacao() != null ? s.getSituacao().getDescricao() : null
                )).toList();
    }

    // Buscar Todas as Solicitações Uniao Mudança por Situação
    public List<SolicitacaoUniaoMudancaResponseDTO>  listarSolicitacoesUniaoMudancaPorSituacao(String descricaoSituacao){
        List<Solicitacao> solicitacoes = solicitacaoRepository.buscarTodasSolicitacoesUniaoMudancaPorSituacao(descricaoSituacao);
        return solicitacoes.stream()
                .map(s -> new SolicitacaoUniaoMudancaResponseDTO(
                        s.getSolicitacaoId(),
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                        s.getReuniaoMinisterial() != null ? s.getReuniaoMinisterial().getTipoReuniao().getDescricao() : null,
                        s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getCongregacaoId() : null,
                        s.getCongregacaoSolicitante().getNome(),
                        s.getTipoSolicitacao() != null ? s.getTipoSolicitacao().getTipoSolicitacaoId() : null,
                        s.getTipoSolicitacao().getDescricao(),
                        s.getPessoa() != null ? s.getPessoa().getPessoaId() : null,
                        s.getPessoa() != null ? s.getPessoa().getNome() : null,
                        s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getIgrejaOrigemId() : null,
                        s.getIgrejaOrigem() != null ? s.getIgrejaOrigem().getDescricao() : null,
                        s.getCargoIgrejaOrigem() != null ? s.getCargoIgrejaOrigem().getCargoMinisterialId() : null,
                        s.getCargoIgrejaOrigem() != null ? s.getCargoIgrejaOrigem().getDescricao() : null,
                        s.getCargoRecebido() != null ? s.getCargoRecebido().getCargoMinisterialId() : null,
                        s.getCargoRecebido() != null ? s.getCargoRecebido().getDescricao() : null,
                        s.getHistorico(),
                        s.getSituacao() != null ? s.getSituacao().getSituacaoId() : null,
                        s.getSituacao() != null ? s.getSituacao().getDescricao() : null
                )).toList();
    }

    /* Buscar Solicitação Uniao Mudança por ID */
    public SolicitacaoUniaoMudancaResponseDTO listarSolicitacaoUniaoMudancaPorId(Long id){
        Solicitacao solicitacao = solicitacaoRepository.BuscarSolicitacaoUniaoMudancaPorId(id);
        return SolicitacaoUniaoMudancaResponseDTO.fromSolicitacao(solicitacao);
    }

    /* Create União Mudança */
    @Transactional
    public SolicitacaoUniaoMudancaResponseDTO createUniaoMudanca(SolicitacaoUniaoMudancaRequestDTO dto) {
        Solicitacao solicitacao = new Solicitacao();

        solicitacao.setHistorico(dto.getHistorico());

        // Buscar entidades relacionadas pelo ID
        if (dto.getReuniaoMinisterialId() != null) {
            solicitacao.setReuniaoMinisterial(
                    reuniaoMinisterialRepository.findById(dto.getReuniaoMinisterialId())
                            .orElseThrow(() -> new RuntimeException("Reunião Ministerial não encontrada"))
            );
        }

        if (dto.getCongregacaoSolicitanteId() != null) {
            solicitacao.setCongregacaoSolicitante(
                    congregacaoRepository.findById(dto.getCongregacaoSolicitanteId())
                            .orElseThrow(() -> new RuntimeException("Congregacao Solicitante não encontrada"))
            );
        }

        if (dto.getTipoSolicitacaoId() != null) {
            solicitacao.setTipoSolicitacao(
                    tipoSolicitacaoRepository.findById(dto.getTipoSolicitacaoId())
                            .orElseThrow(() -> new RuntimeException("Tipo Solicitação não encontrada"))
            );
        }

        if (dto.getPessoaId() != null) {
            solicitacao.setPessoa(
                    pessoaRepository.findById(dto.getPessoaId())
                            .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"))
            );
        }

        if (dto.getIgrejaOrigemId() != null) {
            solicitacao.setIgrejaOrigem(
                    igrejaOrigemRepository.findById(dto.getIgrejaOrigemId())
                            .orElseThrow(() -> new RuntimeException("Igreja Origem não encontrada"))
            );
        }

        if (dto.getCargoIgrejaOrigemId() != null) {
            solicitacao.setCargoIgrejaOrigem(
                    cargoMinisterialRepository.findById(dto.getCargoIgrejaOrigemId())
                            .orElseThrow(() -> new RuntimeException("Cargo Ministerial não encontrado"))
            );
        }

        if (dto.getCargoRecebidoId() != null) {
            solicitacao.setCargoRecebido(
                    cargoMinisterialRepository.findById(dto.getCargoRecebidoId())
                            .orElseThrow(() -> new RuntimeException("Cargo Ministerial não encontrado"))
            );
        }

        if (dto.getSituacaoId() != null) {
            solicitacao.setSituacao(
                    situacaoRepository.findById(dto.getSituacaoId())
                            .orElseThrow(() -> new RuntimeException("Igreja de Origem não encontrada"))
            );
        }

        Solicitacao salvo = solicitacaoRepository.save(solicitacao);

        Solicitacao completo = solicitacaoRepository.findByIdFetchAll(salvo.getSolicitacaoId())
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        return SolicitacaoUniaoMudancaResponseDTO.fromSolicitacao(completo);
    }

    /* Update União Mudança */
    @Transactional
    public SolicitacaoUniaoMudancaResponseDTO updateUniaoMudanca(SolicitacaoUniaoMudancaEditDTO dto) {

        if (dto.getSolicitacaoId() == null) {
            throw new RuntimeException("SolicitacaoId não pode ser null");
        }

        Solicitacao solicitacao = solicitacaoRepository.findById(dto.getSolicitacaoId())
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        // Campos simples
        solicitacao.setHistorico(dto.getHistorico());

        // Relacionamentos (
        if (dto.getReuniaoMinisterialId() != null)
            solicitacao.setReuniaoMinisterial(
                    reuniaoMinisterialRepository.getReferenceById(dto.getReuniaoMinisterialId())
            );

        if (dto.getCongregacaoSolicitanteId() != null)
            solicitacao.setCongregacaoSolicitante(
                    congregacaoRepository.getReferenceById(dto.getCongregacaoSolicitanteId())
            );

        if (dto.getTipoSolicitacaoId() != null)
            solicitacao.setTipoSolicitacao(
                    tipoSolicitacaoRepository.getReferenceById(dto.getTipoSolicitacaoId())
            );

        if (dto.getPessoaId() != null)
            solicitacao.setPessoa(
                    pessoaRepository.getReferenceById(dto.getPessoaId())
            );

        if (dto.getIgrejaOrigemId() != null) {
            solicitacao.setIgrejaOrigem(
                    igrejaOrigemRepository.findById(dto.getIgrejaOrigemId())
                            .orElseThrow(() -> new RuntimeException("Igreja Origem não encontrada"))
            );
        }

        if (dto.getCargoIgrejaOrigemId() != null) {
            solicitacao.setCargoIgrejaOrigem(
                    cargoMinisterialRepository.findById(dto.getCargoIgrejaOrigemId())
                            .orElseThrow(() -> new RuntimeException("Cargo Ministerial não encontrado"))
            );
        }

        if (dto.getCargoRecebidoId() != null) {
            solicitacao.setCargoRecebido(
                    cargoMinisterialRepository.findById(dto.getCargoRecebidoId())
                            .orElseThrow(() -> new RuntimeException("Cargo Ministerial não encontrado"))
            );
        };

        if (dto.getSituacaoId() != null)
            solicitacao.setSituacao(
                    situacaoRepository.getReferenceById(dto.getSituacaoId())
            );

        var solicitacaoAtualizada = solicitacaoRepository.save(solicitacao);

        return SolicitacaoUniaoMudancaResponseDTO.fromSolicitacao(solicitacaoAtualizada);
    }

    /* Delete União Mudança */
    @Transactional
    public SolicitacaoUniaoMudancaResponseDTO deleteUniaoMudanca(SolicitacaoUniaoMudancaEditDTO dto){

        if (dto.getSolicitacaoId() == null) {
            throw new RuntimeException("SolicitacaoId não pode ser null");
        }

        Solicitacao result = solicitacaoRepository.findById(dto.getSolicitacaoId())
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        // Campos simples
        result.setDeletedAt(LocalDateTime.now());

        var solicitacaoAtualizada =  solicitacaoRepository.save(result);

        return SolicitacaoUniaoMudancaResponseDTO.fromSolicitacao(solicitacaoAtualizada);
    }


    /* ******* FIM SOLICITAÇÃO DE UNIÃO POR MUDANÇA ******** */

}
