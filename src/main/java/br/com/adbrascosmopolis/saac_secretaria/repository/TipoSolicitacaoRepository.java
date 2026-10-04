package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import br.com.adbrascosmopolis.saac_secretaria.models.TipoSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoSolicitacaoRepository extends JpaRepository<TipoSolicitacao, Integer> {

    @Query("""
    select t from TipoSolicitacao t
    where t.deletedAt IS NULL
""")
    List<TipoSolicitacao> buscarTodosTipoSolicitacao();
}
