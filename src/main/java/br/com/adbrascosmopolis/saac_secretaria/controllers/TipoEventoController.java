package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_evento.TipoEventoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.TipoEventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/tipo-evento")
@CrossOrigin(origins = "*")
public class TipoEventoController {

    private final TipoEventoService _service;

    public TipoEventoController(TipoEventoService service){
        this._service = service;
    }

    // Dropdown/ComboBox
    @GetMapping("/dropdown")
    public ResponseEntity<List<TipoEventoDropdownDTO>> getDropdown(){
        List<TipoEventoDropdownDTO> tipos = _service.dropdown();
        return ResponseEntity.ok(tipos);
    }


}
