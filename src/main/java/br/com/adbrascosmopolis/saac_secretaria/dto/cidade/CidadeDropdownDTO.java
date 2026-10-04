package br.com.adbrascosmopolis.saac_secretaria.dto.cidade;

public class CidadeDropdownDTO {
    private Long cidadeId;
    private String nome;
    private String estado;

    public CidadeDropdownDTO(Long cidadeId, String nome, String estado){
        this.cidadeId = cidadeId;
        this.nome = nome;
        this.estado = estado;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
