package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.CongregacaoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SetorRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CongregacaoService {

    private final CongregacaoRepository congregacaoRepository;
    private final SetorRepository setorRepository;

    public CongregacaoService(
            CongregacaoRepository congregacaoRepository,
            SetorRepository setorRepository
    ){
        this.congregacaoRepository = congregacaoRepository;
        this.setorRepository = setorRepository;
    }

    // Dropdown/ComboBox
    public List<CongregacaoDropdownDTO> dropdown() {
        List<Congregacao> congregacoes = congregacaoRepository.findAll();

        return congregacoes.stream()
                .map(c -> new CongregacaoDropdownDTO(
                        c.getCongregacaoId(),
                        c.getNome()
                ))
                .collect(Collectors.toList());
    }

    // Busca todas as congregações
    public List<CongregacaoResponseDTO> listAll(){
        List<Congregacao> congregacao = congregacaoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));

        return congregacao.stream()
                .map(c -> new CongregacaoResponseDTO(
                        c.getCongregacaoId(),
                        c.getSetor() != null ? c.getSetor().getDescricao() : null,
                        c.getNome(),
                        c.getSigla(),
                        c.getEndereco()
                )).toList();
    }

    // Busca congregação por Id
    public Congregacao listById(Integer id){
        Congregacao congregacao = congregacaoRepository.findByCongregacaoId(id);
        return congregacao;
    }

    // Busca congregação por setorId
    public List<CongregacaoResponseDTO> listBySetor(Integer setorId){
        List<Congregacao> congregacao = congregacaoRepository.findBySetorSetorId(setorId);

        return congregacao.stream()
                .map(c -> new CongregacaoResponseDTO(
                        c.getCongregacaoId(),
                        c.getSetor() != null ? c.getSetor().getDescricao() : null,
                        c.getNome(),
                        c.getSigla(),
                        c.getEndereco()
                )).toList();
    }

    // Search By Nome - Pesquisa avançada
    public List<Congregacao> searchByExample(String nome){

        var congregacao = new Congregacao();
        congregacao.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("congregacaoId",
                        "setorId",
                        //"nome",
                        "sigla",
                        "endereco")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Congregacao> congregacaoExample = Example.of(congregacao, matcher);
        return congregacaoRepository.findAll(congregacaoExample);
    }

    // Create
    @Transactional
    public CongregacaoResponseDTO create(CongregacaoRequestDTO dto){
        Congregacao congregacao = new Congregacao();

        congregacao.setNome(dto.getNome());
        congregacao.setSigla(dto.getSigla());
        congregacao.setEndereco(dto.getEndereco());

        // Buscar entidades relacionadas pelo ID
        if(dto.getSetorId() != null){
            congregacao.setSetor(
                    setorRepository.findById(dto.getSetorId())
                            .orElseThrow(() -> new RuntimeException("Setor não encontrado"))
            );
        }

        Congregacao salva = congregacaoRepository.save(congregacao);
        Congregacao completa = congregacaoRepository.findByIdFetchAll(salva.getCongregacaoId())
                .orElseThrow(()-> new RuntimeException("Congregacao não encontrada"));

        return CongregacaoResponseDTO.fromCongregacao(completa);
    }

    // Update
    public CongregacaoResponseDTO update(CongregacaoEditDTO dto){
        Congregacao congregacao = congregacaoRepository.findById(dto.getCongregacaoId())
                        .orElseThrow(()-> new RuntimeException("Congregação não encontrada"));

        congregacao.setNome(dto.getNome());
        congregacao.setSigla(dto.getSigla());
        congregacao.setEndereco(dto.getEndereco());

        // Relacionamentos (CORRETO)
        if(dto.getSetorId() != null){
            congregacao.setSetor(
                    setorRepository.getReferenceById(dto.getSetorId())
            );
        }

        var result = congregacaoRepository.save(congregacao);

        return CongregacaoResponseDTO.fromCongregacao(result);
    }

    // Delete
    public CongregacaoResponseDTO delete(CongregacaoEditDTO dto){
        Congregacao congregacao = congregacaoRepository.findById(dto.getCongregacaoId())
                .orElseThrow(()-> new RuntimeException("Congregação não encontrada"));

        congregacao.setDeletedAt(dto.getDeletedAt());

        var result = congregacaoRepository.save(congregacao);

        return CongregacaoResponseDTO.fromCongregacao(result);
    }
}
