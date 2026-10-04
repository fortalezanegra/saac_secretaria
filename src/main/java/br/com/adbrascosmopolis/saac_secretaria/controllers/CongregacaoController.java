package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.services.CongregacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/congregacao")
@CrossOrigin(origins = "*")
public class CongregacaoController {

    private final CongregacaoService _service;

    public CongregacaoController(CongregacaoService service){
        this._service = service;
    }

    // Dropdown/ComboBox
    @GetMapping()
    public ResponseEntity<List<CongregacaoDropdownDTO>> getAll(){
        List<CongregacaoDropdownDTO> congregacoes = _service.dropdown();
        return ResponseEntity.ok(congregacoes);
    }

    // Buscar todas as congregações
    @GetMapping("/all")
    public ResponseEntity<List<CongregacaoResponseDTO>> getAllComplete() {
        List<CongregacaoResponseDTO> congregacoes = _service.listAll();
        return ResponseEntity.ok(congregacoes);
    }

    // Buscar Congregação por Id
    @GetMapping("/{id}")
    public ResponseEntity<CongregacaoResponseDTO> getById(@PathVariable Integer id) {
        Congregacao c = _service.listById(id);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(CongregacaoResponseDTO.fromCongregacao(c));
    }

    // Listar Congregação por Setor
    @GetMapping("/setor/{id}")
    public ResponseEntity<List<CongregacaoResponseDTO>> listarPorSetor(@PathVariable Integer id) {
        List<CongregacaoResponseDTO> congregacoes = _service.listBySetor(id);
        return ResponseEntity.ok(congregacoes);
    }

    // Search By Nome - Pesquisa Avançada
    @GetMapping("/search")
    public ResponseEntity<List<CongregacaoResponseDTO>> search(
            @RequestParam(value = "nome", required = false) String nome) {
        List<CongregacaoResponseDTO> congregacao = _service.searchByExample(nome)
                .stream()
                .map(CongregacaoResponseDTO::fromCongregacao)
                .collect(Collectors.toList());
        return ResponseEntity.ok(congregacao);
    }

    // Endpoint para buscar  congregacao por ID para edição
    @GetMapping("/edit/{id}")
    public ResponseEntity<CongregacaoEditDTO> getCongregacaoForEdit(@PathVariable Integer id) {
        Congregacao c = _service.listById(id);
        if (c == null) {
            return ResponseEntity.notFound().build();
        }

        // Converte a congregacao para um DTO específico para edição
        CongregacaoEditDTO dto = CongregacaoEditDTO.fromCongregacao(c);

        return ResponseEntity.ok(dto);
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CongregacaoRequestDTO dto) {
        try {
            // Passa o DTO direto para o Service
            CongregacaoResponseDTO responseDTO = _service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO.getCongregacaoId())
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Update
    @PutMapping("/update")
    public ResponseEntity<CongregacaoResponseDTO> update(
            @RequestBody CongregacaoEditDTO dto) {

        CongregacaoResponseDTO congregacao = _service.update(dto);
        return ResponseEntity.ok(congregacao);
    }

    //Delete
    @PutMapping("/delete")
    public ResponseEntity<CongregacaoResponseDTO> delete(
            @RequestBody CongregacaoEditDTO dto) {
        CongregacaoResponseDTO congregacao = _service.delete(dto);
        return ResponseEntity.ok(congregacao);
    }

}
