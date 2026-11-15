package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoTransferencia;
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


    /* List Solictacao Transferencia By Id */
    @Query("""
        SELECT s
        FROM Solicitacao s
        JOIN FETCH s.congregacaoSolicitante
        JOIN FETCH s.pessoa
        JOIN FETCH s.situacao
        WHERE s.deletedAt IS NULL AND s.solicitacaoId = :id    
    """)
    SolicitacaoTransferencia searchById(@Param("id") Long id);


}
