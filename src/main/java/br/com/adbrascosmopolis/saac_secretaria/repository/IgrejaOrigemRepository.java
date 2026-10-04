package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.IgrejaOrigem;
import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IgrejaOrigemRepository extends JpaRepository<IgrejaOrigem, Integer> {

    @Query("""
    select i from IgrejaOrigem i
    where i.igrejaOrigemId = :id
""")
    Optional<IgrejaOrigem> findByIdFetchAll(@Param("id") Integer id);

    @Query("""
    SELECT i from IgrejaOrigem i
    WHERE i.deletedAt IS NULL
    ORDER BY i.descricao ASC
""")
    List<IgrejaOrigem> buscarTodasIgrejasOrigem();

    IgrejaOrigem findByIgrejaOrigemId(Integer id);










}
