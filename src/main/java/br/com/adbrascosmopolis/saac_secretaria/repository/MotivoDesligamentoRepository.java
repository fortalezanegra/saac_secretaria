package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.MotivoDesligamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotivoDesligamentoRepository extends JpaRepository<MotivoDesligamento, Integer> {

    @Query("""
    select m from MotivoDesligamento m
    where deletedAt IS NULL
""")
    List<MotivoDesligamento> buscarTodosMotivoDesligamento();
}
