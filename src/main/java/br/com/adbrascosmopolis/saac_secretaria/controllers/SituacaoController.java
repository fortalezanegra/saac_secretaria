package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.situacao.SituacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.SituacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/situacao")
@CrossOrigin(origins = "*")
public class SituacaoController {

    private final SituacaoService _service;

    public SituacaoController(SituacaoService service) {
        this._service = service;
    }

    @GetMapping("/{contexto}")
    public ResponseEntity<List<SituacaoDropdownDTO>> getDropdownSituacaoContexto(@PathVariable("contexto") String contexto){
        List<SituacaoDropdownDTO> situacao = _service.dropdownSituacaoContexto(contexto);
        return ResponseEntity.ok(situacao);
    }

}