package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem.IgrejaOrigemDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem.IgrejaOrigemEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem.IgrejaOrigemRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.igreja_origem.IgrejaOrigemResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.IgrejaOrigem;
import br.com.adbrascosmopolis.saac_secretaria.services.IgrejaOrigemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/igreja-origem")
@CrossOrigin(origins = "*")
public class IgrejaOrigemController {

    private final IgrejaOrigemService _service;

    public IgrejaOrigemController(IgrejaOrigemService service){
        this._service = service;
    }

    // Dropdown/ComboBox
    @GetMapping("/dropdown")
    public ResponseEntity<List<IgrejaOrigemDropdownDTO>> getDropdown(){
        List<IgrejaOrigemDropdownDTO> igrejas = _service.dropdown();
        return ResponseEntity.ok(igrejas);
    }

    // Buscar todas as Igrejas Origem
    @GetMapping("/all")
    public ResponseEntity<List<IgrejaOrigemResponseDTO>> getAll() {
        List<IgrejaOrigemResponseDTO> igrejas = _service.listAll();
        return ResponseEntity.ok(igrejas);
    }

    // Buscar IgrejaOrigemId
    @GetMapping("/{id}")
    public ResponseEntity<IgrejaOrigemResponseDTO> getById(@PathVariable Integer id) {
        IgrejaOrigem i = _service.listById(id);
        if (i == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(IgrejaOrigemResponseDTO.fromIgrejaOrigem(i));
    }

    // Search By Descricao - Search Advanced
    @GetMapping("/search")
    public ResponseEntity<List<IgrejaOrigemResponseDTO>> search(
            @RequestParam(value = "descricao", required = false) String descricao) {
        List<IgrejaOrigemResponseDTO> igreja = _service.search(descricao)
                .stream()
                .map(IgrejaOrigemResponseDTO::fromIgrejaOrigem)
                .collect(Collectors.toList());
        return ResponseEntity.ok(igreja);
    }

    // Endpoint para buscar  congregacao por ID para edição
    @GetMapping("/edit/{id}")
    public ResponseEntity<IgrejaOrigemEditDTO> getCongregacaoForEdit(@PathVariable Integer id) {
        IgrejaOrigem i = _service.listById(id);
        if (i == null) {
            return ResponseEntity.notFound().build();
        }

        IgrejaOrigemEditDTO dto = IgrejaOrigemEditDTO.fromIgrejaOrigem(i);

        return ResponseEntity.ok(dto);
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Object> create(
            @RequestBody IgrejaOrigemRequestDTO dto) {
        try {
            IgrejaOrigemResponseDTO responseDTO = _service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO.getIgrejaOrigemId())
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Update
    @PutMapping("/update")
    public ResponseEntity<IgrejaOrigemResponseDTO> update(
            @RequestBody IgrejaOrigemEditDTO dto) {
        IgrejaOrigemResponseDTO  igreja = _service.update(dto);
        return ResponseEntity.ok(igreja);
    }

    @PutMapping("/delete")
    public ResponseEntity<IgrejaOrigemResponseDTO> delete(
            @RequestBody IgrejaOrigemEditDTO dto) {
        IgrejaOrigemResponseDTO igreja = _service.delete(dto);
        return ResponseEntity.ok(igreja);
    }

}
