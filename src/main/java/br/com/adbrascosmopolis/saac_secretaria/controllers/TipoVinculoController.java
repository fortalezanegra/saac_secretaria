package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_vinculo.TipoVinculoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.TipoVinculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-vinculo")
@CrossOrigin(origins = "*")
public class TipoVinculoController {

    private final TipoVinculoService _service;

    public TipoVinculoController(TipoVinculoService service){
        this._service = service;
    }

    // Dropdown/ComboBox
    @GetMapping()
    @PreAuthorize("hasAuthority('PERMISSION_TESOURARIA_MOVIMENTO_FINANCEIRO_READ_GLOBAL') or hasAuthority('PERMISSION_TESOURARIA_MOVIMENTO_FINANCEIRO_READ_LOCAL')")
    public ResponseEntity<List<TipoVinculoDropdownDTO>> getAll(){
        List<TipoVinculoDropdownDTO> tipoVinculo = _service.dropdown();
        return ResponseEntity.ok(tipoVinculo);
    }

}
