package br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria;

public class CongregacaoSyncDTO {

    private Integer congregacaoId;
    private String nome;


    public CongregacaoSyncDTO(Integer congregacaoId, String nome){
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
