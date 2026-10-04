package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.CargoMinisterialSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.PessoaSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.CargoMinisterialSyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sync")
@CrossOrigin(origins = "*")
public class CargoMinisterialSyncController {
    private final CargoMinisterialSyncService _service;

    public CargoMinisterialSyncController(CargoMinisterialSyncService service){
        this._service = service;
    }

    /* Pesquisar Todos os Cargos Ministeriais não deletados */
    @GetMapping("/cargo-ministerial")
    public ResponseEntity<List<CargoMinisterialSyncDTO>> getAllNotDeleted(){
        List<CargoMinisterialSyncDTO> cargos = _service.getCargoMinisterialTesouraria();
        return ResponseEntity.ok(cargos);
    }
}
