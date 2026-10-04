package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.page.PageResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import br.com.adbrascosmopolis.saac_secretaria.services.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {

    private final PessoaService _service;

    public PessoaController(PessoaService service) {
        this._service = service;
    }

    /* Pesquisar Todas as Pessoas */
    @GetMapping("/all")
    public ResponseEntity<List<PessoaResponseDTO>> getAll(){
        List<PessoaResponseDTO> pessoas = _service.getAll();
        return ResponseEntity.ok(pessoas);
    }

    /* Pesquisar Todas as Pessoas não deletadas */
    @GetMapping()
    public ResponseEntity<List<PessoaResponseDTO>> getAllNotDeleted(){
        List<PessoaResponseDTO> pessoas = _service.getAllNotDeleted();
        return ResponseEntity.ok(pessoas);
    }

    /* Dropdown Pessoas por Congregação e Situacao */
    @GetMapping("/dropdown/congregacao/situacao")
    public ResponseEntity<List<PessoaDropdownDTO>> getPessoaBySituacao(
            @RequestBody PessoaRequestDTO dto){
        List<PessoaDropdownDTO> pessoas = _service.dropdownByCongregacaoAndSituacao(dto);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{vinculo}/{situacao}")
    public ResponseEntity<List<PessoaResponseDTO>> getPessoaByVinculoAndSituacao(
            @PathVariable("vinculo") String vinculo,
            @PathVariable ("situacao") String situacao) {
        List<PessoaResponseDTO> membros = _service.listPessoaByVinculoAndSituacao(vinculo, situacao);
        return ResponseEntity.ok(membros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Pessoa p = _service.listById(id);

        if (p == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Pessoa não encontrada!");
        }

        return ResponseEntity.ok(PessoaResponseDTO.fromPessoa(p));
    }

    /* Buscar Duplicidade de nomes no banco */
    @GetMapping("/nome/{name}")
    public ResponseEntity<List<PessoaResponseDTO>> getByPessoas(@PathVariable String name) {
        var pessoas = _service.listByPessoas(name);
        return ResponseEntity.ok(pessoas);
    }

    // Endpoint para buscar o membro por ID para edição
    @GetMapping("/edit/{id}")
    public ResponseEntity<PessoaEditDTO> getMembroForEdit(@PathVariable Long id) {
        Pessoa p = _service.listById(id);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }

        // Converte o membro para um DTO específico para edição
        PessoaEditDTO dto = PessoaEditDTO.fromPessoa(p);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/congregacao/{id}")
    public ResponseEntity<List<PessoaResponseDTO>> listarPorCongregacao(@PathVariable Integer id) {
        List<PessoaResponseDTO> membros = _service.listByCongregacao(id);
        return ResponseEntity.ok(membros);
    }

    @PostMapping("/search")
    public ResponseEntity<List<PessoaResponseDTO>> search(
            @RequestBody PessoaRequestDTO request) {

        String nome = request.getNome();

        if (nome != null && nome.isBlank()) {
            nome = null;
        }

        var pessoas = _service.searchByPessoa(nome)
                .stream()
                .map(PessoaResponseDTO::fromPessoa)
                .toList();

        return ResponseEntity.ok(pessoas);
    }

    /*Pesquisa avancada paginada*/
    @PostMapping("/search/paged")
    public ResponseEntity<PageResponseDTO<PessoaResponseDTO>> search(
            @RequestBody PessoaRequestDTO request,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nome") String sort
    ) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sort).ascending()
        );

        Page<PessoaResponseDTO> pageResult = _service
                .search(request, pageable)
                .map(PessoaResponseDTO::fromPessoa);

        PageResponseDTO<PessoaResponseDTO> response =
                new PageResponseDTO<>(pageResult);

        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody PessoaRequestDTO dto) {
        try {
            PessoaResponseDTO responseDTO = _service.create(dto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDTO.getPessoaId())
                    .toUri();

            return ResponseEntity.created(location).body(responseDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<PessoaResponseDTO> update(
            @RequestBody PessoaEditDTO dto) {
        PessoaResponseDTO membro = _service.update(dto);
        return ResponseEntity.ok(membro);
    }

    @PutMapping("/delete")
    public ResponseEntity<PessoaResponseDTO> delete(
            @RequestBody PessoaEditDTO dto) {
        PessoaResponseDTO pessoa = _service.delete(dto);
        return ResponseEntity.ok(pessoa);
    }

    /* Upload Foto */
    @PostMapping("/{id}/foto")
    public ResponseEntity<Object> uploadFoto(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {

        try {
            if (file.isEmpty())
                return ResponseEntity.badRequest().body("Arquivo vazio.");

            String filename = file.getOriginalFilename();
            String extension = filename.substring(filename.lastIndexOf("."));
            String newFilename = id + extension;

            String uploadDir = "D:/Uploads/Fotos-Membros";
            Path uploadPath = Paths.get(uploadDir);
            Files.createDirectories(uploadPath);

            Path filePath = uploadPath.resolve(newFilename);
            Files.write(filePath, file.getBytes());

            // 🔥 URL pública
            String urlFoto = "http://10.0.0.76:8081/fotos/" + newFilename;

            _service.atualizarFoto(id, urlFoto);

            return ResponseEntity.ok(urlFoto);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
