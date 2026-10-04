package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.CongregacaoSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.CongregacaoSyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sync")
@CrossOrigin(origins = "*")
public class CongregacaoSyncController {

    private final CongregacaoSyncService _service;

    public CongregacaoSyncController(CongregacaoSyncService service){
        this._service = service;
    }

    /* Pesquisar Todas asCongregações não deletadas */
    @GetMapping("/congregacao")
    public ResponseEntity<List<CongregacaoSyncDTO>> getAllNotDeleted(){
        List<CongregacaoSyncDTO> congregacoes = _service.getCongregacaoSyncTesouraria();
        return ResponseEntity.ok(congregacoes);
    }

}
