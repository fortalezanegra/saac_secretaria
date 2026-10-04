package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_solicitacao.TipoSolicitacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.TipoSolicitacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoSolicitacaoService {
    private final TipoSolicitacaoRepository tipoSolicitacaoRepository;

    public TipoSolicitacaoService(TipoSolicitacaoRepository tipoSolicitacaoRepository){
        this.tipoSolicitacaoRepository = tipoSolicitacaoRepository;
    }

    //Dropdown/ComboBox
    public List<TipoSolicitacaoDropdownDTO> dropdown() {
        List<TipoSolicitacao> tipo = tipoSolicitacaoRepository.buscarTodosTipoSolicitacao();

        return tipo.stream()
                .map(t -> new TipoSolicitacaoDropdownDTO(
                        t.getTipoSolicitacaoId(),
                        t.getDescricao()
                ))
                .collect(Collectors.toList());
    }

}
