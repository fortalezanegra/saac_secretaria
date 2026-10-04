package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao.AtaReuniaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao.AtaReuniaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao.AtaReuniaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao.AtaReuniaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.AtaReuniao;
import br.com.adbrascosmopolis.saac_secretaria.services.AtaReuniaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/atas")
@CrossOrigin(origins = "*")
public class AtaReuniaoController {

    private final AtaReuniaoService _service;

    public AtaReuniaoController(AtaReuniaoService service){
        this._service = service;
    }

    //Dropdown/Combobox
    @GetMapping("/dropdown")
    public ResponseEntity<List<AtaReuniaoDropdownDTO>> getDropdown(){
        List<AtaReuniaoDropdownDTO> atas = _service.dropdown();
        return ResponseEntity.ok(atas);
    }

    // Buscar todas as atas
    @GetMapping("/all")
    public ResponseEntity<List<AtaReuniaoResponseDTO>> getAll() {
        List<AtaReuniaoResponseDTO> atas = _service.listAll();
        return ResponseEntity.ok(atas);
    }

    // Buscar Ata por Id
    @GetMapping("/id")
    public ResponseEntity<AtaReuniaoResponseDTO> getById(
            @RequestBody AtaReuniaoEditDTO dto) {
        AtaReuniao a = _service.listById(dto.getAtaReuniaoId());
        if (a == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(AtaReuniaoResponseDTO.fromAtaReuniao(a));
    }

    // Listar Ata por Reunião
    @GetMapping("/reuniao/id")
    public ResponseEntity<AtaReuniaoResponseDTO> getByReuniaoId(
            @RequestBody AtaReuniaoEditDTO dto) {
        AtaReuniao ata = _service.listByReuniaoId(dto);
        return ResponseEntity.ok(AtaReuniaoResponseDTO.fromAtaReuniao(ata));
    }

    // Search By Name - Search Advanced
    @GetMapping("/search")
    public ResponseEntity<List<AtaReuniaoResponseDTO>> search(
            @RequestBody LocalDate dataReuniao) {
        List<AtaReuniaoResponseDTO> ata = _service.search(dataReuniao)
                .stream()
                .map(AtaReuniaoResponseDTO::fromAtaReuniao)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ata);
    }

    // Endpoint para buscar o Ata Reuniao por ID para edição
    @GetMapping("/edit/id")
    public ResponseEntity<AtaReuniaoEditDTO> getAtaReuniaoForEdit(
            @RequestBody AtaReuniaoEditDTO dto) {
        AtaReuniao ata = _service.listById(dto.getAtaReuniaoId());
        if (ata == null) {
            return ResponseEntity.notFound().build();
        }

        AtaReuniaoEditDTO a = AtaReuniaoEditDTO.fromAtaReuniao(ata);

        return ResponseEntity.ok(a);
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Object> create(
            @RequestBody AtaReuniaoRequestDTO dto) {
        try {
            AtaReuniaoResponseDTO responseDTO = _service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO.getAtaReuniaoId())
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Update
    @PutMapping("/update")
    public ResponseEntity<AtaReuniaoResponseDTO> update(
            @RequestBody AtaReuniaoEditDTO dto) {

        AtaReuniao ataReuniao = _service.update(dto);
        return ResponseEntity.ok(AtaReuniaoResponseDTO.fromAtaReuniao(ataReuniao));
    }

    //Delete
    @PutMapping("/delete")
    public ResponseEntity<AtaReuniaoResponseDTO> delete(
            @RequestBody AtaReuniaoEditDTO dto) {

        AtaReuniao ataReuniao = _service.delete(dto);
        return ResponseEntity.ok(AtaReuniaoResponseDTO.fromAtaReuniao(ataReuniao));
    }

    //Uploads Atas
    @PostMapping("/{id}/upload")
    public ResponseEntity<Object> uploadPdf(
            @PathVariable Integer id,
            @RequestParam("file") MultipartFile file) {

        try {
            String url = _service.uploadPdf(id, file);
            return ResponseEntity.ok(url);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
