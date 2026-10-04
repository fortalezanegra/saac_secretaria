package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_ocorrencia.TipoOcorrenciaDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoOcorrencia;
import br.com.adbrascosmopolis.saac_secretaria.repository.TipoOcorrenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoOcorrenciaService {

    public final TipoOcorrenciaRepository repository;

    public TipoOcorrenciaService(TipoOcorrenciaRepository repository){
        this.repository = repository;
    }

    //Dropdown/ComboBox
    public List<TipoOcorrenciaDropdownDTO> dropdown(){
        List<TipoOcorrencia> tipos = repository.findAll();

        return tipos.stream()
                .map(t -> new TipoOcorrenciaDropdownDTO(
                        t.getTipoOcorrenciaId(),
                        t.getDescricao()
                ))
                .collect(Collectors.toList());
    }






}
