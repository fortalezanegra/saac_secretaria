package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.sexo.SexoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Sexo;
import br.com.adbrascosmopolis.saac_secretaria.repository.SexoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SexoService {

    private final SexoRepository _repository;

    public SexoService(SexoRepository repository){
        this._repository = repository;
    }

    public List<SexoDropdownDTO> dropdown() {
        List<Sexo> sexos = _repository.findAll();

        return sexos.stream()
                .map(s -> new SexoDropdownDTO(
                        s.getSexoId(),
                        s.getDescricao()
                ))
                .collect(Collectors.toList());
    }




}
