package br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes;

public enum SituacaoSolicitacao {

    AGUARDANDO_REUNIAO("Aguardando Reuniao"),
    APROVADA("Aprovada"),
    REPROVADA("Reprovada"),
    CANCELADA("Cancelada"),
    REAGENDADA("Reagendada");

    private final String descricao;

    SituacaoSolicitacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SituacaoSolicitacao fromDescricao(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        for (SituacaoSolicitacao s : values()) {
            if (s.descricao.equalsIgnoreCase(valor.trim())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Situação de solicitação inválida: " + valor);
    }
}
