package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.situacao.SituacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.repository.CongregacaoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.ReuniaoMinisterialRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SituacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReuniaoMinisterialService {

    private final ReuniaoMinisterialRepository reuniaoMinisterialRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final SituacaoRepository situacaoRepository;

    public ReuniaoMinisterialService(
            ReuniaoMinisterialRepository reuniaoMinisterialRepository,
            CongregacaoRepository congregacaoRepository,
            SituacaoRepository situacaoRepository){
        this.reuniaoMinisterialRepository = reuniaoMinisterialRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.situacaoRepository = situacaoRepository;
    }

    /* Dropdown Reunioes */
    public List<ReuniaoMinisterialDropdownDTO> dropdown() {

        List<ReuniaoMinisterial> reuniao = reuniaoMinisterialRepository.listDropdown();

        return reuniao.stream()
                .map(r -> new ReuniaoMinisterialDropdownDTO(
                        r.getReuniaoMinisterialId(),
                        r.getTipoReuniao(),
                        r.getCongregacao().getNome(),
                        r.getDataReuniao()
                ))
                .collect(Collectors.toList());
    }

    /* Dropdown Situações com Contexto = REUNIAO_MINISTERIAL */
    public List<SituacaoDropdownDTO> dropdownSituacao(String contexto) {

        List<SituacaoDropdownDTO> situacaoes = situacaoRepository.listarDropdownPorContexto(contexto);

        return situacaoes.stream()
                .map(r -> new SituacaoDropdownDTO(
                        r.getSituacaoId(),
                        r.getDescricao()
                ))
                .collect(Collectors.toList());
    }

    // Bucar por dataReuniao
    public ReuniaoMinisterial listByDate(LocalDate dataReuniao){
        var reuniao = reuniaoMinisterialRepository.findByDataReuniao(dataReuniao);
        return reuniao;
    }

    // Buscar por todas as Reuniões
    public List<ReuniaoMinisterialResponseDTO> listAllNotDeleted(){
        List<ReuniaoMinisterial> reuniao = reuniaoMinisterialRepository.listAllNotDeleted();

        return reuniao.stream()
                .map( r -> new ReuniaoMinisterialResponseDTO(
                        r.getReuniaoMinisterialId(),
                        r.getTipoReuniao(),
                        r.getCongregacao() != null ? r.getCongregacao().getCongregacaoId() : null,
                        r.getCongregacao() != null ? r.getCongregacao().getNome() : null,
                        r.getDataReuniao(),
                        r.getSituacao() != null ? r.getSituacao().getSituacaoId() : null,
                        r.getSituacao() != null ? r.getSituacao().getDescricao() : null
                )).toList();
    }

    // Buscar Reuniao Ministerial por reuniaoMinisterialId
    public ReuniaoMinisterial listById(Long id){
        ReuniaoMinisterial reuniao = reuniaoMinisterialRepository.findByReuniaoMinisterialId(id);
        return reuniao;
    }

    // Search By Date - Search Advanced
    public List<ReuniaoMinisterial> search(LocalDate dataReuniao){

        var reuniao = new ReuniaoMinisterial();

        reuniao.setDataReuniao(dataReuniao);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("reuniaoMinisterialId",
                        "tipoReuniaoId",
                        "congregacaoId",
                        "situacaoId")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<ReuniaoMinisterial> reuniaoExample = Example.of(reuniao, matcher);
        return reuniaoMinisterialRepository.findAll(reuniaoExample);
    }

    // Create
    @Transactional
    public ReuniaoMinisterialResponseDTO create(ReuniaoMinisterialRequestDTO dto){

        ReuniaoMinisterial reuniao = new ReuniaoMinisterial();

        //DataReuniao
        reuniao.setDataReuniao(dto.getDataReuniao());
        reuniao.setTipoReuniao(dto.getTipoReuniao());


        if(dto.getCongregacaoId() != null){
            reuniao.setCongregacao(
                    congregacaoRepository.findById(dto.getCongregacaoId())
                            .orElseThrow(() -> new RuntimeException("Congregação não encontrada"))
            );
        }

        if(dto.getSituacaoId() != null){
            reuniao.setSituacao(
                    situacaoRepository.findById(dto.getSituacaoId())
                            .orElseThrow(() -> new RuntimeException("Situação não encontrada"))
            );
        }

        ReuniaoMinisterial salva = reuniaoMinisterialRepository.save(reuniao);
            ReuniaoMinisterial completa = reuniaoMinisterialRepository.findByIdFetchAll(salva.getReuniaoMinisterialId())
                    .orElseThrow(()-> new RuntimeException("Reunião não encontrada"));

        return ReuniaoMinisterialResponseDTO.fromReuniaoMinisterial(completa);
    }

    // Update
    public ReuniaoMinisterialResponseDTO update(ReuniaoMinisterialEditDTO dto){
        ReuniaoMinisterial result = reuniaoMinisterialRepository.findById(dto.getReuniaoMinisterialId())
                .orElseThrow(()-> new RuntimeException("Reunião Ministerial não encontrada"));

        result.setTipoReuniao(dto.getTipoReuniao());
        result.setDataReuniao(dto.getDataReuniao());
        result.setDeletedAt(dto.getDeletedAt());



        if(dto.getCongregacaoId() != null){
            result.setCongregacao(
                    congregacaoRepository.getReferenceById(dto.getCongregacaoId())
            );
        }

        if(dto.getSituacaoId() != null){
            result.setSituacao(
                    situacaoRepository.getReferenceById(dto.getSituacaoId())
            );
        }

        return ReuniaoMinisterialResponseDTO.fromReuniaoMinisterial(reuniaoMinisterialRepository.save(result));
    }

    // Delete
    public ReuniaoMinisterialResponseDTO delete(ReuniaoMinisterialEditDTO dto){
        ReuniaoMinisterial result = reuniaoMinisterialRepository.findById(dto.getReuniaoMinisterialId())
                .orElseThrow(()-> new RuntimeException("Reunião Ministerial não encontrada"));

        result.setDeletedAt(LocalDateTime.now());

        return ReuniaoMinisterialResponseDTO.fromReuniaoMinisterial(reuniaoMinisterialRepository.save(result));
    }
}
