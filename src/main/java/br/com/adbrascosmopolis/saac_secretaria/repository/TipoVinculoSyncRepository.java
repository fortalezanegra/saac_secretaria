package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoVinculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoVinculoSyncRepository extends JpaRepository<TipoVinculo, Integer> {

    @Query("""
    select t
    from TipoVinculo t
    where t.deletedAt is null
""")
    List<TipoVinculo> getTipoVinculoSyncTesouraria();

}
