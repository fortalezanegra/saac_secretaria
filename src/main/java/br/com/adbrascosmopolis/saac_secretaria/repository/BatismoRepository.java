package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Batismo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BatismoRepository extends JpaRepository<Batismo, Long> {

    @Query("""
    select b from Batismo b
    left join fetch b.congregacao
    left join fetch b.situacao
    where b.batismoId = :id
""")
    Optional<Batismo> findByIdFetchAll(@Param("id") Long id);

    Batismo findByBatismoId(Integer id);

   List<Batismo> findByCongregacaoCongregacaoId(Long id);
}
