package br.com.adbrascosmopolis.saac_secretaria.repository.projection;

import java.time.LocalDate;

public interface DecisaoMinisterialResumo {
    Long getDecisaoMinisterialId();
    String getTipoReuniao();
    LocalDate getDataReuniao();
    String getTipoSolicitacao();
    String getNome();
    String getSituacaoSolicitacao();
}
