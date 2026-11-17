package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.models.DecisaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.Situacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.DecisaoMinisterialRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.ReuniaoMinisterialRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SituacaoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.SolicitacaoRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.projection.DecisaoMinisterialResumo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class PautaReuniaoMinisterialService {

    private static final String CONTEXTO_REUNIAO = "REUNIAO_EVENTO";
    private static final String CONTEXTO_DECISAO = "DECISAO_MINISTERIAL";

    private final ReuniaoMinisterialRepository reuniaoRepository;
    private final SolicitacaoRepository solicitacaoRepository;
    private final DecisaoMinisterialRepository decisaoRepository;
    private final SituacaoRepository situacaoRepository;

    public PautaReuniaoMinisterialService(
            ReuniaoMinisterialRepository reuniaoRepository,
            SolicitacaoRepository solicitacaoRepository,
            DecisaoMinisterialRepository decisaoRepository,
            SituacaoRepository situacaoRepository
    ) {
        this.reuniaoRepository = reuniaoRepository;
        this.solicitacaoRepository = solicitacaoRepository;
        this.decisaoRepository = decisaoRepository;
        this.situacaoRepository = situacaoRepository;
    }

    @Transactional
    public List<DecisaoMinisterialResumo> gerarPauta(Long reuniaoId) {

        ReuniaoMinisterial reuniao = reuniaoRepository.buscarReuniaoPendente(reuniaoId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Reunião não encontrada, excluída ou não está Pendente: " + reuniaoId
                ));

        List<Solicitacao> solicitacoes = solicitacaoRepository.listarAtivasAguardandoOuReagendadas();

        List<DecisaoMinisterial> novasDecisoes = new ArrayList<>(solicitacoes.size());

        for (Solicitacao solicitacao : solicitacoes) {
            String descricaoSituacao = "Reagendada".equalsIgnoreCase(
                    solicitacao.getSituacao().getDescricao()
            ) ? "Reagendada" : "Aguardando Reunião";

            Situacao situacaoInicial = situacaoRepository
                    .buscarAtivaPorDescricaoEContexto("Aguardando Reuniao", "DECISAO_MINISTERIAL")
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Situação não cadastrada: " + descricaoSituacao
                    ));

            DecisaoMinisterial decisao = new DecisaoMinisterial();
            decisao.setReuniaoMinisterial(reuniao);
            decisao.setSolicitacao(solicitacao);
            decisao.setSituacao(situacaoInicial);
            decisao.setHistorico("Incluída na pauta da reunião " + reuniao.getTipoReuniao() + " - " + reuniao.getDataReuniao());

            novasDecisoes.add(decisao);
        }

        decisaoRepository.saveAll(novasDecisoes);

        return decisaoResumo();
    }

    //Lista de Decisoes Ministeriais em aberto
    private List<DecisaoMinisterialResumo> decisaoResumo(){
        List<DecisaoMinisterialResumo> decisao = decisaoRepository.listarResumos();
        return decisao;
    }

    private void validarSituacaoDaReuniao(ReuniaoMinisterial reuniao) {
        Situacao situacao = reuniao.getSituacao();

        if (situacao == null || !"Pendente".equals(situacao.getDescricao())) {
            throw new IllegalStateException(
                    "A pauta só pode ser gerada para uma reunião com situação Pendente."
            );
        }
    }

    private String obterDescricaoSituacaoInicial(Solicitacao solicitacao) {
        String descricao = solicitacao.getSituacao().getDescricao();

        if ("Reagendada".equalsIgnoreCase(descricao)) {
            return "Reagendada";
        }

        return "Aguardando Reunião";
    }


}
