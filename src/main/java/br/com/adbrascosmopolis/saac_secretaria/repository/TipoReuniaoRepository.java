package br.com.adbrascosmopolis.saac_secretaria.repository;

import br.com.adbrascosmopolis.saac_secretaria.models.TipoReuniao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TipoReuniaoRepository extends JpaRepository<TipoReuniao, Integer> {

    TipoReuniao findByTipoReuniaoId(Integer tipoReuniaoId);







}
