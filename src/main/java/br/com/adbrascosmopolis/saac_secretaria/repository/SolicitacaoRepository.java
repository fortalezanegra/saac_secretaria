package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    /* List All Solicitações */
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

    /* Dropdown Solicitações Aguardando Reuniao ou Reagendadas*/
    @Query("""
        SELECT s
        FROM Solicitacao s
        JOIN FETCH s.congregacaoSolicitante
        JOIN FETCH s.pessoa
        JOIN FETCH s.situacao
        WHERE s.deletedAt IS NULL AND s.situacao.descricao IN ('Aguardando Reuniao', 'Reagendada')
        ORDER BY s.tipoSolicitacao ASC    
    """)
    List<Solicitacao> dropdown();


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


}
