package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.CongregacaoSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.TipoVinculoSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.CongregacaoSyncService;
import br.com.adbrascosmopolis.saac_secretaria.services.TipoVinculoSyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sync")
@CrossOrigin(origins = "*")
public class TipoVinculoSyncController {

    private final TipoVinculoSyncService _service;

    public TipoVinculoSyncController(TipoVinculoSyncService service){
        this._service = service;
    }

    /* Pesquisar Todas os Tipos Vinculo não deletados */
    @GetMapping("/tipo-vinculo")
    public ResponseEntity<List<TipoVinculoSyncDTO>> getAllNotDeleted(){
        List<TipoVinculoSyncDTO> tipos = _service.getTipoVinculoSyncTesouraria();
        return ResponseEntity.ok(tipos);
    }
}
