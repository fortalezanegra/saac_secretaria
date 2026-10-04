package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.PessoaSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.PessoaSyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sync")
@CrossOrigin(origins = "*")
public class PessoaSyncController {

    private final PessoaSyncService _service;

    public PessoaSyncController(PessoaSyncService service) {
        this._service = service;
    }

    /* Pesquisar Todas as Pessoas não deletadas */
    @GetMapping("/pessoa")
    public ResponseEntity<List<PessoaSyncDTO>> getAllNotDeleted(){
        List<PessoaSyncDTO> pessoas = _service.getPessoaSyncTesouraria();
        return ResponseEntity.ok(pessoas);
    }

}
