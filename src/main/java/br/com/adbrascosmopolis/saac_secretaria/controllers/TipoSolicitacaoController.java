package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_solicitacao.TipoSolicitacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.services.TipoSolicitacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-solicitacao")
@CrossOrigin(origins = "*")
public class TipoSolicitacaoController {

    private final TipoSolicitacaoService _service;

    public TipoSolicitacaoController(TipoSolicitacaoService service){
        this._service = service;
    }

    // Dropdown/ComboBox
    @GetMapping("/dropdown")
    public ResponseEntity<List<TipoSolicitacaoDropdownDTO>> getDropdown(){
        List<TipoSolicitacaoDropdownDTO> tipos = _service.dropdown();
        return ResponseEntity.ok(tipos);
    }

}
