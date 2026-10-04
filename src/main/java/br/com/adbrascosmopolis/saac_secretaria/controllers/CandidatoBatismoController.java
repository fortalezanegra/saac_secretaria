package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo.CandidatoBatismoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo.CandidatoBatismoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo.CandidatoBatismoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo.CandidatoBatismoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.CandidatoBatismo;
import br.com.adbrascosmopolis.saac_secretaria.services.CandidatoBatismoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/candidato-batismo")
@CrossOrigin(origins = "*")
public class CandidatoBatismoController {

    private final CandidatoBatismoService _service;

    public CandidatoBatismoController(CandidatoBatismoService service){
        this._service = service;
    }

    // Dropdown/ComboBox
    @GetMapping("/dropdown")
    public ResponseEntity<List<CandidatoBatismoDropdownDTO>> getDropdown(){
        List<CandidatoBatismoDropdownDTO> candidatos = _service.dropdown();
        return ResponseEntity.ok(candidatos);
    }

    // Buscar todos os Candidatos
    @GetMapping("/all")
    public ResponseEntity<List<CandidatoBatismoResponseDTO>> getAll() {
        List<CandidatoBatismoResponseDTO> candidatos = _service.listAllPendentes();
        return ResponseEntity.ok(candidatos);
    }

    // Buscar Candidato por Id
    @GetMapping("/{id}")
    public ResponseEntity<CandidatoBatismoResponseDTO> getById(@PathVariable Long id) {
        CandidatoBatismo c = _service.listById(id);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(CandidatoBatismoResponseDTO.fromCandidatoBatismo(c));
    }

    // Buscar Candidatos pendentes por congregacao
    @GetMapping("/congregacao/{id}")
    public ResponseEntity<List<CandidatoBatismoResponseDTO>> getPendentesPorCongregacao(@PathVariable Integer id) {
        List<CandidatoBatismoResponseDTO> candidatos = _service.listPendentesPorCongregacaoId(id);
        return ResponseEntity.ok(candidatos);
    }

    // Buscar  candidato para edição
    @GetMapping("/edit/{id}")
    public ResponseEntity<CandidatoBatismoEditDTO> getCongregacaoForEdit(@PathVariable Long id) {
        CandidatoBatismo c = _service.listById(id);
        if (c == null) {
            return ResponseEntity.notFound().build();
        }

        CandidatoBatismoEditDTO dto = CandidatoBatismoEditDTO.fromCandidatoBatismo(c);

        return ResponseEntity.ok(dto);
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CandidatoBatismoRequestDTO dto) {
        try {

            CandidatoBatismoResponseDTO responseDTO = _service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO.getCandidatoBatismoId())
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Update
    @PutMapping("/update")
    public ResponseEntity<CandidatoBatismoResponseDTO> update(
            @RequestBody CandidatoBatismoEditDTO dto) {

        CandidatoBatismo candidato = _service.update(dto);
        return ResponseEntity.ok(CandidatoBatismoResponseDTO.fromCandidatoBatismo(candidato));
    }

    //Delete
    @PutMapping("/delete")
    public ResponseEntity<CandidatoBatismoResponseDTO> delete(
            @RequestBody CandidatoBatismoEditDTO dto) {
        CandidatoBatismo candidato = _service.delete(dto);
        return ResponseEntity.ok(CandidatoBatismoResponseDTO.fromCandidatoBatismo(candidato));
    }

}
