package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.CandidatoBatismo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CandidatoBatismoRepository extends JpaRepository<CandidatoBatismo, Long> {

    List<CandidatoBatismo> findBySituacaoSituacaoId(Long situacaoId);

    List<CandidatoBatismo> findByCongregacaoCongregacaoId(Long id);

    CandidatoBatismo findByCandidatoBatismoId(Long id);


    //Dropdown/Combobox
    @Query("""
    select c from CandidatoBatismo c
    left join fetch c.batismo
    left join fetch c.congregacao
    left join fetch c.pessoa
    left join fetch c.situacao
    where c.deletedAt IS NULL
      and c.situacao.descricao = 'Pendente'
      and c.situacao.contexto = 'BATISMO_CANDIDATO'
    order by c.batismo.dataBatismo DESC
""")
    List<CandidatoBatismo> buscarCandidatosPendentes();

    //Busca Candidado Pendente por Congregacao
    @Query("""
    select c from CandidatoBatismo c
    left join fetch c.batismo
    left join fetch c.congregacao
    left join fetch c.pessoa
    left join fetch c.situacao
    where c.congregacao.congregacaoId = :congregacaoId 
      and c.deletedAt IS NULL
      and c.situacao.descricao = 'Pendente'
      and c.situacao.contexto = 'BATISMO_CANDIDATO'
    order by c.batismo.dataBatismo DESC
""")
    List<CandidatoBatismo> buscarCandidatosPendentesPorCongregacao(@Param("congregacaoId") Integer id);

    @Query("""
    select c from CandidatoBatismo c
    left join fetch c.batismo
    left join fetch c.congregacao
    left join fetch c.pessoa
    left join fetch c.situacao
    where c.candidatoBatismoId = :id
""")
    Optional<CandidatoBatismo> findByIdFetchAll(@Param("id") Long id);






}
