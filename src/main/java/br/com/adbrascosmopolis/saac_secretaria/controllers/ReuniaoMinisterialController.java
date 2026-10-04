package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.services.ReuniaoMinisterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reuniao-ministerial")
@CrossOrigin(origins = "*")
public class ReuniaoMinisterialController {

    private final ReuniaoMinisterialService _service;

    public ReuniaoMinisterialController(ReuniaoMinisterialService service){
        this._service = service;
    }

    // Dropdown/ComboBox
    @GetMapping("/dropdown")
    public ResponseEntity<List<ReuniaoMinisterialDropdownDTO>> getDropdown(){
        List<ReuniaoMinisterialDropdownDTO> reuniao = _service.dropdown();
        return ResponseEntity.ok(reuniao);
    }

    // Buscar por todas as Reuniões Ministeriais
    @GetMapping("/all")
    public ResponseEntity<List<ReuniaoMinisterialResponseDTO>> getAll(){
        List<ReuniaoMinisterialResponseDTO> reuniao = _service.listAll();
        return ResponseEntity.ok(reuniao);
    }

    // Buscar Reuniao Ministerial por Id
    @GetMapping("/id")
    public ResponseEntity<ReuniaoMinisterialResponseDTO> getById(
            @RequestBody ReuniaoMinisterialEditDTO dto){
        ReuniaoMinisterial r = _service.listById(dto.getReuniaoMinisterialId());
        if(r == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(ReuniaoMinisterialResponseDTO.fromReuniaoMinisterial(r));
    }

    // Search By dataReuniao - Search Advanced
    @GetMapping("/search/date")
    public ResponseEntity<List<ReuniaoMinisterialResponseDTO>> search(
            @RequestParam(value = "dataReuniao", required = false)LocalDate dataReuniao) {
        List<ReuniaoMinisterialResponseDTO> reuniao = _service.search(dataReuniao)
                .stream()
                .map(ReuniaoMinisterialResponseDTO::fromReuniaoMinisterial)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reuniao);
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Object> create(
            @RequestBody ReuniaoMinisterialRequestDTO dto) {
        try {
            ReuniaoMinisterialResponseDTO responseDTO = _service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO.getReuniaoMinisterialId())
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Update
    @PutMapping("/update")
    public ResponseEntity<ReuniaoMinisterialResponseDTO> update(
            @RequestBody ReuniaoMinisterialEditDTO dto) {

        ReuniaoMinisterial reuniao = _service.update(dto);
        return ResponseEntity.ok(ReuniaoMinisterialResponseDTO.fromReuniaoMinisterial(reuniao));
    }

    //Delete
    @PutMapping("/delete")
    public ResponseEntity<ReuniaoMinisterialResponseDTO> delete(
            @RequestBody ReuniaoMinisterialEditDTO dto) {

        ReuniaoMinisterial reuniao = _service.delete(dto);
        return ResponseEntity.ok(ReuniaoMinisterialResponseDTO.fromReuniaoMinisterial(reuniao));
    }
}
