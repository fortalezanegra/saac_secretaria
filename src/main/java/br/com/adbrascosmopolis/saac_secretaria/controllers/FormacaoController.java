package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.formacao.FormacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.FormacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/formacao")
@CrossOrigin(origins = "*")
public class FormacaoController {

    private final FormacaoService _service;

    public FormacaoController(FormacaoService service){
        this._service = service;
    }

    @GetMapping()
    public ResponseEntity<List<FormacaoDropdownDTO>> getAll(){
        List<FormacaoDropdownDTO> formacoes = _service.dropdown();
        return ResponseEntity.ok(formacoes);
    }
}