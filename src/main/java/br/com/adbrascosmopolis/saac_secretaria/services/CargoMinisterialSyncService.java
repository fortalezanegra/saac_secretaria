package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.CargoMinisterialSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.CargoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.repository.CargoMinisterialSyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoMinisterialSyncService {

    @Autowired
    private final CargoMinisterialSyncRepository _repository;

    public CargoMinisterialSyncService(CargoMinisterialSyncRepository repository){
        this._repository = repository;
    }

    //Get All Npt Deleted
    public List<CargoMinisterialSyncDTO> getCargoMinisterialTesouraria(){
        List<CargoMinisterial> cargos = _repository.getCargoMinisterialSyncTesouraria();
        return cargos.stream()
                .map(c -> new CargoMinisterialSyncDTO(
                        c.getCargoMinisterialId(),
                        c.getDescricao()
                )).toList();
    }




}
