package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialFilterDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.repository.projection.DecisaoMinisterialResumo;
import br.com.adbrascosmopolis.saac_secretaria.services.PautaReuniaoMinisterialService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pauta-reuniao")
@CrossOrigin(origins = "*")
public class PautaReuniaoMinisterialController {

    private final PautaReuniaoMinisterialService service;

    public PautaReuniaoMinisterialController(PautaReuniaoMinisterialService service){
        this.service = service;
    }

    @PostMapping("/gerar")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_CREATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_CREATE_LOCAL')")
    public ResponseEntity<List<DecisaoMinisterialResumo>> gerarPauta(
            @Valid @RequestBody ReuniaoMinisterialFilterDTO dto) {

        List<DecisaoMinisterialResumo> resumo = service.gerarPauta(dto.getReuniaoMinisterialId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resumo);
    }














}
