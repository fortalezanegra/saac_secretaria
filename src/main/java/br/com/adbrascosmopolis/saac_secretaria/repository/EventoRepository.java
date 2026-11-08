package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Evento;
import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {


    //Get All Data By Id
    @Query("""
    select e from Evento e
    left join fetch e.congregacao
    left join fetch e.tipoEvento
    left join fetch e.situacao
    where e.eventoId = :id
""")
    Evento findByIdFetchAll(@Param("id") Long id);


    //Find All By Congregacao
    @Query("""
    select e from Evento e
    left join fetch e.congregacao
    left join fetch e.tipoEvento
    left join fetch e.situacao
    where e.congregacao.congregacaoId = :id
""")
    List<Evento> findAllEventosByCongregacao(@Param("id") Integer id);


    //Find All Eventos
    @Query("""
    select e from Evento e
    left join fetch e.congregacao
    left join fetch e.tipoEvento
    left join fetch e.situacao
    where e.deletedAt IS NULL
    order by e.dataEvento DESC
""")
    List<Evento> findAllEventos();




}
