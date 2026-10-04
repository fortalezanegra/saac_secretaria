package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CongregacaoRepository extends JpaRepository<Congregacao, Integer> {

    @Query("""
    select c from Congregacao c
    left join fetch c.setor
    where c.congregacaoId = :id
""")
    Optional<Congregacao> findByIdFetchAll(@Param("id") Integer id);

    Congregacao findByNome(String nome);

    Congregacao findByCongregacaoId(Integer congregacaoId);

    List<Congregacao> findBySetorSetorId(Integer setorId);


}
