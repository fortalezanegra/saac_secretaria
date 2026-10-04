package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.batismo.BatismoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.batismo.BatismoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.batismo.BatismoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.batismo.BatismoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Batismo;
import br.com.adbrascosmopolis.saac_secretaria.services.BatismoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/batismo")
@CrossOrigin(origins = "*")
public class BatismoController {

    private final BatismoService _service;

    public BatismoController(BatismoService service){
        this._service = service;
    }

    //Dropdown/ComboBox
    @GetMapping("/dropdown")
    public ResponseEntity<List<BatismoDropdownDTO>> getDropdown(){
        List<BatismoDropdownDTO> batismos = _service.dropdown();
        return ResponseEntity.ok(batismos);
    }

    //Busca todos os Batismos
    @GetMapping("/all")
    public ResponseEntity<List<BatismoResponseDTO>> getAll(){
        List<BatismoResponseDTO> batismos = _service.listAll();
        return ResponseEntity.ok(batismos);
    }

    //Busca Batismo por Id
    @GetMapping("/{id}")
    public ResponseEntity<BatismoResponseDTO> getById(@PathVariable Integer id){
        Batismo b = _service.listById(id);
        if(b == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(BatismoResponseDTO.fromBatismo(b));
    }

    //Listar por Congregacao
    @GetMapping("/congregacao/{id}")
    public ResponseEntity<List<BatismoResponseDTO>> getToCongregacaoId(@PathVariable Long id){
        List<BatismoResponseDTO> batismos = _service.listByCongregacaoId(id);
        return ResponseEntity.ok(batismos);

    }

    //Search by Data - Search Advanced
    @GetMapping("/search")
    public ResponseEntity<List<BatismoResponseDTO>> search(
            @RequestParam(value = "dataBatismo", required = false) LocalDate dataBatismo){
        List<BatismoResponseDTO> batismo = _service.searchByExample(dataBatismo)
                .stream()
                .map(BatismoResponseDTO::fromBatismo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(batismo);
    }

    //Endpoint para buscar batismo por Id para edição
    @GetMapping("/edit/{idd}")
    public ResponseEntity<BatismoEditDTO> getBatismoForEdit(@PathVariable Integer id){
        Batismo b = _service.listById(id);
        if(b == null){
            return ResponseEntity.notFound().build();
        }

        BatismoEditDTO dto = BatismoEditDTO.fromBatismo(b);

        return ResponseEntity.ok(dto);
    }

    //Create
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody BatismoRequestDTO dto){
        try {
            // Passa o DTO direto para o Service
            BatismoResponseDTO responseDTO = _service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO.getBatismoId())
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<BatismoResponseDTO> update(
            @RequestBody BatismoEditDTO dto
            ){
        Batismo batismo = _service.update(dto);

        return ResponseEntity.ok(BatismoResponseDTO.fromBatismo(batismo));
    }

    //Delete
    @PutMapping("/delete")
    public ResponseEntity<BatismoResponseDTO> delete(
            @RequestBody BatismoEditDTO dto) {

        Batismo batismo = _service.delete(dto);
        return ResponseEntity.ok(BatismoResponseDTO.fromBatismo(batismo));
    }
}
