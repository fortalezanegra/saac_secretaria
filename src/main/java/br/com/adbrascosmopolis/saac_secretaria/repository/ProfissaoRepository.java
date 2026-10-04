package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.dto.profissao.ProfissaoDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {

    //Dropdown
    @Query("""
        SELECT new br.com.adbrascosmopolis.saac_secretaria.dto.profissao.ProfissaoDropdownDTO(
            p.profissaoId,
            p.descricao
        )
        FROM Profissao p
        WHERE p.deletedAt IS NULL
        ORDER BY p.descricao ASC
    """)
    List<ProfissaoDropdownDTO> profissaoDropdown();

    Profissao findByDescricao(String descricao);

}
