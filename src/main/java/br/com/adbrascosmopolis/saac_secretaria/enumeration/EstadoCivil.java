package br.com.adbrascosmopolis.saac_secretaria.enumeration;

public enum EstadoCivil {

    CASADO_A("Cadado(a)"),
    SOLTEIRO_A("Solteiro(a)"),
    DIVORCIADO_A("Divorciado(a)"),
    VIUVO_A("Viuvo(a)");

    private final String descricao;

    EstadoCivil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoCivil fromDescricao(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        for (EstadoCivil s : values()) {
            if (s.descricao.equalsIgnoreCase(valor.trim())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Sexo de pessoa inválido: " + valor);
    }

}
