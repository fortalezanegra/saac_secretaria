package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_ocorrencia.TipoOcorrenciaDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.TipoOcorrenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-ocorrencia")
@CrossOrigin(origins = "*")
public class TipoOcorrenciaController {

    private final TipoOcorrenciaService _service;

    public TipoOcorrenciaController(TipoOcorrenciaService service){
        this._service = service;
    }

    // Dropdown/ComboBox
    @GetMapping("/dropdown")
    public ResponseEntity<List<TipoOcorrenciaDropdownDTO>> getDropdown(){
        List<TipoOcorrenciaDropdownDTO> tipos = _service.dropdown();
        return ResponseEntity.ok(tipos);
    }
}
