package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.cargo_ministerial.CargoMinisterialDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.CargoMinisterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/cargo-ministerial")
@CrossOrigin(origins = "*")
public class CargoMinisterialController {
    private final CargoMinisterialService _service;

    public CargoMinisterialController(CargoMinisterialService service){
        this._service = service;
    }

    @GetMapping()
    public ResponseEntity<List<CargoMinisterialDropdownDTO>> getAll() {
        List<CargoMinisterialDropdownDTO> cargoMinisterial = _service.dropdown();
        return ResponseEntity.ok(cargoMinisterial);
    }
}
