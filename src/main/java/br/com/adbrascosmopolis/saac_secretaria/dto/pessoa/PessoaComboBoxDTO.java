package br.com.adbrascosmopolis.saac_secretaria.dto.pessoa;

public class PessoaComboBoxDTO {

    private Integer pessoaId;
    private String  nome;

    public PessoaComboBoxDTO(){}

    public PessoaComboBoxDTO(Integer pessoaId, String nome){
        this.pessoaId = pessoaId;
        this.nome = nome;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
