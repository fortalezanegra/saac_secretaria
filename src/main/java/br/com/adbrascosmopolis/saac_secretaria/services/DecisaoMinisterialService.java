package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.deciso_ministerial.DecisaoMinisterialEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.deciso_ministerial.DecisaoMinisterialResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.situacao.SituacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.DecisaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.Situacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.DecisaoMinisterialRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.ReuniaoMinisterialRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SituacaoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SolicitacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DecisaoMinisterialService {

    private final DecisaoMinisterialRepository decisaoMinisterialRepository;
    private final ReuniaoMinisterialRepository reuniaoMinisterialRepository;
    private final SolicitacaoRepository solicitacaoRepository;
    private final SituacaoRepository situacaoRepository;

    public DecisaoMinisterialService(

            DecisaoMinisterialRepository decisaoMinisterialRepository,
            ReuniaoMinisterialRepository reuniaoMinisterialRepository,
            SolicitacaoRepository solicitacaoRepository,
            SituacaoRepository situacaoRepository){
        this.decisaoMinisterialRepository = decisaoMinisterialRepository;
        this.reuniaoMinisterialRepository = reuniaoMinisterialRepository;
        this.solicitacaoRepository = solicitacaoRepository;
        this.situacaoRepository = situacaoRepository;
    }

    // Dropdown
    public List<SituacaoDropdownDTO> dropdownSitaucaoDecisaoMinisterial() {
        String contexto = "DECISAO_MINISTERIAL";
        List<Situacao> situacoes = situacaoRepository.listarSituacaoContexto(contexto);

        return situacoes.stream()
                .map(c -> new SituacaoDropdownDTO(
                        c.getSituacaoId(),
                        c.getDescricao()
                ))
                .collect(Collectors.toList());
    }

    // Update Decisao e Solicitação
    public DecisaoMinisterialResponseDTO updateDecisaoAndSolicitacao(DecisaoMinisterialEditDTO dto){

        DecisaoMinisterial decisao = decisaoMinisterialRepository.findById(dto.getDecisaoMinisterialId())
                .orElseThrow(()-> new RuntimeException("Decisão Ministerial não encontrada"));

        Solicitacao solicitacao = solicitacaoRepository.findBySolicitacaoId(dto.getSolicitacaoId());

        //Atualizando Situacao da Solicitação
        if(decisao != null && solicitacao != null){
            String descricao = decisao.getSituacao().getDescricao();
            Situacao situacao = situacaoRepository.findByDescricaoAndContexto( descricao, "SOLICITACAO" );
            solicitacao.setSituacao(situacao);
        }

        decisao.setHistorico(dto.getHistorico());

        // Relacionamentos (CORRETO)
        if(dto.getDecisaoMinisterialId() != null){
            decisao.setReuniaoMinisterial(
                    reuniaoMinisterialRepository.getReferenceById(dto.getReuniaoMinisterialId())
            );
        }

        if(dto.getSolicitacaoId() != null){
            decisao.setSolicitacao(
                    solicitacaoRepository.getReferenceById(dto.getSolicitacaoId())
            );
        }

        if(dto.getSituacaoId() != null){
            decisao.setSituacao(
                    situacaoRepository.getReferenceById(dto.getSituacaoId())
            );
        }

        var result = decisaoMinisterialRepository.save(decisao);

        return DecisaoMinisterialResponseDTO.fromDecisaoMinisterial(result);
    }

}
