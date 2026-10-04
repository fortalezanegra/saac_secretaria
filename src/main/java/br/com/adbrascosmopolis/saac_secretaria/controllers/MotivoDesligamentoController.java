package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.motivo_desligamento.MotivoDesligamentoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.MotivoDesligamento;
import br.com.adbrascosmopolis.saac_secretaria.services.MotivoDesligamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/motivo-desligamento")
@CrossOrigin(origins = "*")
public class MotivoDesligamentoController {

    private final MotivoDesligamentoService _service;

    public MotivoDesligamentoController(MotivoDesligamentoService service){
        this._service = service;
    }

    // Dropdown/ComboBox
    @GetMapping("/dropdown")
    public ResponseEntity<List<MotivoDesligamentoDropdownDTO>> getDropdown(){
        List<MotivoDesligamentoDropdownDTO> motivos = _service.dropdown();
        return ResponseEntity.ok(motivos);
    }
}
