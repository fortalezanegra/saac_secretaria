package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.formacao.FormacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Formacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.FormacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormacaoService {

    private final FormacaoRepository _repository;

    public FormacaoService(FormacaoRepository repositoty){
        this._repository = repositoty;
    }

    public List<FormacaoDropdownDTO> dropdown() {
        List<Formacao> formacoes = _repository.findAll();

        return formacoes.stream()
                .map(f -> new FormacaoDropdownDTO(
                        f.getFormacaoId(),
                        f.getDescricao()
                ))
                .collect(Collectors.toList());
    }

}
