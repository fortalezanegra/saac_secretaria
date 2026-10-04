package br.com.adbrascosmopolis.saac_secretaria.dto.endereco;

import br.com.adbrascosmopolis.saac_secretaria.models.*;

public class EnderecoRequestDTO {

    private Long pessoaId;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cep;
    private Long cidadeId;

    public EnderecoRequestDTO(
            Long pessoaId,
            String logradouro,
            Integer numero,
            String complemento,
            String bairro,
            String cep,
            Long cidadeId
    ){
        this.pessoaId = pessoaId;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidadeId = cidadeId;
    }

    public Endereco mapToEndereco(){
        Endereco endereco = new Endereco();

        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setComplemento(this.complemento);
        endereco.setBairro(this.bairro);
        endereco.setCep(this.cep);

        // Relacionamentos
        if(this.pessoaId != null){
            Pessoa pessoa = new Pessoa();

            pessoa.setPessoaId(this.pessoaId);
            endereco.setPessoa(pessoa);
        }

        if(this.cidadeId != null){
            Cidade cidade= new Cidade();

            cidade.setCidadeId(this.cidadeId);
            endereco.setCidade(cidade);
        }

        return endereco;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }
}
