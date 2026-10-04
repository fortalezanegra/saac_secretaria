package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao.TipoReuniaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao.TipoReuniaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao.TipoReuniaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_reuniao.TipoReuniaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoReuniao;
import br.com.adbrascosmopolis.saac_secretaria.services.TipoReuniaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipo-reuniao")
@CrossOrigin(origins = "*")
public class TipoReuniaoController {

    private final TipoReuniaoService _service;

    public TipoReuniaoController(TipoReuniaoService service){
        this._service = service;
    }

    //Dropdown/Combobox
    @GetMapping("/dropdown")
    public ResponseEntity<List<TipoReuniaoDropdownDTO>> getDropdown(){
        List<TipoReuniaoDropdownDTO> tipo = _service.dropdown();
        return ResponseEntity.ok(tipo);
    }

    // Buscar todos os Tipos Reuniao
    @GetMapping("/all")
    public ResponseEntity<List<TipoReuniaoResponseDTO>> getAll() {
        List<TipoReuniaoResponseDTO> tipos = _service.getAll();
        return ResponseEntity.ok(tipos);
    }

    // Buscar Tipo Reuniao por Id
    @GetMapping("/id")
    public ResponseEntity<TipoReuniaoResponseDTO> getById(@RequestBody TipoReuniaoEditDTO dto) {
        TipoReuniao tipo = _service.getById(dto);
        if (dto.getTipoReuniaoId() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(TipoReuniaoResponseDTO.fromTipoReuniao(tipo));
    }

    // Search By Descrição - Pesquisa Avançada
    @GetMapping("/search")
    public ResponseEntity<List<TipoReuniaoResponseDTO>> search(
            @RequestBody TipoReuniaoRequestDTO request) {
        List<TipoReuniaoResponseDTO> tipo = _service.search(request)
                .stream()
                .map(TipoReuniaoResponseDTO::fromTipoReuniao)
                .collect(Collectors.toList());

        return ResponseEntity.ok(tipo);
    }

    // Busca para Edição
    @GetMapping("/edit")
    public ResponseEntity<TipoReuniaoEditDTO> getToEdit(@RequestBody TipoReuniaoEditDTO dto) {
        TipoReuniao tipo= _service.getById(dto);

        if (dto.getTipoReuniaoId() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(TipoReuniaoEditDTO.fromTipoReuniao(tipo));
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody TipoReuniaoRequestDTO dto) {
        try {
            TipoReuniaoResponseDTO tipo = _service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(tipo.getTipoReuniaoId())
                    .toUri();

            return ResponseEntity.created(location).body(tipo);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Update
    @PutMapping("/update")
    public ResponseEntity<TipoReuniaoResponseDTO> update(
            @RequestBody TipoReuniaoEditDTO dto) {
        TipoReuniaoResponseDTO tipo = _service.update(dto);
        return ResponseEntity.ok(tipo);
    }

    //Delete
    @PutMapping("/delete")
    public ResponseEntity<TipoReuniaoResponseDTO> delete(
            @RequestBody TipoReuniaoEditDTO dto){
        TipoReuniaoResponseDTO tipo = _service.update(dto);
        return ResponseEntity.ok(tipo);
    }
}
