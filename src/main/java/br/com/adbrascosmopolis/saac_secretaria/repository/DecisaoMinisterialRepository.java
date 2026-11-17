package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.DecisaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.repository.projection.DecisaoMinisterialResumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DecisaoMinisterialRepository extends JpaRepository<DecisaoMinisterial, Long> {

    @Query("""
        select d
          from DecisaoMinisterial d
          join fetch d.situacao sit
          join fetch d.solicitacao sol
         where d.reuniaoMinisterial.reuniaoMinisterialId = :reuniaoId
           and d.deletedAt is null
         order by d.decisaoMinisterialId
        """)
    List<DecisaoMinisterial> listarAtivasDaReuniao(
            @Param("reuniaoId") Long reuniaoId
    );

    @Query(value = """
        SELECT
            dm.decisaoMinisterialId AS decisaoMinisterialId,
            rm.tipoReuniao AS tipoReuniao,
            rm.dataReuniao AS dataReuniao,
            s.tipoSolicitacao AS tipoSolicitacao,
            p.nome AS nome,
            sit.descricao AS situacaoSolicitacao
        FROM DecisaoMinisterial dm
        JOIN ReuniaoMinisterial rm
            ON rm.reuniaoMinisterialId = dm.reuniaoMinisterialId
        JOIN Solicitacao s
            ON s.solicitacaoId = dm.solicitacaoId
        JOIN Pessoa p
            ON p.pessoaId = s.pessoaId
        JOIN Situacao sit
            ON sit.situacaoId = s.situacaoId
            WHERE dm.deletedAt IS NULL AND sit.descricao = 'Aguardando Reuniao'
        """, nativeQuery = true)
    List<DecisaoMinisterialResumo> listarResumos();



}
