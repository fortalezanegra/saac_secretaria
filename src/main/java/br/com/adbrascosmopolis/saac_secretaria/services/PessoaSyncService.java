package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria.PessoaSyncDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import br.com.adbrascosmopolis.saac_secretaria.repository.PessoaSyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaSyncService {

    @Autowired
    private final PessoaSyncRepository _pessoaSyncRepository;

    public PessoaSyncService(PessoaSyncRepository pessoaSyncRepository){
        _pessoaSyncRepository = pessoaSyncRepository;
    }

    // Get All Not Deleted
    public List<PessoaSyncDTO> getPessoaSyncTesouraria(){
        List<Pessoa> pessoas = _pessoaSyncRepository.getPessoaSyncTesouraria();
        return pessoas.stream()
                .map(p -> new PessoaSyncDTO(
                        p.getPessoaId(),
                        p.getTipoVinculo() != null ? p.getTipoVinculo().getTipoVinculoId() : null,
                        p.getCongregacao() != null ? p.getCongregacao().getCongregacaoId() : null,
                        p.getCargoMinisterial() != null ? p.getCargoMinisterial().getCargoMinisterialId() : null,
                        p.getNome()
                )).toList();
    }
}
