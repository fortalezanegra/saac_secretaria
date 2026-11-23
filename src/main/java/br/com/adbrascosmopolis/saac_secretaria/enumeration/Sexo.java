package br.com.adbrascosmopolis.saac_secretaria.enumeration;

public enum Sexo {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Sexo fromDescricao(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        for (Sexo s : values()) {
            if (s.descricao.equalsIgnoreCase(valor.trim())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Sexo de pessoa inválido: " + valor);
    }
}
