package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoOcorrencia;
import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;
import br.com.adbrascosmopolis.saac_secretaria.repository.CongregacaoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.EventoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.OcorrenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository ocorrenciaRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final EventoRepository eventoRepository;

    public OcorrenciaService(
            OcorrenciaRepository ocorrenciaRepository,
            CongregacaoRepository congregacaoRepository,
            EventoRepository eventoRepository
    ){
        this.ocorrenciaRepository = ocorrenciaRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.eventoRepository = eventoRepository;
    }

    // Busca todas as Ocorrencia
    public List<OcorrenciaResponseDTO> listAll(){
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAllOcorrencias();

        return ocorrencias.stream()
                .map(o -> new OcorrenciaResponseDTO(
                        o.getOcorrenciaId(),
                        o.getCongregacao() != null ? o.getCongregacao().getCongregacaoId() : null,
                        o.getCongregacao() != null ? o.getCongregacao().getNome() : null,
                        o.getEvento() != null ? o.getEvento().getEventoId() : null,
                        o.getEvento() != null ? o.getEvento().getDescricao()  : null,
                        o.getTipoOcorrencia(),
                        o.getQuantidade()
                )).toList();
    }

    // Find Ocorrencia By Id
    public OcorrenciaResponseDTO listById(Long id){
        Ocorrencia ocorrencia = ocorrenciaRepository.findByIdFetchAll(id);
        return OcorrenciaResponseDTO.fromOcorrencia(ocorrencia);
    }

    // Busca Ocorrencia por Evento
    public List<OcorrenciaResponseDTO> listByEvento(Long id) {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findByEvento(id);

        return ocorrencias.stream()
                .map(o -> new OcorrenciaResponseDTO(
                        o.getOcorrenciaId(),
                        o.getCongregacao() != null ? o.getCongregacao().getCongregacaoId() : null,
                        o.getCongregacao() != null ? o.getCongregacao().getNome() : null,
                        o.getEvento() != null ? o.getEvento().getEventoId() : null,
                        o.getEvento() != null ? o.getEvento().getDescricao()  : null,
                        o.getTipoOcorrencia(),
                        o.getQuantidade()
                )).toList();
    }

    //Buscar Ocorrencia por Id e EventoId
    public OcorrenciaResponseDTO listByIdAndEventoId(Long eventoId, TipoOcorrencia tipoOcorrencia){
        Ocorrencia ocorrencia = ocorrenciaRepository.findByEventoAndTipoOcorrencia(eventoId, tipoOcorrencia);
        return OcorrenciaResponseDTO.fromOcorrencia(ocorrencia);
    }

    // Create
    @Transactional
    public OcorrenciaResponseDTO create(OcorrenciaRequestDTO dto){
        Ocorrencia ocorrencia = new Ocorrencia();

        // Buscar entidades relacionadas pelo ID
        if(dto.getCongregacaoId() != null){
            congregacaoRepository.findByIdFetchAll(dto.getCongregacaoId())
                    .orElseThrow( () -> new RuntimeException("Congregação não encontrada"));
        }

        if(dto.getEventoId() != null){
            ocorrencia.setEvento(
                    eventoRepository.findByIdFetchAll(dto.getEventoId())

            );
        }

        ocorrencia.setTipoOcorrencia(dto.getTipoOcorrencia());
        ocorrencia.setQuantidade(dto.getQuantidade());

        Ocorrencia salva = ocorrenciaRepository.save(ocorrencia);
        Ocorrencia completo = ocorrenciaRepository.getReferenceById(salva.getOcorrenciaId());
        if(salva.getOcorrenciaId() == null){
            throw new RuntimeException("Evento não encontrado");
        }

        return OcorrenciaResponseDTO.fromOcorrencia(completo);
    }

    @Transactional
    // Update
    public OcorrenciaResponseDTO update(OcorrenciaEditDTO dto){

        if(dto.getOcorrenciaId() == null){
            throw new RuntimeException("ocorrenciaId não pode ser null");
        }

        Ocorrencia result = ocorrenciaRepository.findById(dto.getOcorrenciaId())
                .orElseThrow(()-> new RuntimeException("Ocorrencia não encontrada"));

        result.setQuantidade(dto.getQuantidade());

        // Relacionamentos (CORRETO)
        if(dto.getCongregacaoId() != null){
            result.setCongregacao(
                    congregacaoRepository.getReferenceById(dto.getCongregacaoId())
            );
        }

        if(dto.getEventoId() != null){
            result.setEvento(
                    eventoRepository.findByIdFetchAll(dto.getEventoId())
            );
        }

        var ocorrenciaAtualizada = ocorrenciaRepository.save(result);

        return OcorrenciaResponseDTO.fromOcorrencia(ocorrenciaAtualizada);
    }

    @Transactional
    // Delete
    public OcorrenciaResponseDTO delete(OcorrenciaEditDTO dto){
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(dto.getOcorrenciaId())
                .orElseThrow(()-> new RuntimeException("Ocorrencia não encontrada"));

        ocorrencia.setDeletedAt(LocalDateTime.now());

        var result = ocorrenciaRepository.save(ocorrencia);

        return OcorrenciaResponseDTO.fromOcorrencia(result);
    }
}
