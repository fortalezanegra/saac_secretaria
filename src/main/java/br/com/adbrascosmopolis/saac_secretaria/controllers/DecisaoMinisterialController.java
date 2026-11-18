package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.deciso_ministerial.DecisaoMinisterialEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.deciso_ministerial.DecisaoMinisterialResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.DecisaoMinisterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/decisao-ministerial")
@CrossOrigin(origins = "*")
public class DecisaoMinisterialController {

    private final  DecisaoMinisterialService service;

    public DecisaoMinisterialController(DecisaoMinisterialService service){
        this.service = service;
    }

    //Update
    @PutMapping()
    public ResponseEntity<DecisaoMinisterialResponseDTO> update(
            @RequestBody DecisaoMinisterialEditDTO dto) {

        DecisaoMinisterialResponseDTO decisao = service.updateDecisaoAndSolicitacao(dto);

        return ResponseEntity.ok(decisao);

    }


}
