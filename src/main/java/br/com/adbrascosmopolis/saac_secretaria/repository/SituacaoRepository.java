package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import br.com.adbrascosmopolis.saac_secretaria.models.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SituacaoRepository extends JpaRepository<Situacao, Integer> {

    Situacao findByDescricao(String descricao);

    /* Dropdown Situacao Membros*/
    @Query("""
       SELECT s
       FROM Situacao s
       WHERE s.contexto = :contexto
""")
    List<Situacao> listarSituacaoContexto(@Param("contexto") String contexto);
}