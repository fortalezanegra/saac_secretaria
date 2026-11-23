package br.com.adbrascosmopolis.saac_secretaria.enumeration;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoPessoa;

public enum TipoVinculo {
    ASSISTIDO("Assitido"),
    CONTRIBUINTE("Contribuinte"),
    NOVO_CONVERTIDO("Novo Convertido"),
    CONGREGADO("Congregado"),
    MEMBRO("Membro");

    private final String descricao;

    TipoVinculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoVinculo fromDescricao(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        for (TipoVinculo s : values()) {
            if (s.descricao.equalsIgnoreCase(valor.trim())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Tipo Vinculo de pessoa inválida: " + valor);
    }
}
