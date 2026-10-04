package br.com.adbrascosmopolis.saac_secretaria.dto.endereco;

import br.com.adbrascosmopolis.saac_secretaria.models.Endereco;

public class EnderecoEditDTO {

    private Long enderecoId;
    private Long membroId;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cep;
    private Long cidadeId;

    public static EnderecoEditDTO fromEndereco(Endereco e){

        EnderecoEditDTO dto = new EnderecoEditDTO();

        dto.enderecoId = e.getEnderecoId();
        dto.membroId = e.getPessoa() != null ? e.getPessoa().getPessoaId() : null;
        dto.logradouro = e.getLogradouro();
        dto.numero = e.getNumero();
        dto.complemento = e.getComplemento();
        dto.bairro = e.getBairro();
        dto.cep = e.getCep();
        dto.cidadeId = e.getCidade() != null ? e.getCidade().getCidadeId() : null;

        return dto;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Long getMembroId() {
        return membroId;
    }

    public void setMembroId(Long membroId) {
        this.membroId = membroId;
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
