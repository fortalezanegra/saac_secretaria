package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia.OcorrenciaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;
import br.com.adbrascosmopolis.saac_secretaria.repository.EventoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.OcorrenciaRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.TipoOcorrenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository ocorrenciaRepository;
    private final EventoRepository eventoRepository;
    private final TipoOcorrenciaRepository tipoOcorrenciaRepository;

    public OcorrenciaService(
            OcorrenciaRepository ocorrenciaRepository,
            EventoRepository eventoRepository,
            TipoOcorrenciaRepository tipoOcorrenciaRepository
    ){
        this.ocorrenciaRepository = ocorrenciaRepository;
        this.eventoRepository = eventoRepository;
        this.tipoOcorrenciaRepository = tipoOcorrenciaRepository;
    }

    // Busca todas as Ocorrencia
    public List<OcorrenciaResponseDTO> listAll(){
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.buscarTodasOcorrencias();

        return ocorrencias.stream()
                .map(o -> new OcorrenciaResponseDTO(
                        o.getOcorrenciaId(),
                        o.getEvento() != null ? o.getEvento().getDescricao()  : null,
                        o.getEvento() != null ? o.getEvento().getEventoId() : null,
                        o.getTipoOcorrencia() != null ? o.getTipoOcorrencia().getDescricao() : null,
                        o.getTipoOcorrencia() != null ? o.getTipoOcorrencia().getTipoOcorrenciaId() : null,
                        o.getQuantidade()
                )).toList();
    }

    // Busca Ocorrencia por Id
    public Ocorrencia listById(Integer id){
        Ocorrencia ocorrencia = ocorrenciaRepository.getReferenceById(id);
        return ocorrencia;
    }

    // Busca Ocorrencia por Evento
    public List<OcorrenciaResponseDTO> listByEvento(Integer id) {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.buscarOcorrenciaPorEvento(id);

        return ocorrencias.stream()
                .map(o -> new OcorrenciaResponseDTO(
                        o.getOcorrenciaId(),
                        o.getEvento() != null ? o.getEvento().getDescricao()  : null,
                        o.getEvento() != null ? o.getEvento().getEventoId() : null,
                        o.getTipoOcorrencia() != null ? o.getTipoOcorrencia().getDescricao() : null,
                        o.getTipoOcorrencia() != null ? o.getTipoOcorrencia().getTipoOcorrenciaId() : null,
                        o.getQuantidade()
                )).toList();
    }

    //Buscar Ocorrencia por Id e EventoId
    public OcorrenciaResponseDTO listByIdAndEventoId(Integer eventoId, Integer ocorrenciaId){
        Ocorrencia ocorrencia = ocorrenciaRepository.buscarPorEventoEOcorrencia(eventoId, ocorrenciaId);
        return OcorrenciaResponseDTO.fromOcorrencia(ocorrencia);
    }

    // Create
    @Transactional
    public OcorrenciaResponseDTO create(OcorrenciaRequestDTO dto){
        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setQuantidade(dto.getQuantidade());

        // Buscar entidades relacionadas pelo ID
        if(dto.getEventoId() != null){
            ocorrencia.setEvento(
                    eventoRepository.findById(dto.getEventoId())
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado"))
            );
        }

        if(dto.getTipoOcorrenciaId() != null){
            ocorrencia.setTipoOcorrencia(
                    tipoOcorrenciaRepository.findById(dto.getTipoOcorrenciaId())
                            .orElseThrow(() -> new RuntimeException("Tipo de Ocorrencia não encontrado"))
            );
        }

        Ocorrencia salva = ocorrenciaRepository.save(ocorrencia);
        Ocorrencia completo = ocorrenciaRepository.findByIdFetchAll(salva.getOcorrenciaId())
                .orElseThrow(()-> new RuntimeException("Evento não encontrado"));

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
        if(dto.getEventoId() != null){
            result.setEvento(
                    eventoRepository.getReferenceById(dto.getEventoId())
            );
        }

        if(dto.getTipoOcorrenciaId() != null){
            result.setTipoOcorrencia(
                    tipoOcorrenciaRepository.getReferenceById(dto.getTipoOcorrenciaId())
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
