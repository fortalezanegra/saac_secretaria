package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoVinculo;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoPessoa;
import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface
PessoaRepository extends JpaRepository<Pessoa, Long>, JpaSpecificationExecutor<Pessoa> {

    @Query("""
    select p from Pessoa p
    left join fetch p.congregacao
    left join fetch p.cargoMinisterial
    left join fetch p.formacao
    left join fetch p.profissao
    where p.pessoaId = :id
""")
    Optional<Pessoa> findByIdFetchAll(@Param("id") Long id);

    @Query("""
    select p from Pessoa p
    left join fetch p.congregacao
    left join fetch p.cargoMinisterial
    left join fetch p.formacao
    left join fetch p.profissao
    where p.tipoVinculo = :vinculo
    and p.situacao = :situacao
    order by p.nome
""")
    List<Pessoa> findPessoaByVinculoAndSituacao(@Param("vinculo") TipoVinculo vinculo, @Param("situacao") SituacaoPessoa situacao);

    /* Dropdown Pessoas */
    @Query("""
       SELECT p
       FROM Pessoa p
       JOIN p.congregacao c
       JOIN p.situacao s
       WHERE c.congregacaoId = :congregacaoId
         AND p.situacao = :situacao
       ORDER BY p.nome
    """)

    List<Pessoa> listarPessoasPorCongregacaoESituacao(
            @Param("congregacaoId") Integer congregacaoId,
            @Param("situacaoId") SituacaoPessoa situacao
    );

    /* Upload Foto */
    @Transactional
    @Modifying
    @Query("UPDATE Pessoa p SET p.foto = :urlFoto WHERE p.pessoaId = :id")
    int atualizarFoto(@Param("id") Integer id, @Param("urlFoto") String urlFoto);

    List<Pessoa> findByDeletedAtIsNull();

    Pessoa findByPessoaId(Long pessoaId);

    List<Pessoa> findByNome(String nome);

    List<Pessoa> findByCongregacaoCongregacaoId(Integer congregacaoId);

}
