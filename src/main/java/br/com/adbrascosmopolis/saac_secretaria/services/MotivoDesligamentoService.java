package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.congregacao.CongregacaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.motivo_desligamento.MotivoDesligamentoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.models.MotivoDesligamento;
import br.com.adbrascosmopolis.saac_secretaria.repository.MotivoDesligamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotivoDesligamentoService {

    private final MotivoDesligamentoRepository motivoDesligamentoRepository;

    public MotivoDesligamentoService(MotivoDesligamentoRepository motivoDesligamentoRepository){
        this.motivoDesligamentoRepository = motivoDesligamentoRepository;
    }

    // Dropdown/ComboBox
    public List<MotivoDesligamentoDropdownDTO> dropdown() {
        List<MotivoDesligamento> motivos = motivoDesligamentoRepository.buscarTodosMotivoDesligamento();

        return motivos.stream()
                .map(m -> new MotivoDesligamentoDropdownDTO(
                        m.getMotivoDesligamentoId(),
                        m.getDescricao()
                ))
                .collect(Collectors.toList());
    }

}
