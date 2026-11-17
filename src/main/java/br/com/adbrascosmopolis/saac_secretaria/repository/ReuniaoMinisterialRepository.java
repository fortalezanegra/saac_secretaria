package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoReuniao;
import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
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
    JOIN FETCH r.congregacao
    WHERE r.deletedAt IS NULL
    ORDER BY r.dataReuniao DESC
""")
    List<ReuniaoMinisterial> listDropdown();

    @Query("""
    select r from ReuniaoMinisterial r
    left join fetch r.congregacao
    left join fetch r.situacao
    WHERE r.deletedAt IS NULL
    AND r.reuniaoMinisterialId = :id
""")
    Optional<ReuniaoMinisterial> findByIdFetchAll(@Param("id") Long id);

    ReuniaoMinisterial findByReuniaoMinisterialId(Long reuniaoId);


    @Query("""
    select r from ReuniaoMinisterial r
    left join fetch r.congregacao
    left join fetch r.situacao
    WHERE r.deletedAt IS NULL
""")
    List<ReuniaoMinisterial> listAllNotDeleted();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        select r
          from ReuniaoMinisterial r
         where r.reuniaoMinisterialId = :id
           and r.deletedAt is null
        """)
    Optional<ReuniaoMinisterial> buscarAtivaParaAtualizacao(
            @Param("id") Long id
    );


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        select r
          from ReuniaoMinisterial r
         where r.situacao.descricao = 'Pendente'
           and r.situacao.contexto = 'REUNIAO_MINISTERIAL'
           and r.deletedAt is null
           and r.reuniaoMinisterialId = :id
        """)
    Optional<ReuniaoMinisterial> buscarReuniaoPendente(@Param("id") Long id);


}
