package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.CargoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CargoMinisterialSyncRepository extends JpaRepository<CargoMinisterial, Integer> {

    @Query("""
        select c
        from CargoMinisterial c
        where c.deletedAt is null
    """)
    List<CargoMinisterial> getCargoMinisterialSyncTesouraria();

}
