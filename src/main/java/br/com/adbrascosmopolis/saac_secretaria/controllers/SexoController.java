package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.sexo.SexoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.SexoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/sexo")
@CrossOrigin(origins = "*")
public class SexoController {

    private final SexoService _service;

    public SexoController(SexoService service){
        this._service = service;
    }

    @GetMapping()
    public ResponseEntity<List<SexoDropdownDTO>> getAll(){
        List<SexoDropdownDTO> sexos = _service.dropdown();
        return ResponseEntity.ok(sexos);
    }

}