package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoSolicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    /*
    * ###########################################################################################
    * ################  QUERIES FOR REQUESTS ( SOLICITAÇÕES )  ##################################
    * ###########################################################################################
    * */

    /* List Solicitacao Transferencia By Id */
    @Query("""
        SELECT s
        FROM Solicitacao s
        JOIN FETCH s.congregacaoSolicitante
        JOIN FETCH s.pessoa
        JOIN FETCH s.situacao
        WHERE s.deletedAt IS NULL AND s.solicitacaoId = :id    
    """)
    SolicitacaoTransferencia transferenciaSearchById(@Param("id") Long id);

    /* List Solicitacao Mudança By Id */
    @Query("""
        SELECT s
        FROM Solicitacao s
        JOIN FETCH s.congregacaoSolicitante
        JOIN FETCH s.pessoa
        JOIN FETCH s.situacao
        WHERE s.deletedAt IS NULL AND s.solicitacaoId = :id    
    """)
    SolicitacaoMudanca mudancaSearchById(@Param("id") Long id);

    /* List Solicitacao Uniao By Id */
    @Query("""
        SELECT s
        FROM Solicitacao s
        JOIN FETCH s.congregacaoSolicitante
        JOIN FETCH s.pessoa
        JOIN FETCH s.situacao
        WHERE s.deletedAt IS NULL AND s.solicitacaoId = :id    
    """)
    SolicitacaoUniao uniaoSearchById(@Param("id") Long id);

    /* List Solicitacao Reconciliacao By Id */
    @Query("""
        SELECT s
        FROM Solicitacao s
        JOIN FETCH s.congregacaoSolicitante
        JOIN FETCH s.pessoa
        JOIN FETCH s.situacao
        WHERE s.deletedAt IS NULL AND s.solicitacaoId = :id    
    """)
    SolicitacaoReconciliacao reconciliacaoSearchById(@Param("id") Long id);

    /* List Solicitacao Desligamento By Id */
    @Query("""
        SELECT s
        FROM Solicitacao s
        JOIN FETCH s.congregacaoSolicitante
        JOIN FETCH s.pessoa
        JOIN FETCH s.situacao
        WHERE s.deletedAt IS NULL AND s.solicitacaoId = :id    
    """)
    SolicitacaoDesligamento desligamentoSearchById(@Param("id") Long id);

    /* ############################################################################################## */

    Solicitacao findBySolicitacaoId(Long solicitacaoId);

    /* List All REQUESTS (Solicitações) */
    @Query("""
        SELECT s
        FROM Solicitacao s
        JOIN FETCH s.congregacaoSolicitante
        JOIN FETCH s.pessoa
        JOIN FETCH s.situacao
        WHERE s.deletedAt IS NULL
        ORDER BY s.tipoSolicitacao, s.congregacaoSolicitante.nome ASC    
    """)
    List<Solicitacao> listAll();

    /* List Requests (Solicitações) From Agenda By reuniaoMinisterialId */
    @Query("""
        SELECT s
          FROM Solicitacao s
          LEFT JOIN FETCH s.pessoa
          LEFT JOIN FETCH s.congregacaoSolicitante
          JOIN s.reuniaoMinisterial r
         WHERE r.reuniaoMinisterialId = :reuniaoId
           AND r.situacao = :situacao
           AND r.deletedAt IS NULL
           AND s.deletedAt IS NULL
         ORDER BY s.createdAt, s.solicitacaoId
        """)
    List<Solicitacao> listRequestFromAgendaByReuniaoMinisterialId(
            @Param("reuniaoId") Long reuniaoId,
            @Param("situacao") SituacaoReuniaoMinisterial situacao
    );

    /* Search Requests (Solicitações) For Building Agenda */
    @Query("""
    SELECT s
    FROM Solicitacao s
    WHERE s.reuniaoMinisterial IS NULL
    """)
    List<Solicitacao> searchRequestsForBuildingAgenda();

    /* Search Requests (Solicitações) For Building Agenda */
    @Query("""
    SELECT s
    FROM Solicitacao s
    WHERE s.reuniaoMinisterial IS NULL
    AND s.reuniaoMinisterial.reuniaoMinisterialId = :id
    AND s.situacao = :situacao
    """)
    List<Solicitacao> searchRequestsForReuniaoAndSituacao(
            @Param("id") Long id,
            @Param("situacao")SituacaoSolicitacao sitaucao
    );


    boolean existsBySolicitacaoId(Long solicitacaoId);






}
