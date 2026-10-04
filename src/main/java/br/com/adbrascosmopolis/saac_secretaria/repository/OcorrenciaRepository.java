package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Integer> {


    @Query("""
    select o from Ocorrencia o
    left join fetch o.evento
    left join fetch o.tipoOcorrencia
    where o.ocorrenciaId = :id
    and o.deletedAt IS NULL
""")
    Optional<Ocorrencia> findByIdFetchAll(@Param("id") Integer id);

    //Buscar Ocorrencias por Evento
    @Query("""
    select o from Ocorrencia o
    left join fetch o.evento
    left join fetch o.tipoOcorrencia
    where o.evento.eventoId = :id
    and o.deletedAt IS NULL
""")
    List<Ocorrencia> buscarOcorrenciaPorEvento(@Param("id") Integer id);

    //Buscar por Evento e TipoOcorrencia (Duplicidade)
    @Query("""
    select o from Ocorrencia o
    left join fetch o.evento
    left join fetch o.tipoOcorrencia
    where o.evento.eventoId = :eventoId
    and o.tipoOcorrencia.tipoOcorrenciaId = :tipoOcorrenciaId
    and o.deletedAt IS NULL
""")
    Ocorrencia buscarPorEventoEOcorrencia(
            @Param("eventoId") Integer eventoId,
            @Param("tipoOcorrenciaId") Integer tipoOcorrenciaId);


    //Buscar Todas as Ocorrencias
    @Query("""
    select o from Ocorrencia o
    left join fetch o.evento
    left join fetch o.tipoOcorrencia
    where o.deletedAt IS NULL
    order by o.tipoOcorrencia.descricao ASC
""")
    List<Ocorrencia> buscarTodasOcorrencias();

}
