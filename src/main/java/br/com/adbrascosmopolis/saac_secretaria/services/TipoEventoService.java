package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.tipo_evento.TipoEventoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoEvento;
import br.com.adbrascosmopolis.saac_secretaria.repository.TipoEventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoEventoService {

    public final TipoEventoRepository repository;

    public TipoEventoService(TipoEventoRepository repository){
        this.repository = repository;
    }

    //Dropdown/ComboBox
    public List<TipoEventoDropdownDTO> dropdown(){
        List<TipoEvento> tipos = repository.findAll();

        return tipos.stream()
                .map(t -> new TipoEventoDropdownDTO(
                        t.getTipoEventoId(),
                        t.getDescricao()
                ))
                .collect(Collectors.toList());
    }






}
