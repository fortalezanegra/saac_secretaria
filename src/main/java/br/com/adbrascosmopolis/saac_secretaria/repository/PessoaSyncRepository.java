package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PessoaSyncRepository extends JpaRepository<Pessoa, Long> {

    @Query("""
    select p
    from Pessoa p
    left join fetch p.tipoVinculo
    left join fetch p.congregacao
    left join fetch p.cargoMinisterial
    left join fetch p.situacao
    where p.deletedAt is null
""")
    List<Pessoa> getPessoaSyncTesouraria();

}
