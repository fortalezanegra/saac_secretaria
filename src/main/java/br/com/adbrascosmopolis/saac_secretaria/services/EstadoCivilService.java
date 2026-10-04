package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.estado_civil.EstadoCivilDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.EstadoCivil;
import br.com.adbrascosmopolis.saac_secretaria.repository.EstadoCivilRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoCivilService {

    private final EstadoCivilRepository _repository;

    public EstadoCivilService(EstadoCivilRepository repository){
        this._repository = repository;
    }

    public List<EstadoCivilDropdownDTO> dropdown(){

        List<EstadoCivil> estadoCivil = _repository.findAll();

        return estadoCivil.stream()
                .map(e -> new EstadoCivilDropdownDTO(
                        e.getEstadoCivilId(),
                        e.getDescricao()
                ))
                .collect(Collectors.toList());
    }
}
