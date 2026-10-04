package br.com.adbrascosmopolis.saac_secretaria.controllers;


import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;
import br.com.adbrascosmopolis.saac_secretaria.services.OcorrenciaService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ocorrencia")
@CrossOrigin(origins = "*")
public class OcorrenciaController {

    private final OcorrenciaService _service;

    public OcorrenciaController(OcorrenciaService service){
        this._service = service;
    }

    // Buscar todas as Ocorrencias
    @GetMapping("/all")
    public ResponseEntity<List<OcorrenciaResponseDTO>> getAll() {
        List<OcorrenciaResponseDTO> ocorrencias = _service.listAll();
        return ResponseEntity.ok(ocorrencias);
    }

    // Buscar Ocorrencia por Id
    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaResponseDTO> getById(@PathVariable Integer id) {
        Ocorrencia o = _service.listById(id);
        if (o == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(OcorrenciaResponseDTO.fromOcorrencia(o));
    }

    // Listar Ocorrencias por Evento
    @GetMapping("/evento/{id}")
    public ResponseEntity<List<OcorrenciaResponseDTO>> listarPorSetor(@PathVariable Integer id) {
        List<OcorrenciaResponseDTO> ocorrencias = _service.listByEvento(id);
        return ResponseEntity.ok(ocorrencias);
    }

    //Validar Duplicidade
    @GetMapping("/duplicidade")
    public ResponseEntity<OcorrenciaResponseDTO> getDuplicidade(
            @RequestParam Integer eventoId,
            @RequestParam Integer tipoOcorrenciaId) {

        OcorrenciaResponseDTO duplicidade =
                _service.listByIdAndEventoId(eventoId, tipoOcorrenciaId);

        return ResponseEntity.ok(duplicidade);
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody OcorrenciaRequestDTO dto) {
        try {
            // Passa o DTO direto para o Service
            OcorrenciaResponseDTO responseDTO = _service.create(dto);

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
    @PutMapping("/update")
    public ResponseEntity<OcorrenciaResponseDTO> update(
            @RequestBody OcorrenciaEditDTO dto) {

        OcorrenciaResponseDTO ocorrencia = _service.update(dto);
        return ResponseEntity.ok(ocorrencia);
    }

    @PutMapping("/delete")
    public ResponseEntity<OcorrenciaResponseDTO> delete(
            @RequestBody OcorrenciaEditDTO dto) {
        OcorrenciaResponseDTO ocorrencia = _service.delete(dto);
        return ResponseEntity.ok(ocorrencia);
    }

}
