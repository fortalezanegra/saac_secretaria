package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_vinculo.TipoVinculoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoVinculo;
import br.com.adbrascosmopolis.saac_secretaria.repository.TipoVinculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoVinculoService {

    private final TipoVinculoRepository tipoVinculoRepository;

    public TipoVinculoService(TipoVinculoRepository tipoVinculoRepository){
        this.tipoVinculoRepository = tipoVinculoRepository;
    }

    // Dropdown/ComboBox
    public List<TipoVinculoDropdownDTO> dropdown() {
        List<TipoVinculo> tipoVinculo = tipoVinculoRepository.findAll();

        return tipoVinculo.stream()
                .map(c -> new TipoVinculoDropdownDTO(
                        c.getTipoVinculoId(),
                        c.getDescricao()
                ))
                .collect(Collectors.toList());
    }

}
