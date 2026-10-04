package br.com.adbrascosmopolis.saac_secretaria.dto.congregacao;

public class CongregacaoComboBoxDTO {
    private Integer congregacaoId;
    private String nome;

    // Construtor vazio (necessário para frameworks como Jackson)
    public CongregacaoComboBoxDTO() {}

    // Construtor com parâmetros
    public CongregacaoComboBoxDTO(Integer congregacaoId, String nome) {
        this.congregacaoId = congregacaoId;
        this.nome = nome;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
