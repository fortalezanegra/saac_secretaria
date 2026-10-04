package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_batismo.SolicitacaoUniaoBatismoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_batismo.SolicitacaoUniaoBatismoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_batismo.SolicitacaoUniaoBatismoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_mudanca.SolicitacaoUniaoMudancaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_mudanca.SolicitacaoUniaoMudancaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_mudanca.SolicitacaoUniaoMudancaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.SolicitacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/solicitacao")
@CrossOrigin(origins = "*")
public class SolicitacaoController {

        private final SolicitacaoService _service;

        public SolicitacaoController(SolicitacaoService service){
            this._service = service;
        }

    /* ************************************************
     ******** SOLICITAÇÃO DE UNIÃO POR BATISMO *********
    ************************************************* */

    @GetMapping("/uniao-batismo/all")
    public ResponseEntity<List<SolicitacaoUniaoBatismoResponseDTO>> buscarTodasUniaoBatismo() {
        List<SolicitacaoUniaoBatismoResponseDTO> solicitacaoes = _service.listarTodasSolicitacoesUniaoBatismo();
        return ResponseEntity.ok(solicitacaoes);
    }

    @GetMapping("/uniao-batismo/congregacao/{id}")
    public ResponseEntity<?> buscarUniaoBatismoPorCongregacao(@PathVariable Integer id) {
        List<SolicitacaoUniaoBatismoResponseDTO> solicitacaoes = _service.listarSolicitacoesUniaoBatismoPorCongregacao(id);
        return ResponseEntity.ok(solicitacaoes);
    }

    @GetMapping("/uniao-batismo/{id}")
    public ResponseEntity<SolicitacaoUniaoBatismoResponseDTO> buscarUniaoBatismoPorId(@PathVariable Long id) {
        SolicitacaoUniaoBatismoResponseDTO solicitacao = _service.listarSolicitacaoUniaoBatismoPorId(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping("/uniao-batismo/situacao/{situacao}")
    public ResponseEntity<List<SolicitacaoUniaoBatismoResponseDTO>> buscarUniaoBatismoPorSituacao(@PathVariable String situacao) {
        List<SolicitacaoUniaoBatismoResponseDTO> solicitacao = _service.listarSolicitacoesUniaoBatismoPorSituacao(situacao);
        return ResponseEntity.ok(solicitacao);
    }

    @PostMapping("/uniao-batismo/create")
    public ResponseEntity<Object> createUniaoBatismo(@RequestBody SolicitacaoUniaoBatismoRequestDTO dto) {
        try {
            SolicitacaoUniaoBatismoResponseDTO responseDTO = _service.createUniaoBatismo(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO)
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/uniao-batismo/update")
    public ResponseEntity<SolicitacaoUniaoBatismoResponseDTO> updateUniaoBatismo(
            @RequestBody SolicitacaoUniaoBatismoEditDTO dto) {
        SolicitacaoUniaoBatismoResponseDTO solicitacao = _service.updateUniaoBatismo(dto);
        return ResponseEntity.ok(solicitacao);
    }

    @PutMapping("/uniao-batismo/delete")
    public ResponseEntity<SolicitacaoUniaoBatismoResponseDTO> deleteUniaoBatismo(
            @RequestBody SolicitacaoUniaoBatismoEditDTO dto) {
        SolicitacaoUniaoBatismoResponseDTO solicitacao = _service.deleteUniaoBatismo(dto);
        return ResponseEntity.ok(solicitacao);
    }

    /* ******* FIM SOLICITAÇÃO DE UNIÃO POR BATISMO ******** */


    /* ************************************************
     ******** SOLICITAÇÃO DE UNIÃO POR MUDANÇA *********
     ************************************************* */

    @GetMapping("/uniao-mudanca/all")
    public ResponseEntity<List<SolicitacaoUniaoMudancaResponseDTO>> buscarTodasUniaoMudanca() {
        List<SolicitacaoUniaoMudancaResponseDTO> solicitacaoes = _service.listarTodasSolicitacoesUniaoMudanca();
        return ResponseEntity.ok(solicitacaoes);
    }

    @GetMapping("/uniao-mudanca/congregacao/{id}")
    public ResponseEntity<?> buscarUniaoMudancaPorCongregacao(@PathVariable Integer id) {
        List<SolicitacaoUniaoMudancaResponseDTO> solicitacaoes = _service.listarSolicitacoesUniaoMudancaPorCongregacao(id);
        return ResponseEntity.ok(solicitacaoes);
    }

    @GetMapping("/uniao-mudanca/{id}")
    public ResponseEntity<SolicitacaoUniaoMudancaResponseDTO> buscarUniaoMudancaPorId(@PathVariable Long id) {
        SolicitacaoUniaoMudancaResponseDTO solicitacao = _service.listarSolicitacaoUniaoMudancaPorId(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping("/uniao-mudanca/situacao/{situacao}")
    public ResponseEntity<List<SolicitacaoUniaoMudancaResponseDTO>> buscarUniaoMudancaPorSituacao(@PathVariable String situacao) {
        List<SolicitacaoUniaoMudancaResponseDTO> solicitacao = _service.listarSolicitacoesUniaoMudancaPorSituacao(situacao);
        return ResponseEntity.ok(solicitacao);
    }

    @PostMapping("/uniao-mudanca/create")
    public ResponseEntity<Object> createUniaoMudanca(@RequestBody SolicitacaoUniaoMudancaRequestDTO dto) {
        try {
            SolicitacaoUniaoMudancaResponseDTO responseDTO = _service.createUniaoMudanca(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO)
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/uniao-mudanca/update")
    public ResponseEntity<SolicitacaoUniaoMudancaResponseDTO> updateUniaoMudanca(
            @RequestBody SolicitacaoUniaoMudancaEditDTO dto) {
        SolicitacaoUniaoMudancaResponseDTO solicitacao = _service.updateUniaoMudanca(dto);
        return ResponseEntity.ok(solicitacao);
    }

    @PutMapping("/uniao-mudanca/delete")
    public ResponseEntity<SolicitacaoUniaoMudancaResponseDTO> deleteUniaoMudanca(
            @RequestBody SolicitacaoUniaoMudancaEditDTO dto) {
        SolicitacaoUniaoMudancaResponseDTO solicitacao = _service.deleteUniaoMudanca(dto);
        return ResponseEntity.ok(solicitacao);
    }

    /* ******* FIM SOLICITAÇÃO DE UNIÃO POR MUDANCA ******** */

}
