package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaFilterDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.OcorrenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ocorrencia")
@CrossOrigin(origins = "*")
public class OcorrenciaController {

    private final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service){
        this.service = service;
    }

    // Find All
    @GetMapping()
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_READ_LOCAL')")
    public ResponseEntity<List<OcorrenciaResponseDTO>> getAll() {
        List<OcorrenciaResponseDTO> ocorrencias = service.listAll();
        return ResponseEntity.ok(ocorrencias);
    }

    // Find By Id
    @PostMapping("/id")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_READ_LOCAL')")
    public ResponseEntity<OcorrenciaResponseDTO> getById(@RequestBody OcorrenciaFilterDTO dto) {
        OcorrenciaResponseDTO ocorrencia = service.listById(dto.getOcorrenciaId()) ;
        if (ocorrencia == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ocorrencia);
    }

    // Find By Evento
    @PostMapping("/evento")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_READ_LOCAL')")
    public ResponseEntity<List<OcorrenciaResponseDTO>> getByEvento(@RequestBody OcorrenciaFilterDTO dto) {
        List<OcorrenciaResponseDTO> ocorrencias = service.listByEvento(dto.getEventoId());
        return ResponseEntity.ok(ocorrencias);
    }

    //Validar Duplicidade
//    @GetMapping("/duplicidade")
//    public ResponseEntity<OcorrenciaResponseDTO> getDuplicidade(
//            @RequestBody OcorrenciaEditDTO dto) {
//
//        OcorrenciaResponseDTO duplicidade =
//                service.listByIdAndEventoId(dto);
//
//        return ResponseEntity.ok(duplicidade);
//    }

    // Create
    @PostMapping()
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_CREATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_CREATE_LOCAL')")
    public ResponseEntity<Object> create(@RequestBody OcorrenciaRequestDTO dto) {
        try {
            // Passa o DTO direto para o Service
            OcorrenciaResponseDTO responseDTO = service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO.getOcorrenciaId())
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Update
    @PutMapping()
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_UPDATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_UPDATE_LOCAL')")
    public ResponseEntity<OcorrenciaResponseDTO> update(
            @RequestBody OcorrenciaEditDTO dto) {

        OcorrenciaResponseDTO ocorrencia = service.update(dto);
        return ResponseEntity.ok(ocorrencia);
    }

    @PutMapping("/delete")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_DELETE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_OCORRENCIA_DELETE_LOCAL')")
    public ResponseEntity<OcorrenciaResponseDTO> delete(
            @RequestBody OcorrenciaEditDTO dto) {
        OcorrenciaResponseDTO ocorrencia = service.delete(dto);
        return ResponseEntity.ok(ocorrencia);
    }

}
