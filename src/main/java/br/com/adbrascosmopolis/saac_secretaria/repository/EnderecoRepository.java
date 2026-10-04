package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("""
    select e from Endereco e
    left join fetch e.pessoa
    left join fetch e.cidade
    where e.enderecoId = :id
""")
    Optional<Endereco> findByIdFetchAll(@Param("id") Long id);

    Endereco findByEnderecoId(Integer enderecoId);

    Endereco findByPessoaPessoaId(Integer pessoaId);

}
