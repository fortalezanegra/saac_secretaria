package br.com.adbrascosmopolis.saac_secretaria.dto.endereco;

import br.com.adbrascosmopolis.saac_secretaria.models.Endereco;

public class EnderecoResponseDTO {

    private Long enderecoId;
    private String pessoa;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private Long cidadeId;
    private String estado;

    public EnderecoResponseDTO(
            Long enderecoId,
            String pessoa,
            String logradouro,
            Integer numero,
            String complemento,
            String bairro,
            String cep,
            String cidade,
            Long cidadeId,
            String estado
    ){
        this.enderecoId = enderecoId;
        this.pessoa = pessoa;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.cidadeId = cidadeId;
        this.estado = estado;
    }

    public static EnderecoResponseDTO fromEndereco(Endereco e){
        if(e == null) return null;

        return new EnderecoResponseDTO(
                e.getEnderecoId(),
                e.getPessoa() != null ? e.getPessoa().getNome() : null,
                e.getLogradouro(),
                e.getNumero(),
                e.getComplemento(),
                e.getBairro(),
                e.getCep(),
                e.getCidade() != null ? e.getCidade().getNome() : null,
                e.getCidade().getCidadeId(),
                e.getCidade().getEstado().getSigla()
        );
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}



