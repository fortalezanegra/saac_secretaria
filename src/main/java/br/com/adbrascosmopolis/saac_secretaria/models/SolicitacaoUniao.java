package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;
@Entity
@Table(name = "SolicitacaoUniao")
@PrimaryKeyJoinColumn(name = "solicitacaoId", referencedColumnName = "solicitacaoId")
public class SolicitacaoUniao extends Solicitacao {

}


