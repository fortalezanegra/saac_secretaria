package br.com.adbrascosmopolis.saac_secretaria.repository.projection;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoReuniao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoSolicitacao;
import java.time.LocalDate;

public interface DecisaoMinisterialResumo {
    Long getDecisaoMinisterialId();
    String getTipoReuniao();
    LocalDate getDataReuniao();
    Integer getCongregacaoSolicitanteId();
    String getCongregacaoSolicitante();
    String getTipoSolicitacao();
    Long getPessoaId();
    String getPessoa();
    Integer getSituacaoSolicitacaoId();
    String getSituacaoSolicitacao();
}
