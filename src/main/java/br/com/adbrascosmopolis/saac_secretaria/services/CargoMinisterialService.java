package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.cargo_ministerial.CargoMinisterialDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.CargoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.repository.CargoMinisterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoMinisterialService {
    private final CargoMinisterialRepository _repository;

    public CargoMinisterialService(CargoMinisterialRepository repository){
        this._repository = repository;
    }

    public List<CargoMinisterialDropdownDTO> dropdown(){
        List<CargoMinisterial> cargoMinisterial = _repository.findAll();

        return cargoMinisterial.stream()
                .map(c -> new CargoMinisterialDropdownDTO(
                        c.getCargoMinisterialId(),
                        c.getDescricao()
                ))
                .collect(Collectors.toList());
    }

}