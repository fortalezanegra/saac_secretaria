package br.com.adbrascosmopolis.saac_secretaria.controllers;


import br.com.adbrascosmopolis.saac_secretaria.dto.estado_civil.EstadoCivilDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.EstadoCivilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estado-civil")
@CrossOrigin(origins = "*")
public class EstadoCivilController {

    private final EstadoCivilService _service;

    public EstadoCivilController(EstadoCivilService service){
        this._service = service;
    }

    @GetMapping()
    public ResponseEntity<List<EstadoCivilDropdownDTO>> getAll() {
        List<EstadoCivilDropdownDTO> estadoCivil = _service.dropdown();
        return ResponseEntity.ok(estadoCivil);
    }
}
