package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoFilterDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.services.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/evento")
@CrossOrigin(origins = "*")
public class EventoController {

    private final EventoService service;

    public EventoController(EventoService service){
        this.service = service;
    }

    // FindAll
    @GetMapping()
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_EVENTO_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_EVENTO_READ_LOCAL')")
    public ResponseEntity<List<EventoResponseDTO>> getAll() {
        List<EventoResponseDTO> eventos = service.findAll();
        return ResponseEntity.ok(eventos);
    }

    // Find By Id
    @PostMapping("/id")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_EVENTO_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_EVENTO_READ_LOCAL')")
    public ResponseEntity<EventoResponseDTO> getById(@RequestBody EventoFilterDTO dto) {
        EventoResponseDTO evento = service.findById(dto.getEventoId());
        if (evento == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(evento);
    }

    // Find By Congregacao
    @PostMapping("/congregacao")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_EVENTO_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_EVENTO_READ_LOCAL')")
    public ResponseEntity<List<EventoResponseDTO>> getByCongregacao(@RequestBody EventoFilterDTO dto) {
        List<EventoResponseDTO> eventos = service.findByCongregacao(dto.getCongregacaoId());
        return ResponseEntity.ok(eventos);
    }

    // Create
    @PostMapping()
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_EVENTO_CREATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_EVENTO_CREATE_LOCAL')")
    public ResponseEntity<Object> create(@RequestBody EventoRequestDTO dto) {
        try {
            // Passa o DTO direto para o Service
            EventoResponseDTO responseDTO = service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO.getEventoId())
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Update
    @PutMapping()
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_EVENTO_UPDATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_EVENTO_UPDATE_LOCAL')")
    public ResponseEntity<EventoResponseDTO> update(
            @RequestBody EventoEditDTO dto) {

        EventoResponseDTO eventos = service.update(dto);
        return ResponseEntity.ok(eventos);
    }

    //Delete
    @PutMapping("/delete")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_EVENTO_DELETE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_EVENTO_DELETE_LOCAL')")
    public ResponseEntity<EventoResponseDTO> delete(
            @RequestBody EventoEditDTO dto) {

        dto.setDeletedAt(LocalDateTime.now());
        EventoResponseDTO evento = service.delete(dto);
        return ResponseEntity.ok(evento);
    }

}
