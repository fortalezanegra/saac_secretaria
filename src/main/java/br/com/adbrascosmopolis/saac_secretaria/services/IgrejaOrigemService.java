package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem.IgrejaOrigemDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem.IgrejaOrigemEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem.IgrejaOrigemRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem.IgrejaOrigemResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.IgrejaOrigem;
import br.com.adbrascosmopolis.saac_secretaria.repository.IgrejaOrigemRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IgrejaOrigemService {

    private final IgrejaOrigemRepository igrejaOrigemRepository;

    public IgrejaOrigemService(IgrejaOrigemRepository igrejaOrigemRepository){
        this.igrejaOrigemRepository = igrejaOrigemRepository;
    }

    // Dropdown/ComboBox
    public List<IgrejaOrigemDropdownDTO> dropdown() {
        List<IgrejaOrigem> igrejas = igrejaOrigemRepository.buscarTodasIgrejasOrigem();

        return igrejas.stream()
                .map(i -> new IgrejaOrigemDropdownDTO(
                        i.getIgrejaOrigemId(),
                        i.getDescricao()
                ))
                .collect(Collectors.toList());
    }

    // Busca todas as Igrejas
    public List<IgrejaOrigemResponseDTO> listAll(){
        List<IgrejaOrigem> igrejas = igrejaOrigemRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));

        return igrejas.stream()
                .map(i -> new IgrejaOrigemResponseDTO(
                        i.getIgrejaOrigemId(),
                        i.getDescricao()
                )).toList();
    }

    // Busca IgrejaOrigem por Id
    public IgrejaOrigem listById(Integer id){
        IgrejaOrigem igreja = igrejaOrigemRepository.findByIgrejaOrigemId(id);
        return igreja;
    }

    // Search By Descricao - Search Advanced
    public List<IgrejaOrigem> search(String descricao){

        var igreja = new IgrejaOrigem();
        igreja.setDescricao(descricao);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("igrejaOrigemId")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<IgrejaOrigem> igrejaOrigemExample = Example.of(igreja, matcher);
        return igrejaOrigemRepository.findAll(igrejaOrigemExample);
    }

    // Create
    @Transactional
    public IgrejaOrigemResponseDTO create(IgrejaOrigemRequestDTO dto){
        IgrejaOrigem igreja = new IgrejaOrigem();

        igreja.setDescricao(dto.getDescricao());

        IgrejaOrigem salva = igrejaOrigemRepository.save(igreja);
        IgrejaOrigem completa = igrejaOrigemRepository.findByIdFetchAll(salva.getIgrejaOrigemId())
                .orElseThrow(()-> new RuntimeException("Congregacao não encontrada"));

        return IgrejaOrigemResponseDTO.fromIgrejaOrigem(completa);
    }

    // Update
    public IgrejaOrigemResponseDTO update(IgrejaOrigemEditDTO dto){

        IgrejaOrigem igreja = igrejaOrigemRepository.findById(dto.getIgrejaOrigemId())
                .orElseThrow(()-> new RuntimeException("Igreja de Origem não encontrada"));

        igreja.setDescricao(dto.getDescricao());

        var result = igrejaOrigemRepository.save(igreja);

        return IgrejaOrigemResponseDTO.fromIgrejaOrigem(result);
    }

    // Delete
    public IgrejaOrigemResponseDTO delete(IgrejaOrigemEditDTO dto){

        IgrejaOrigem igreja = igrejaOrigemRepository.findById(dto.getIgrejaOrigemId())
                .orElseThrow(()-> new RuntimeException("Igreja Origem não encontrada"));

        igreja.setDeletedAt(dto.getDeletedAt());

        var result = igrejaOrigemRepository.save(igreja);

        return IgrejaOrigemResponseDTO.fromIgrejaOrigem(result);
    }
}
