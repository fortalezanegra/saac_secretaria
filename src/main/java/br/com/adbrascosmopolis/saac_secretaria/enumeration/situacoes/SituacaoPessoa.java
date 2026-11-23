package br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes;

public enum SituacaoPessoa {

    ATIVO("Ativo"),
    INATIVO("Inativo"),
    FALECIDO("Falecido"),
    NA("N/A");

    private final String descricao;

    SituacaoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SituacaoPessoa fromDescricao(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        for (SituacaoPessoa s : values()) {
            if (s.descricao.equalsIgnoreCase(valor.trim())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Situação de pessoa inválida: " + valor);
    }
}
