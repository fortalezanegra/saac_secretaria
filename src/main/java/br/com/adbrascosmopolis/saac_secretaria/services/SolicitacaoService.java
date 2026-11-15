package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.SolicitacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.SolicitacaoFilterDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.transferencia.SolicitacaoTransferenciaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.transferencia.SolicitacaoTransferenciaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoTransferencia;
import br.com.adbrascosmopolis.saac_secretaria.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitacaoService {

    private final SolicitacaoRepository solicitacaoRepository;
    private final CongregacaoRepository congregacaoRepository;
    private final PessoaRepository pessoaRepository;
    private final CargoMinisterialRepository cargoMinisterialRepository;
    private final IgrejaOrigemRepository igrejaOrigemRepository;
    private final SituacaoRepository situacaoRepository;

    public SolicitacaoService(
            SolicitacaoRepository solicitacaoRepository,
            CongregacaoRepository congregacaoRepository,
            PessoaRepository pessoaRepository,
            CargoMinisterialRepository cargoMinisterialRepository,
            IgrejaOrigemRepository igrejaOrigemRepository,
            SituacaoRepository situacaoRepository
    ){
        this.solicitacaoRepository = solicitacaoRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.pessoaRepository = pessoaRepository;
        this.cargoMinisterialRepository = cargoMinisterialRepository;
        this.igrejaOrigemRepository = igrejaOrigemRepository;
        this.situacaoRepository = situacaoRepository;
    }

    // Dropdown Solicitações Aguardando Reuniao e Reagendadas
    public List<SolicitacaoDropdownDTO> listDropdown() {
        List<Solicitacao> solicitacaoes = solicitacaoRepository.dropdown();

        return solicitacaoes.stream()
                .map(s -> new SolicitacaoDropdownDTO(
                        s.getSolicitacaoId(),
                        s.getCongregacaoSolicitante() != null ? s.getCongregacaoSolicitante().getNome() : null,
                        s.getTipoSolicitacao(),
                        s.getPessoa() != null ? s.getPessoa().getNome() : null,
                        s.getSituacao() != null ? s.getSituacao().getDescricao() : null
                ))
                .collect(Collectors.toList());
    }

    // Update
    public SolicitacaoTransferenciaResponseDTO updateTransferencia(SolicitacaoTransferenciaEditDTO dto){

        SolicitacaoTransferencia solicitacao = solicitacaoRepository.searchById(dto.getSolicitacaoId());

        if(solicitacao == null){
            throw new RuntimeException("Solicitação não encontrada");
        }

        // *** Sets ***
        solicitacao.setHistorico(dto.getHistorico());

        //Relacionamentos

        //Congregacao Solicitante
        if(dto.getCongregacaoSolicitanteId() != null){
            solicitacao.setCongregacaoSolicitante(
                    congregacaoRepository.getReferenceById(dto.getCongregacaoSolicitanteId())
            );
        }

        //Pessoa
        if(dto.getPessoaId() != null){
            solicitacao.setPessoa(
                    pessoaRepository.getReferenceById(dto.getPessoaId())
            );
        }

        //Situacao
        if(dto.getSituacaoId() != null){
            solicitacao.setSituacao(
                    situacaoRepository.getReferenceById(dto.getSituacaoId())
            );
        }

        //Congregacao Origem
        if(dto.getCongregacaoOrigemId() != null){
            solicitacao.setCongregacaoOrigem(
                    congregacaoRepository.getReferenceById(dto.getCongregacaoOrigemId())
            );
        }

        //Congregacao Destino
        if(dto.getCongregacaoDestinoId() != null){
            solicitacao.setCongregacaoDestino(
                    congregacaoRepository.getReferenceById(dto.getCongregacaoDestinoId())
            );
        }

        var result = solicitacaoRepository.save(solicitacao);

        return SolicitacaoTransferenciaResponseDTO.fromSolicitacaoTransferencia(result);
    }

    // Delete
    @Transactional
    public String delete(SolicitacaoFilterDTO dto){

        if(dto.getSolicitacaoId() == null){
            throw new RuntimeException("solicitacaoId não pode ser nulo!");
        }

        Solicitacao solicitacao = solicitacaoRepository.findById(dto.getSolicitacaoId())
                .orElseThrow(()-> new RuntimeException("Solicitação não encontrada"));

        solicitacao.setDeletedAt(LocalDateTime.now());
        solicitacaoRepository.save(solicitacao);

        return "A solicitação selecionada foi deletada com sucesso!";
    }

}
