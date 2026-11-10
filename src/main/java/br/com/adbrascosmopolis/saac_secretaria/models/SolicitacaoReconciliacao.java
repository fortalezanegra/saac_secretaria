package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "SolicitacaoReconciliacao")
@PrimaryKeyJoinColumn(name = "solicitacaoId", referencedColumnName = "solicitacaoId")
public class SolicitacaoReconciliacao extends Solicitacao{
}
