package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.SolicitacaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.ReuniaoMinisterialRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SolicitacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PautaReuniaoMinisterialService {

    private final ReuniaoMinisterialRepository reuniaoRepository;
    private final SolicitacaoRepository solicitacaoRepository;

    public PautaReuniaoMinisterialService(
            ReuniaoMinisterialRepository reuniaoRepository,
            SolicitacaoRepository solicitacaoRepository
    ) {
        this.reuniaoRepository = reuniaoRepository;
        this.solicitacaoRepository = solicitacaoRepository;
    }

    @Transactional
    public List<SolicitacaoResponseDTO> gerarPauta(Long reuniaoId) {

        ReuniaoMinisterial reuniao = reuniaoRepository.buscarReuniaoPendente(reuniaoId, SituacaoReuniaoMinisterial.PENDENTE)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Reunião não encontrada, excluída ou não está Pendente: " + reuniaoId
                ));

        List<Solicitacao> elegiveis = solicitacaoRepository.searchRequestsForBuildingAgenda();

        // A situação da solicitação não muda aqui; apenas o vínculo com a reunião.
        for (Solicitacao solicitacao : elegiveis) {
            solicitacao.setReuniaoMinisterial(reuniao);
        }

        reuniao.setSituacao(SituacaoReuniaoMinisterial.PAUTADA);
        solicitacaoRepository.saveAll(elegiveis);

        return listarSolicitacoesDaPauta(reuniao.getReuniaoMinisterialId());
    }

    @Transactional(readOnly = true)
    public List<SolicitacaoResponseDTO> listarSolicitacoesDaPauta(Long reuniaoMinisterialId) {
        return solicitacaoRepository.listRequestFromAgendaByReuniaoMinisterialId(reuniaoMinisterialId, SituacaoReuniaoMinisterial.PAUTADA)
                .stream()
                .map(SolicitacaoResponseDTO::fromSolicitacao)
                .toList();
    }

}