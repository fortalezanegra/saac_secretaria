package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.pauta_reuniao.PautaReuniaoListDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialFilterDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.situacao.SituacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.repository.projection.DecisaoMinisterialResumo;
import br.com.adbrascosmopolis.saac_secretaria.services.DecisaoMinisterialService;
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
    private final DecisaoMinisterialService decisaoMinisterialService;

    public PautaReuniaoMinisterialController(
            PautaReuniaoMinisterialService service,
            DecisaoMinisterialService decisaoMinisterialService){
        this.service = service;
        this.decisaoMinisterialService = decisaoMinisterialService;
    }

    //Dropdown Situações de Decisao Ministerial
    @GetMapping("/situacao-decisao")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_LOCAL')")
    public ResponseEntity<List<SituacaoDropdownDTO>> dropdownSituacaoDecisao(){
        List<SituacaoDropdownDTO> situacoes = decisaoMinisterialService.dropdownSitaucaoDecisaoMinisterial();
        return ResponseEntity.ok(situacoes);
    }



    // Listar Pauta em aberto
    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_LOCAL')")
    public ResponseEntity<List<PautaReuniaoListDTO>> dropdown(){
        List<PautaReuniaoListDTO> pautaReuniao = service.listarSolicitacoesDaPauta();
        return ResponseEntity.ok(pautaReuniao);
    }

    //Gerar Pauta Reuniao
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
