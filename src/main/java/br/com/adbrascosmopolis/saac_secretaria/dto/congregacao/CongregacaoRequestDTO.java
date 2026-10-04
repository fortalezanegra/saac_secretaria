package br.com.adbrascosmopolis.saac_secretaria.dto.congregacao;

import br.com.adbrascosmopolis.saac_secretaria.models.*;

public class CongregacaoRequestDTO {

    private Integer setorId;
    private String nome;
    private String sigla;
    private String endereco;

    public CongregacaoRequestDTO(
            Integer setorId,
            String nome,
            String sigla,
            String endereco
    ){
        this.setorId = setorId;
        this.nome = nome;
        this.sigla = sigla;
        this.endereco = endereco;
    }

    public Congregacao mapToCongregacao(){
        Congregacao congregacao = new Congregacao();

        congregacao.setNome(this.nome);
        congregacao.setSigla(this.sigla);
        congregacao.setEndereco(this.endereco);

        // Relacionamentos
        if(this.setorId != null){
            Setor setor = new Setor();
            setor.setSetorId(this.setorId);
            congregacao.setSetor(setor);
        }

        return congregacao;
    }

    public Integer getSetorId() {
        return setorId;
    }

    public void setSetorId(Integer setorId) {
        this.setorId = setorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
