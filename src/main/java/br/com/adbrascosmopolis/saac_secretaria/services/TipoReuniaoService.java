package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao.TipoReuniaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao.TipoReuniaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao.TipoReuniaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao.TipoReuniaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoReuniao;
import br.com.adbrascosmopolis.saac_secretaria.repository.TipoReuniaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoReuniaoService {

    private final TipoReuniaoRepository tipoReuniaoRepository;

    public TipoReuniaoService(TipoReuniaoRepository tipoReuniaoRepository){
        this.tipoReuniaoRepository = tipoReuniaoRepository;
    }

    //Dropdown/ComboBox
    public List<TipoReuniaoDropdownDTO> dropdown(){
        List<TipoReuniao> tipo = tipoReuniaoRepository.findAll();

        return tipo.stream()
                .map(t -> new TipoReuniaoDropdownDTO(
                        t.getTipoReuniaoId(),
                        t.getDescricao()
                ))
                .collect(Collectors.toList());
    }

    // Busca todos os Tipos Reuniao
    public List<TipoReuniaoResponseDTO> getAll(){
        List<TipoReuniao> tipo = tipoReuniaoRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));

        return tipo.stream()
                .map(t -> new TipoReuniaoResponseDTO(
                        t.getTipoReuniaoId(),
                        t.getDescricao()
                )).toList();
    }

    // Busca Tipo Reuniao por Id
    public TipoReuniao getById(TipoReuniaoEditDTO dto){
        TipoReuniao tipo = tipoReuniaoRepository.findByTipoReuniaoId(dto.getTipoReuniaoId());
        return tipo;
    }

    // Search By Descrição - Pesquisa avançada
    public List<TipoReuniao> search(TipoReuniaoRequestDTO dto){

        var tipo = new TipoReuniao();

        tipo.setDescricao(dto.getDescricao());

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("TipoReuniaoId")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<TipoReuniao> tipoReuniaoExample = Example.of(tipo, matcher);
        return tipoReuniaoRepository.findAll(tipoReuniaoExample);
    }

    // Create
    @Transactional
    public TipoReuniaoResponseDTO create(TipoReuniaoRequestDTO dto){
        TipoReuniao tipo = new TipoReuniao();

        tipo.setDescricao(dto.getDescricao());

        TipoReuniao salva = tipoReuniaoRepository.save(tipo);
        TipoReuniao completa = tipoReuniaoRepository.findById(salva.getTipoReuniaoId())
                .orElseThrow(()-> new RuntimeException("Tipo Reunião não encontrada"));

        return TipoReuniaoResponseDTO.fromTipoReuniao(completa);
    }

    /* Update */
    @Transactional
    public TipoReuniaoResponseDTO update(TipoReuniaoEditDTO dto) {

        if (dto.getTipoReuniaoId() == null) {
            throw new RuntimeException("TipoReuniaoId não pode ser null");
        }

        TipoReuniao result = tipoReuniaoRepository.findById(dto.getTipoReuniaoId())
                .orElseThrow(() -> new RuntimeException("Tipo Reuniao não encontrado"));

        // Campos simples
        result.setDescricao(dto.getDescricao());

        var tipoReuniaoAtualizada =  tipoReuniaoRepository.save(result);

        return TipoReuniaoResponseDTO.fromTipoReuniao(tipoReuniaoAtualizada);
    }

    /* Delete */
    @Transactional
    public TipoReuniaoResponseDTO delete(TipoReuniaoEditDTO dto) {

        if (dto.getTipoReuniaoId() == null) {
            throw new RuntimeException("TipoReuniaoId não pode ser null");
        }

        TipoReuniao result = tipoReuniaoRepository.findById(dto.getTipoReuniaoId())
                .orElseThrow(() -> new RuntimeException("Tipo Reuniao não encontrado"));

        // Campos simples
        result.setDeletedAt(dto.getDeletedAt());

        var tipoReuniaoAtualizada =  tipoReuniaoRepository.save(result);

        return TipoReuniaoResponseDTO.fromTipoReuniao(tipoReuniaoAtualizada);
    }



}
