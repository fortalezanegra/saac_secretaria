package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.batismo.BatismoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.batismo.BatismoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.batismo.BatismoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.batismo.BatismoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Batismo;
import br.com.adbrascosmopolis.saac_secretaria.repository.BatismoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.CongregacaoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SituacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatismoService {

    private final BatismoRepository batismoRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final SituacaoRepository situacaoRepository;

    public BatismoService(
            BatismoRepository batismoRepository,
            CongregacaoRepository congregacaoRepository,
            SituacaoRepository situacaoRepository
    ){
        this.batismoRepository = batismoRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.situacaoRepository = situacaoRepository;

    }

    // Dropdown/ComboBox
    public List<BatismoDropdownDTO> dropdown() {
        List<Batismo> batismos = batismoRepository.findAll();

        return batismos.stream()
                .map(b -> new BatismoDropdownDTO(
                        b.getBatismoId(),
                        b.getCongregacao() != null ? b.getCongregacao().getNome() : null,
                        b.getDataBatismo()
                ))
                .collect(Collectors.toList());
    }

    // Busca todas os Batismos
    public List<BatismoResponseDTO> listAll(){
        List<Batismo> batismo = batismoRepository.findAll();

        return batismo.stream()
                .map(b -> new BatismoResponseDTO(
                        b.getBatismoId(),
                        b.getCongregacao() != null ? b.getCongregacao().getNome() : null,
                        b.getDataBatismo(),
                        b.getSituacao() != null ? b.getSituacao().getDescricao() : null
                )).toList();
    }

    // Busca Batismo por Id
    public Batismo listById(Integer id){
        Batismo batismo = batismoRepository.findByBatismoId(id);
        return batismo;
    }

    // Busca Batismo por congregacaoId
    public List<BatismoResponseDTO> listByCongregacaoId(Long id){
        List<Batismo> batismo = batismoRepository.findByCongregacaoCongregacaoId(id);

        return batismo.stream()
                .map(b -> new BatismoResponseDTO(
                        b.getBatismoId(),
                        b.getCongregacao() != null ? b.getCongregacao().getNome() : null,
                        b.getDataBatismo(),
                        b.getSituacao() != null ? b.getSituacao().getDescricao() : null
                )).toList();
    }

    // Search By Data - Search Advanced
    public List<Batismo> searchByExample(LocalDate data){

        var batismo = new Batismo();

        batismo.setDataBatismo(data);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("batismoId",
                        "congregacaoId",
                        "situacaoId")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Batismo> batismoExample = Example.of(batismo, matcher);
        return batismoRepository.findAll(batismoExample);
    }

    // Create
    @Transactional
    public BatismoResponseDTO create(BatismoRequestDTO dto){
        Batismo batismo = new Batismo();

        batismo.setDataBatismo(dto.getDataBatismo());

        // Buscar entidades relacionadas pelo ID
        if(dto.getCongregacaoId() != null){
            batismo.setCongregacao(
                    congregacaoRepository.findById(dto.getCongregacaoId())
                            .orElseThrow(() -> new RuntimeException("Congregaçãop não encontrado"))
            );
        }

        Batismo salvo = batismoRepository.save(batismo);
        Batismo completo = batismoRepository.findByIdFetchAll(salvo.getBatismoId())
                .orElseThrow(()-> new RuntimeException("Batismo não encontrado"));

        return BatismoResponseDTO.fromBatismo(completo);
    }

    // Update
    public Batismo update(BatismoEditDTO dto){
        Batismo result = batismoRepository.findById(dto.getBatismoId())
                .orElseThrow(()-> new RuntimeException("Batismo não encontrado"));

        result.setDataBatismo(dto.getDataBatismo());

        // Relacionamentos
        if(dto.getCongregacaoId() != null){
            result.setCongregacao(
                    congregacaoRepository.getReferenceById(dto.getCongregacaoId())
            );
        }

        if(dto.getSituacaoId() != null){
            result.setSituacao(
                    situacaoRepository.getReferenceById(dto.getCongregacaoId())
            );
        }

        return batismoRepository.save(result);
    }

    // Delete
    public Batismo delete(BatismoEditDTO dto){
        Batismo result = batismoRepository.findById(dto.getBatismoId())
                .orElseThrow(()-> new RuntimeException("Batismo não encontrado"));

        result.setDeletedAt(dto.getDeletedAt());

        return batismoRepository.save(result);
    }

}
