package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CongregacaoSyncRepository extends JpaRepository<Congregacao, Integer> {

    @Query("""
        select c
        from Congregacao c
        where c.deletedAt is null
    """)
    List<Congregacao> getCongregacaoSyncTesouraria();
}
