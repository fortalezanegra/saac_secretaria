package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.evento.EventoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Evento;
import br.com.adbrascosmopolis.saac_secretaria.models.Historico;
import br.com.adbrascosmopolis.saac_secretaria.repository.HistoricoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;
    private final PessoaRepository pessoaRepository;

    public HistoricoService(
            HistoricoRepository historicoRepository,
            PessoaRepository pessoaRepository){
        this.historicoRepository = historicoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    // Create
    @Transactional
    public void create(Long pessoaId){
        Historico historico = new Historico();

        // Buscar entidades relacionadas pelo ID
        if(pessoaId != null){
            historico.setPessoa(
                    pessoaRepository.findById(pessoaId)
                            .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"))
            );
        }
    }

}
