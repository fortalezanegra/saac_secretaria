package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReuniaoMinisterialRepository extends JpaRepository<ReuniaoMinisterial, Long> {

    ReuniaoMinisterial findByDataReuniao(LocalDate dataReuniao);

    /* Dropdown */
    @Query("""
    SELECT r
    FROM ReuniaoMinisterial r
    JOIN FETCH r.tipoReuniao
    JOIN FETCH r.congregacao
    WHERE r.deletedAt IS NULL
    ORDER BY r.dataReuniao DESC
""")
    List<ReuniaoMinisterial> listarDropdown();

    @Query("""
    select r from ReuniaoMinisterial r
    left join fetch r.tipoReuniao
    left join fetch r.congregacao
    left join fetch r.situacao
    WHERE r.deletedAt IS NULL
    AND r.reuniaoMinisterialId = :id
""")
    Optional<ReuniaoMinisterial> findByIdFetchAll(@Param("id") Long id);

    ReuniaoMinisterial findByReuniaoMinisterialId(Long reuniaoId);
}
