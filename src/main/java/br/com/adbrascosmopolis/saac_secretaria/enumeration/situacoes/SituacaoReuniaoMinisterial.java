package br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes;

public enum SituacaoReuniaoMinisterial {

    PENDENTE("Pendente"),
    PAUTADA("Pautada"),
    EM_ANDAMENTO("Em Andamento"),
    CONCLUIDA("Concluida"),
    CONSOLIDADA("Consolidada"),
    CANCELADA("Cancelada");

    private final String descricao;

    SituacaoReuniaoMinisterial(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SituacaoReuniaoMinisterial fromDescricao(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        for (SituacaoReuniaoMinisterial s : values()) {
            if (s.descricao.equalsIgnoreCase(valor.trim())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Situação de solicitação inválida: " + valor);
    }
}
