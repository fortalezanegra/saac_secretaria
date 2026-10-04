package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.AtaReuniao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AtaReuniaoRepository extends JpaRepository<AtaReuniao, Long> {

    AtaReuniao findByAtaReuniaoId(Long dataReuniao);
    AtaReuniao findByReuniaoMinisterialReuniaoMinisterialId(Long reuniaoId);

    @Query("""
    select a from AtaReuniao a
    left join fetch a.reuniaoMinisterial
    left join fetch a.situacao
    where a.ataReuniaoId = :id
""")
    Optional<AtaReuniao> findByIdFetchAll(@Param("id") Long id);


    /* Upload Atas */
    @Transactional
    @Modifying
    @Query("UPDATE AtaReuniao a SET a.urlAta = :urlAta WHERE a.ataReuniaoId = :id")
    int atualizarUrlAta(@Param("id") Integer id, @Param("urlAta") String urlAta);








}
