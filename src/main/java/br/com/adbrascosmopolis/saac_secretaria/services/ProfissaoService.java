package br.com.adbrascosmopolis.saac_secretaria.services;


import br.com.adbrascosmopolis.saac_secretaria.dto.profissao.ProfissaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Profissao;
import br.com.adbrascosmopolis.saac_secretaria.repository.ProfissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissaoService {

    private final ProfissaoRepository _repository;

    public ProfissaoService(ProfissaoRepository repository){
        this._repository = repository;
    }

    public List<ProfissaoDropdownDTO> dropdown(){
        List<ProfissaoDropdownDTO> profissoes = _repository.profissaoDropdown();
        return profissoes;
    }
}