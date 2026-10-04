package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    //Solicitação Geral

    @Query("""
    select s from Solicitacao s
    left join fetch s.reuniaoMinisterial
    left join fetch s.congregacaoSolicitante
    left join fetch s.tipoSolicitacao
    left join fetch s.pessoa
    left join fetch s.candidatoBatismo
    left join fetch s.igrejaOrigem
    left join fetch s.cargoIgrejaOrigem
    left join fetch s.cargoRecebido
    left join fetch s.congregacaoOrigem
    left join fetch s.congregacaoDestino
    left join fetch s.motivoDesligamento
    left join fetch s.situacao
    where s.solicitacaoId = :id
""")
    Optional<Solicitacao> findByIdFetchAll(@Param("id") Long id);

    Solicitacao findBySolicitacaoId(Integer id);

    //Fim Solicitação Geral


    //*********** Solicitação União Batismo *****************//

    //Buscar Solicitacao Uniao Batismo por ID
    @Query("""
    select s from Solicitacao s
    left join fetch s.reuniaoMinisterial
    left join fetch s.congregacaoSolicitante
    left join fetch s.tipoSolicitacao
    left join fetch s.pessoa
    left join fetch s.candidatoBatismo
    left join fetch s.situacao
    where s.solicitacaoId = :id
    and s.tipoSolicitacao.descricao = 'União por Batismo'
    order by s.createdAt DESC
""")
    Solicitacao BuscarSolicitacaoUniaoBatismoPorId(@Param("id") Long id);

    //Buscar Todas Solicitações Uniao Batismo
    @Query("""
    select s from Solicitacao s
    left join fetch s.reuniaoMinisterial
    left join fetch s.congregacaoSolicitante
    left join fetch s.tipoSolicitacao
    left join fetch s.pessoa
    left join fetch s.candidatoBatismo
    left join fetch s.situacao
    where s.deletedAt IS NULL
    and s.tipoSolicitacao.descricao = 'União por Batismo'
    order by s.createdAt DESC
""")
    List<Solicitacao> buscarTodasSolicitacoesUniaoBatismo();

    //Buscar Todas Solicitações Uniao Batismo por Situacao
    @Query("""
    select s from Solicitacao s
    left join fetch s.reuniaoMinisterial
    left join fetch s.congregacaoSolicitante
    left join fetch s.tipoSolicitacao
    left join fetch s.pessoa
    left join fetch s.candidatoBatismo
    left join fetch s.situacao
    where s.deletedAt IS NULL
    and s.situacao.descricao = :descricaoSituacao
    and s.tipoSolicitacao.descricao = 'União por Batismo'
    order by s.createdAt DESC
""")
    List<Solicitacao> buscarTodasSolicitacoesUniaoBatismoPorSituacao(@Param("descricaoSituacao") String descricaoSituacao);

    //Buscar Todas Solicitações Uniao Batismo por Congregação
    @Query("""
    select s from Solicitacao s
    left join fetch s.reuniaoMinisterial
    left join fetch s.congregacaoSolicitante
    left join fetch s.tipoSolicitacao
    left join fetch s.pessoa
    left join fetch s.candidatoBatismo
    left join fetch s.situacao
    where s.deletedAt IS NULL
    and s.congregacaoSolicitante.congregacaoId = :congregacaoSolicitanteId
    and s.tipoSolicitacao.descricao = 'União por Batismo'
    order by s.createdAt DESC
""")
    List<Solicitacao> buscarSolicitacoesUniaoBatismoPorCongregacao(@Param("congregacaoSolicitanteId") Integer congregacaoSolicitanteId);


    //*********** Solicitação União Mudança *****************//

    //Buscar Solicitacao Uniao Mudanca por ID
    @Query("""
    select s from Solicitacao s
    left join fetch s.reuniaoMinisterial
    left join fetch s.congregacaoSolicitante
    left join fetch s.tipoSolicitacao
    left join fetch s.pessoa
    left join fetch s.igrejaOrigem
    left join fetch s.cargoIgrejaOrigem
    left join fetch s.cargoRecebido
    left join fetch s.situacao
    where s.solicitacaoId = :id
    and s.tipoSolicitacao.descricao = 'União por Mudanca'
    order by s.createdAt DESC
""")
    Solicitacao BuscarSolicitacaoUniaoMudancaPorId(@Param("id") Long id);

    //Buscar Todas Solicitações Uniao Mudança
    @Query("""
    select s from Solicitacao s
    left join fetch s.reuniaoMinisterial
    left join fetch s.congregacaoSolicitante
    left join fetch s.tipoSolicitacao
    left join fetch s.pessoa
    left join fetch s.igrejaOrigem
    left join fetch s.cargoIgrejaOrigem
    left join fetch s.cargoRecebido
    left join fetch s.situacao
    where s.deletedAt IS NULL
    and s.tipoSolicitacao.descricao = 'União por Mudanca'
    order by s.createdAt DESC
""")
    List<Solicitacao> buscarTodasSolicitacoesUniaoMudanca();

    //Buscar Todas Solicitações Uniao Mudança por Situacao
    @Query("""
    select s from Solicitacao s
    left join fetch s.reuniaoMinisterial
    left join fetch s.congregacaoSolicitante
    left join fetch s.tipoSolicitacao
    left join fetch s.pessoa
    left join fetch s.igrejaOrigem
    left join fetch s.cargoIgrejaOrigem
    left join fetch s.cargoRecebido
    left join fetch s.situacao
    where s.deletedAt IS NULL
    and s.situacao.descricao = :descricaoSituacao
    and s.tipoSolicitacao.descricao = 'União por Mudança'
    
    order by s.createdAt DESC
""")
    List<Solicitacao> buscarTodasSolicitacoesUniaoMudancaPorSituacao(@Param("descricaoSituacao") String descricaoSituacao);

    //Buscar Todas Solicitações Uniao Mudança por Congregação
    @Query("""
    select s from Solicitacao s
    left join fetch s.reuniaoMinisterial
    left join fetch s.congregacaoSolicitante
    left join fetch s.tipoSolicitacao
    left join fetch s.pessoa
    left join fetch s.igrejaOrigem
    left join fetch s.cargoIgrejaOrigem
    left join fetch s.cargoRecebido
    left join fetch s.situacao
    where s.deletedAt IS NULL
    and s.congregacaoSolicitante.congregacaoId = :congregacaoSolicitanteId
    and s.tipoSolicitacao.descricao = 'União por Mudanca'
    order by s.createdAt DESC
""")
    List<Solicitacao> buscarSolicitacoesUniaoMudancaPorCongregacao(@Param("congregacaoSolicitanteId") Integer congregacaoSolicitanteId);

}
