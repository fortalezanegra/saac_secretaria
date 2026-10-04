package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.CongregacaoSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.repository.CongregacaoSyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongregacaoSyncService {

    @Autowired
    private final CongregacaoSyncRepository _repository;

    public CongregacaoSyncService(CongregacaoSyncRepository repository){
        this._repository = repository;
    }

    // Get All Not Deleted
    public List<CongregacaoSyncDTO> getCongregacaoSyncTesouraria(){
        List<Congregacao> congregacoes = _repository.getCongregacaoSyncTesouraria();
        return congregacoes.stream()
                .map(c -> new CongregacaoSyncDTO(
                        c.getCongregacaoId(),
                        c.getNome()
                )).toList();
    }

}
