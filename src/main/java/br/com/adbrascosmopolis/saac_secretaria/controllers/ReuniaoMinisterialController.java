package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial.ReuniaoMinisterialResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.situacao.SituacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.services.ReuniaoMinisterialService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reuniao-ministerial")
@CrossOrigin(origins = "*")
public class ReuniaoMinisterialController {

    private final ReuniaoMinisterialService reuniaoMinisterialService;
    public ReuniaoMinisterialController(
            ReuniaoMinisterialService reuniaoMinisterialService) {
        this.reuniaoMinisterialService = reuniaoMinisterialService;
    }

    /**
     * Lista reuniões para uso em dropdown.
     * Cada item inclui reuniaoMinisterialId, tipoReuniao,
     * congregacao, dataReuniao e label.
     */
    @GetMapping("/dropdown")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_LOCAL')")
    public ResponseEntity<List<ReuniaoMinisterialDropdownDTO>> dropdown() {
        return ResponseEntity.ok(reuniaoMinisterialService.dropdown());
    }

    @GetMapping("/dropdown/situacao")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_LOCAL')")
    public ResponseEntity<List<SituacaoDropdownDTO>> dropdownSituacao() {
        String contexto = "REUNIAO_MINISTERIAL";
        return ResponseEntity.ok(reuniaoMinisterialService.dropdownSituacao(contexto));
    }

    /**
     * Lista todas as reuniões ministeriais.
     */
    @GetMapping
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_LOCAL')")
    public ResponseEntity<List<ReuniaoMinisterialResponseDTO>> listarTodas() {
        return ResponseEntity.ok(reuniaoMinisterialService.listAllNotDeleted());
    }

    /**
     * Busca uma reunião pelo ID.
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_LOCAL')")
    public ResponseEntity<ReuniaoMinisterial> buscarPorId(
            @PathVariable Long id) {
        ReuniaoMinisterial reuniao = reuniaoMinisterialService.listById(id);

        if (reuniao == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reuniao);
    }

    /**
     * Busca reuniões pela data.
     * Formato esperado: yyyy-MM-dd.
     */
    @GetMapping("/data/{dataReuniao}")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_READ_LOCAL')")
    public ResponseEntity<ReuniaoMinisterial> buscarPorData(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataReuniao) {
        ReuniaoMinisterial reuniao =
                reuniaoMinisterialService.listByDate(dataReuniao);

        if (reuniao == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reuniao);
    }

    /**
     * Cria uma reunião ministerial.
     */
    @PostMapping
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_CREATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_CREATE_LOCAL')")
    public ResponseEntity<ReuniaoMinisterialResponseDTO> create(
            @Valid @RequestBody ReuniaoMinisterialRequestDTO request) {
        ReuniaoMinisterialResponseDTO criada =
                reuniaoMinisterialService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(criada);
    }

    /**
     * Atualiza uma reunião.
     * O reuniaoMinisterialId deve estar no corpo do DTO.
     */
    @PutMapping
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_UPDATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_UPDATE_LOCAL')")
    public ResponseEntity<ReuniaoMinisterialResponseDTO> update(
            @Valid @RequestBody ReuniaoMinisterialEditDTO request) {
        return ResponseEntity.ok(reuniaoMinisterialService.update(request));
    }

    /**
     * Realiza a exclusão lógica da reunião.
     * Envie reuniaoMinisterialId e deletedAt no corpo do DTO.
     */
    @PutMapping("/delete")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_UPDATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_REUNIAO_MINISTERIAL_UPDATE_LOCAL')")
    public ResponseEntity<ReuniaoMinisterialResponseDTO> delete(
            @Valid @RequestBody ReuniaoMinisterialEditDTO request) {
        return ResponseEntity.ok(reuniaoMinisterialService.delete(request));
    }
}
