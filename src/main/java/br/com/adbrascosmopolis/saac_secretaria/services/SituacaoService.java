package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.situacao.SituacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Situacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.SituacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SituacaoService {

    private final SituacaoRepository _repository;

    public SituacaoService(SituacaoRepository repository){
        this._repository = repository;
    }

    public List<SituacaoDropdownDTO> dropdownSituacaoContexto(String contexto){
        List<Situacao> situacaoMembro = _repository.listarSituacaoContexto(contexto);

        return situacaoMembro.stream()
                .map(s -> new SituacaoDropdownDTO(
                        s.getSituacaoId(),
                        s.getDescricao(),
                        s.getContexto()
                ))
                .collect(Collectors.toList());

    }



}