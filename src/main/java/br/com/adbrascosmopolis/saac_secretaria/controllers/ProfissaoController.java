package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.profissao.ProfissaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.ProfissaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profissao")
@CrossOrigin(origins = "*")
public class ProfissaoController {

    private final ProfissaoService _service;

    public ProfissaoController(ProfissaoService service){
        this._service = service;
    }

    @GetMapping()
    public ResponseEntity<List<ProfissaoDropdownDTO>> getAll(){
        List<ProfissaoDropdownDTO> profissoes = _service.dropdown();
        return ResponseEntity.ok(profissoes);
    }
}
