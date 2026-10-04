package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Evento;
import br.com.adbrascosmopolis.saac_secretaria.repository.CongregacaoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.EventoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SituacaoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.TipoEventoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final TipoEventoRepository tipoEventoRepository;
    private final SituacaoRepository situacaoRepository;

    public EventoService(
            EventoRepository eventoRepository,
            CongregacaoRepository congregacaoRepository,
            TipoEventoRepository tipoEventoRepository,
            SituacaoRepository situacaoRepository
    ){
        this.eventoRepository = eventoRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.tipoEventoRepository = tipoEventoRepository;
        this.situacaoRepository = situacaoRepository;
    }


    // Busca todos os Eventos
    public List<EventoResponseDTO> listAll(){
        List<Evento> eventos = eventoRepository.buscarTodosEventos();

        return eventos.stream()
                .map(e -> new EventoResponseDTO(
                        e.getEventoId(),
                        e.getCongregacao() != null ? e.getCongregacao().getNome() : null,
                        e.getTipoEvento() != null ? e.getTipoEvento().getDescricao() : null,
                        e.getDescricao(),
                        e.getParticipantes(),
                        e.getVisitantes(),
                        e.getDataEvento(),
                        e.getSituacao() != null ? e.getSituacao().getDescricao() : null

                )).toList();
    }

    // Busca Evento por Id
    public Evento listById(Integer id){
        Evento evento = eventoRepository.getReferenceById(id);
        return evento;
    }

    // Busca Eventos por Congregacao
    public List<EventoResponseDTO> listByCongregacao(Integer id) {
        List<Evento> eventos = eventoRepository.buscarEventoPorCongregacao(id);

        return eventos.stream()
                .map(e -> new EventoResponseDTO(
                        e.getEventoId(),
                        e.getCongregacao() != null ? e.getCongregacao().getNome() : null,
                        e.getTipoEvento() != null ? e.getTipoEvento().getDescricao() : null,
                        e.getDescricao(),
                        e.getParticipantes(),
                        e.getVisitantes(),
                        e.getDataEvento(),
                        e.getSituacao() != null ? e.getSituacao().getDescricao() : null

                )).toList();
    }

    // Create
    @Transactional
    public EventoResponseDTO create(EventoRequestDTO dto){
        Evento evento = new Evento();

        evento.setDescricao(dto.getDescricao());
        evento.setParticipantes(dto.getParticipantes());
        evento.setVisitantes(dto.getVisitantes());
        evento.setDataEvento(dto.getDataEvento());

        // Buscar entidades relacionadas pelo ID
        if(dto.getCongregacaoId() != null){
            evento.setCongregacao(
                    congregacaoRepository.findById(dto.getCongregacaoId())
                            .orElseThrow(() -> new RuntimeException("Congregacao não encontrada"))
            );
        }

        if(dto.getTipoEventoId() != null){
            evento.setTipoEvento(
                    tipoEventoRepository.findById(dto.getTipoEventoId())
                            .orElseThrow(() -> new RuntimeException("Tipo de Evento não encontrado"))
            );
        }

        if(dto.getSituacaoId() != null){
            evento.setSituacao(
                    situacaoRepository.findById(dto.getSituacaoId())
                            .orElseThrow(() -> new RuntimeException("Situação não encontrada"))
            );
        }


        Evento salvo = eventoRepository.save(evento);
        Evento completo = eventoRepository.findByIdFetchAll(salvo.getEventoId())
                .orElseThrow(()-> new RuntimeException("Evento não encontrado"));

        return EventoResponseDTO.fromEvento(completo);
    }

    // Update
    public EventoResponseDTO update(EventoEditDTO dto){
        Evento evento = eventoRepository.findById(dto.getEventoId())
                .orElseThrow(()-> new RuntimeException("Evento não encontrado"));

        evento.setDescricao(dto.getDescricao());
        evento.setParticipantes(dto.getParticipantes());
        evento.setVisitantes(dto.getVisitantes());
        evento.setDataEvento(dto.getDataEvento());

        // Buscar entidades relacionadas pelo ID
        if(dto.getCongregacaoId() != null){
            evento.setCongregacao(
                    congregacaoRepository.findById(dto.getCongregacaoId())
                            .orElseThrow(() -> new RuntimeException("Congregacao não encontrada"))
            );
        }

        if(dto.getTipoEventoId() != null){
            evento.setTipoEvento(
                    tipoEventoRepository.findById(dto.getTipoEventoId())
                            .orElseThrow(() -> new RuntimeException("Tipo de Evento não encontrado"))
            );
        }

        if(dto.getSituacaoId() != null){
            evento.setSituacao(
                    situacaoRepository.findById(dto.getSituacaoId())
                            .orElseThrow(() -> new RuntimeException("Situação não encontrada"))
            );
        }

        var result = eventoRepository.save(evento);

        return EventoResponseDTO.fromEvento(result);
    }

    // Delete
    public EventoResponseDTO delete(EventoEditDTO dto){
        Evento evento = eventoRepository.findById(dto.getEventoId())
                .orElseThrow(()-> new RuntimeException("Evento não encontrado"));

        evento.setDeletedAt(dto.getDeletedAt());

        var result = eventoRepository.save(evento);

        return EventoResponseDTO.fromEvento(result);
    }

}
