package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao.AtaReuniaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao.AtaReuniaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao.AtaReuniaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao.AtaReuniaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.AtaReuniao;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.AtaReuniaoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.ReuniaoMinisterialRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SituacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtaReuniaoService {

    private final AtaReuniaoRepository ataReuniaoRepository;
    private final ReuniaoMinisterialRepository reuniaoMinisterialRepository;
    private final SituacaoRepository situacaoRepository;

    public AtaReuniaoService(
            AtaReuniaoRepository ataReuniaoRepository,
            ReuniaoMinisterialRepository reuniaoMinisterialRepository,
            SituacaoRepository situacaoRepository
    ){
        this.ataReuniaoRepository = ataReuniaoRepository;
        this.reuniaoMinisterialRepository = reuniaoMinisterialRepository;
        this.situacaoRepository = situacaoRepository;
    }

    // Dropdown/ComboBox
    public List<AtaReuniaoDropdownDTO> dropdown() {
        List<AtaReuniao> atas = ataReuniaoRepository.findAll();

        return atas.stream()
                .map(a -> new AtaReuniaoDropdownDTO(
                        a.getAtaReuniaoId(),
                        a.getReuniaoMinisterial() != null
                                ? a.getReuniaoMinisterial().getReuniaoMinisterialId()
                                : null,
                        a.getDescricao(),
                        a.getDataAta()
                ))
                .collect(Collectors.toList());
    }

    // Busca todas as Atas
    public List<AtaReuniaoResponseDTO> listAll(){
        List<AtaReuniao> atas = ataReuniaoRepository.findAll(Sort.by(Sort.Direction.DESC, "dataReuniao"));

        return atas.stream()
                .map(a -> new AtaReuniaoResponseDTO(
                        a.getAtaReuniaoId(),
                        a.getReuniaoMinisterial() != null ? a.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                        a.getDescricao(),
                        a.getDataAta(),
                        a.getUrlAta(),
                        a.getSituacao() != null ? a.getSituacao().getSituacaoId() : null
                )).toList();
    }

    // Busca Ata por Id
    public AtaReuniao listById(Long id){
        AtaReuniao ata = ataReuniaoRepository.findByAtaReuniaoId(id);
        return ata;
    }

    // Busca Ata por reuniaoMinisterialId
    public AtaReuniao listByReuniaoId(AtaReuniaoEditDTO dto){
        AtaReuniao ata = ataReuniaoRepository.findByReuniaoMinisterialReuniaoMinisterialId(dto.getReuniaoMinisterialId());
        return ata;
    }

    // Search By Date - Search Advanced
    public List<AtaReuniao> search(LocalDate dataReuniao){

        var ata = new AtaReuniao();

        ata.setDataAta(dataReuniao);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("araReuniaoId",
                        "ataReuniaoMinisterialId",
                        "descricao",
                        "urlAta",
                        "situacaoId")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<AtaReuniao> ataExample = Example.of(ata, matcher);
        return ataReuniaoRepository.findAll(ataExample);
    }

    // Create
    @Transactional
    public AtaReuniaoResponseDTO create(AtaReuniaoRequestDTO dto){
        AtaReuniao ata = new AtaReuniao();

        ata.setDescricao(dto.getDescricao());
        ata.setDataAta(dto.getDataAta());
        ata.setUrlAta(dto.getUrlAta());

        // Buscar entidades relacionadas pelo ID
        if(dto.getReuniaoMinisterialId() != null){
            ata.setReuniaoMinisterial(
                    reuniaoMinisterialRepository.findById(dto.getReuniaoMinisterialId())
                            .orElseThrow(() -> new RuntimeException("Setor não encontrado"))
            );
        }

        if(dto.getSituacaoId() != null){
            ata.setSituacao(
                    situacaoRepository.findById(dto.getSituacaoId())
                            .orElseThrow(() -> new RuntimeException("Setor não encontrado"))
            );
        }

        AtaReuniao salva = ataReuniaoRepository.save(ata);
        AtaReuniao completa = ataReuniaoRepository.findByIdFetchAll(salva.getAtaReuniaoId())
                .orElseThrow(()-> new RuntimeException("Ata Reunião não encontrada"));

        return AtaReuniaoResponseDTO.fromAtaReuniao(completa);
    }

    // Update
    public AtaReuniao update(AtaReuniaoEditDTO dto){
        AtaReuniao result = ataReuniaoRepository.findById(dto.getAtaReuniaoId())
                .orElseThrow(()-> new RuntimeException("Ata Reunião não encontrada"));

        result.setDescricao(dto.getDescricao());
        result.setDataAta(dto.getDataAta());
        result.setUrlAta(dto.getUrlData());

        // Relacionamentos (CORRETO)
        if(dto.getReuniaoMinisterialId() != null){
            result.setReuniaoMinisterial(
                    reuniaoMinisterialRepository.getReferenceById(dto.getReuniaoMinisterialId())
            );
        }

        if(dto.getSituacaoId() != null){
            result.setSituacao(
                    situacaoRepository.getReferenceById(dto.getSituacaoId())
            );
        }

        return ataReuniaoRepository.save(result);
    }

    // Delete
    public AtaReuniao delete(AtaReuniaoEditDTO dto){
        AtaReuniao result = ataReuniaoRepository.findById(dto.getAtaReuniaoId())
                .orElseThrow(()-> new RuntimeException("Ata Reuniao não encontrada"));

        result.setDeletedAt(dto.getDeletedAt());

        return ataReuniaoRepository.save(result);
    }

    /* Upload Atas */
    @Transactional
    public String uploadPdf(Integer ataId, MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Arquivo vazio.");
        }

        String filename = file.getOriginalFilename();
        if (filename == null || !filename.toLowerCase().endsWith(".pdf")) {
            throw new IllegalArgumentException("Arquivo precisa ser PDF.");
        }

        // Nome do arquivo: Ata_<id>.pdf
        String newFilename = "Ata_" + ataId + ".pdf";

        String uploadDir = "D:/Uploads/Atas";
        Path uploadPath = Paths.get(uploadDir);
        Files.createDirectories(uploadPath);

        Path filePath = uploadPath.resolve(newFilename);
        Files.write(filePath, file.getBytes());

        // URL pública para acesso (ajuste conforme IP/porta do seu servidor)
        String url = "http://10.0.0.76:8081/atas/" + newFilename;

        // Atualiza o banco de dados
        ataReuniaoRepository.atualizarUrlAta(ataId, url);

        return url;
    }


}
