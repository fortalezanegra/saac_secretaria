package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_evento.TipoEventoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.TipoEventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-evento")
@CrossOrigin(origins = "*")
public class TipoEventoController {

    private final TipoEventoService service;

    public TipoEventoController(TipoEventoService service){
        this.service = service;
    }

    // Dropdown
    @GetMapping("/dropdown")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_TIPO_EVENTO_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_TIPO_EVENTO_READ_LOCAL')")
    public ResponseEntity<List<TipoEventoDropdownDTO>> getDropdown(){
        List<TipoEventoDropdownDTO> tipos = service.dropdown();
        return ResponseEntity.ok(tipos);
    }


















}
