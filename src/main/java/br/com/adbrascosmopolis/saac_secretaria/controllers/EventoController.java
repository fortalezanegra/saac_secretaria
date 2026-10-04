package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Evento;
import br.com.adbrascosmopolis.saac_secretaria.services.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/evento")
@CrossOrigin(origins = "*")
public class EventoController {

    private final EventoService _service;

    public EventoController(EventoService service){
        this._service = service;
    }

    // Buscar todos os Eventos
    @GetMapping("/all")
    public ResponseEntity<List<EventoResponseDTO>> getAll() {
        List<EventoResponseDTO> eventos = _service.listAll();
        return ResponseEntity.ok(eventos);
    }

    // Buscar Evento por Id
    @GetMapping("/{id}")
    public ResponseEntity<EventoEditDTO> getById(@PathVariable Integer id) {
        Evento e = _service.listById(id);
        if (e == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(EventoEditDTO.fromEvento(e));
    }

    // Listar Eventos por Congregacao
    @GetMapping("/congregacao/{id}")
    public ResponseEntity<List<EventoResponseDTO>> listarPorCongregacao(@PathVariable Integer id) {
        List<EventoResponseDTO> eventos = _service.listByCongregacao(id);
        return ResponseEntity.ok(eventos);
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody EventoRequestDTO dto) {
        try {
            // Passa o DTO direto para o Service
            EventoResponseDTO responseDTO = _service.create(dto);

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
    @PutMapping("/update")
    public ResponseEntity<EventoResponseDTO> update(
            @RequestBody EventoEditDTO dto) {

        EventoResponseDTO eventos = _service.update(dto);
        return ResponseEntity.ok(eventos);
    }

    @PutMapping("/delete")
    public ResponseEntity<EventoResponseDTO> delete(
            @RequestBody EventoEditDTO dto) {

        dto.setDeletedAt(LocalDateTime.now());
        EventoResponseDTO evento = _service.delete(dto);
        return ResponseEntity.ok(evento);
    }

}
