package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo.CandidatoBatismoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo.CandidatoBatismoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo.CandidatoBatismoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo.CandidatoBatismoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.CandidatoBatismo;
import br.com.adbrascosmopolis.saac_secretaria.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoBatismoService {

    private final CandidatoBatismoRepository candidatoRepository;
    private final BatismoRepository batismoRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final PessoaRepository pessoaRepository;
    private final SituacaoRepository situacaoRepository;

    public CandidatoBatismoService(
            CandidatoBatismoRepository candidatoRepository,
            BatismoRepository batismoRepository,
            CongregacaoRepository congregacaoRepository,
            PessoaRepository pessoaRepository,
            SituacaoRepository situacaoRepository){
        this.candidatoRepository = candidatoRepository;
        this.batismoRepository = batismoRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.pessoaRepository = pessoaRepository;
        this.situacaoRepository = situacaoRepository;
    }

    // Dropdown/ComboBox Pendentes
    public List<CandidatoBatismoDropdownDTO> dropdown() {
        List<CandidatoBatismo> candidato =candidatoRepository.buscarCandidatosPendentes();

        return candidato.stream()
                .map(c -> new CandidatoBatismoDropdownDTO(
                        c.getCandidatoBatismoId(),
                        c.getPessoa() != null ? c.getPessoa().getNome() : null,
                        c.getSituacao() != null ? c.getSituacao().getDescricao() : null
                ))
                .collect(Collectors.toList());
    }

    // Busca todos os Candidatos "*"
    public List<CandidatoBatismoResponseDTO> listAllPendentes(){
        List<CandidatoBatismo> candidato = candidatoRepository.findAll();

        return candidato.stream()
                .map(c -> new CandidatoBatismoResponseDTO(
                        c.getCandidatoBatismoId(),
                        c.getBatismo() != null ? c.getBatismo().getDataBatismo() : null,
                        c.getCongregacao() != null ? c.getCongregacao().getNome() : null,
                        c.getPessoa() != null ? c.getPessoa().getNome() : null,
                        c.getSituacao() != null ? c.getSituacao().getDescricao() : null
                )).toList();
    }

    // Busca Candidatos por Id
    public CandidatoBatismo listById(Long id){
        CandidatoBatismo candidato = candidatoRepository.findByCandidatoBatismoId(id);
        return candidato;
    }

    // Busca candidatos pendentes por congregaçãoId
    public List<CandidatoBatismoResponseDTO> listPendentesPorCongregacaoId(Integer id){
        List<CandidatoBatismo> candidato = candidatoRepository.buscarCandidatosPendentesPorCongregacao(id);

        return candidato.stream()
                .map(c -> new CandidatoBatismoResponseDTO(
                        c.getCandidatoBatismoId(),
                        c.getBatismo() != null ? c.getBatismo().getDataBatismo() : null,
                        c.getCongregacao() != null ? c.getCongregacao().getNome() : null,
                        c.getPessoa() != null ? c.getPessoa().getNome() : null,
                        c.getSituacao() != null ? c.getSituacao().getDescricao() : null
                )).toList();
    }

    // Create
    @Transactional
    public CandidatoBatismoResponseDTO create(CandidatoBatismoRequestDTO dto){

        CandidatoBatismo candidato = new CandidatoBatismo();

        // Buscar entidades relacionadas pelo ID
        if(dto.getBatismoId() != null){
            candidato.setBatismo(
                    batismoRepository.findById(dto.getBatismoId())
                            .orElseThrow(() -> new RuntimeException("Batismo não encontrado"))
            );
        }

        if(dto.getCongregacaoId() != null){
            candidato.setCongregacao(
                    congregacaoRepository.findById(dto.getCongregacaoId())
                            .orElseThrow(() -> new RuntimeException("Congregação não encontrada"))
            );
        }

        if(dto.getPessoaId() != null){
            candidato.setPessoa(
                    pessoaRepository.findById(dto.getPessoaId())
                            .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"))
            );
        }

        if(dto.getSituacaoId() != null){
            candidato.setSituacao(
                    situacaoRepository.findById(dto.getSituacaoId())
                            .orElseThrow(() -> new RuntimeException("Situação não encontrada"))
            );
        }

        CandidatoBatismo salvo = candidatoRepository.save(candidato);
        CandidatoBatismo completo = candidatoRepository.findByIdFetchAll(salvo.getCandidatoBatismoId())
                .orElseThrow(()-> new RuntimeException("Candidato não encontrado"));

        return CandidatoBatismoResponseDTO.fromCandidatoBatismo(completo);
    }

    // Update
    @Transactional
    public CandidatoBatismo update(CandidatoBatismoEditDTO dto){
        CandidatoBatismo result = candidatoRepository.findById(dto.getCandidatoBatismoId())
                .orElseThrow(()-> new RuntimeException("Candidato não encontrado"));

        // Relacionamentos
        if(dto.getBatismoId() != null){
            result.setBatismo(
                    batismoRepository.getReferenceById(dto.getBatismoId())
            );
        }

        if(dto.getCongregacaoId() != null){
            result.setCongregacao(
                    congregacaoRepository.getReferenceById(dto.getCongregacaoId())
            );
        }

        if(dto.getPessoaId() != null){
            result.setPessoa(
                    pessoaRepository.getReferenceById(dto.getPessoaId())
            );
        }

        if(dto.getSituacaoId() != null){
            result.setSituacao(
                    situacaoRepository.getReferenceById(dto.getSituacaoId())
            );
        }

        return candidatoRepository.save(result);
    }

    // Delete
    public CandidatoBatismo delete(CandidatoBatismoEditDTO dto){
        CandidatoBatismo result = candidatoRepository.findById(dto.getCandidatoBatismoId())
                .orElseThrow(()-> new RuntimeException("Candidato não encontrado"));

        result.setDeletedAt(dto.getDeletedAt());

        return candidatoRepository.save(result);
    }
    
}
