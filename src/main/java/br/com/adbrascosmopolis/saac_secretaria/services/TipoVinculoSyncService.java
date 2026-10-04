package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.CongregacaoSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.TipoVinculoSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoVinculo;
import br.com.adbrascosmopolis.saac_secretaria.repository.CongregacaoSyncRepository;
import br.com.adbrascosmopolis.saac_secretaria.repository.TipoVinculoSyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoVinculoSyncService {

    @Autowired
    private final TipoVinculoSyncRepository _repository;

    public TipoVinculoSyncService(TipoVinculoSyncRepository repository){
        this._repository = repository;
    }

    // Get All Not Deleted
    public List<TipoVinculoSyncDTO> getTipoVinculoSyncTesouraria(){
        List<TipoVinculo> tipos = _repository.getTipoVinculoSyncTesouraria();
        return tipos.stream()
                .map(c -> new TipoVinculoSyncDTO(
                        c.getTipoVinculoId(),
                        c.getDescricao()
                )).toList();
    }
}
