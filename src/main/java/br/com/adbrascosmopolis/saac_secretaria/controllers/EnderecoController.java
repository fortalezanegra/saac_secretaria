package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.endereco.EnderecoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.endereco.EnderecoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.endereco.EnderecoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Endereco;
import br.com.adbrascosmopolis.saac_secretaria.services.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/endereco")
@CrossOrigin(origins = "*")
public class EnderecoController {

    private final EnderecoService _service;

    public EnderecoController(EnderecoService service){
        this._service = service;
    }

    // Buscar todos os endereços
    @GetMapping("/all")
    public ResponseEntity<List<EnderecoResponseDTO>> getAll() {
        List<EnderecoResponseDTO> enderecos = _service.getAll();
        return ResponseEntity.ok(enderecos);
    }

    // Buscar endereço por membroId
    @GetMapping("/membro/{id}")
    public ResponseEntity<EnderecoResponseDTO> getByMembro(@PathVariable Integer id) {
        EnderecoResponseDTO endereco = _service.getByMembro(id);
        return ResponseEntity.ok(endereco);
    }

    // Search By descricao - Pesquisa Avançada
    @GetMapping("/search")
    public ResponseEntity<List<EnderecoResponseDTO>> search(@RequestParam(value = "descricao", required = false) String descricao) {
        List<EnderecoResponseDTO> endereco = _service.searchByExample(descricao)
                .stream()
                .map(EnderecoResponseDTO::fromEndereco)
                .collect(Collectors.toList());
        return ResponseEntity.ok(endereco);
    }

    // Endpoint para buscar o endereco por membroId para edição
    @GetMapping("/membro/edit/{membroId}")
    public ResponseEntity<EnderecoEditDTO> getEnderecoToEdit(@PathVariable Integer membroId) {
        EnderecoEditDTO endereco = _service.getEdit(membroId);
        if (endereco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco);
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody EnderecoRequestDTO dto) {
        try {
            // Passa o DTO direto para o Service
            EnderecoResponseDTO responseDTO = _service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO.getEnderecoId())
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Update
    @PutMapping("/update")
    public ResponseEntity<EnderecoResponseDTO> update(
            @RequestBody EnderecoEditDTO dto) {

        Endereco endereco = _service.update(dto);
        return ResponseEntity.ok(EnderecoResponseDTO.fromEndereco(endereco));
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Endereco endereco = _service.getById(id);
            if (endereco == null) return ResponseEntity.notFound().build();

            _service.delete(endereco);
            return ResponseEntity.noContent().build();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
