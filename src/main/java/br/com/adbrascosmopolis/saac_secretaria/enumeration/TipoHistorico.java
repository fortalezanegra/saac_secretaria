package br.com.adbrascosmopolis.saac_secretaria.enumeration;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoPessoa;

public enum TipoHistorico {

    INFORMATIVO("Informativo"),
    CONFIDENCIAL("Confidencial");

    private final String descricao;

    TipoHistorico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoHistorico fromDescricao(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        for (TipoHistorico s : values()) {
            if (s.descricao.equalsIgnoreCase(valor.trim())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Tipo Historico inválido: " + valor);
    }

}
