package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.cidade.CidadeDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.CidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
@CrossOrigin(origins = "*")
public class CidadeController {

    private final CidadeService _service;

    public CidadeController(CidadeService service){
        this._service = service;
    }

    /* Dropdown Cidades */
    @GetMapping("/dropdown")
    public ResponseEntity<List<CidadeDropdownDTO>> getDropdown(){

        List<CidadeDropdownDTO> cidades = _service.dropdown();
        return ResponseEntity.ok(cidades);
    }



}
