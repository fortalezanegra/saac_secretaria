package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoOcorrencia;
import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

    //Find All By Id
    @Query("""
    select o from Ocorrencia o
    left join fetch o.evento
    left join fetch o.tipoOcorrencia
    where o.ocorrenciaId = :id
    and o.deletedAt IS NULL
""")
    Ocorrencia findByIdFetchAll(@Param("id") Long id);

    //Find By Evento
    @Query("""
    select o from Ocorrencia o
    left join fetch o.evento
    left join fetch o.tipoOcorrencia
    where o.evento.eventoId = :id
    and o.deletedAt IS NULL
""")
    List<Ocorrencia> findByEvento(@Param("id") Long id);

    //Find By Congregacao
    @Query("""
    select o from Ocorrencia o
    left join fetch o.evento
    left join fetch o.tipoOcorrencia
    where o.congregacao.congregacaoId = :id
    and o.deletedAt IS NULL
""")
    List<Ocorrencia> findByCongregacao(@Param("id") Integer id);

    //Find By Evento And TipoOcorrencia
    @Query("""
    select o from Ocorrencia o
    left join fetch o.evento
    left join fetch o.tipoOcorrencia
    where o.evento.eventoId = :eventoId
    and o.tipoOcorrencia = :tipoOcorrencia
    and o.deletedAt IS NULL
""")
    Ocorrencia findByEventoAndTipoOcorrencia(
            @Param("eventoId") Long eventoId,
            @Param("tipoOcorrencia") TipoOcorrencia tipoOcorrencia);


    //Find All
    @Query("""
    select o from Ocorrencia o
    left join fetch o.evento
    left join fetch o.tipoOcorrencia
    where o.deletedAt IS NULL
    order by o.tipoOcorrencia ASC
""")
    List<Ocorrencia> findAllOcorrencias();

}
