package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.cidade.CidadeDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Cidade;
import br.com.adbrascosmopolis.saac_secretaria.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository){
        this.cidadeRepository = cidadeRepository;
    }

    // Dropdown/ComboBox
    public List<CidadeDropdownDTO> dropdown() {
        List<Cidade> cidades = cidadeRepository.findAll();

        return cidades.stream()
                .map(c -> new CidadeDropdownDTO(
                        c.getCidadeId(),
                        c.getNome(),
                        c.getEstado().getSigla()
                ))
                .collect(Collectors.toList());
    }

}
