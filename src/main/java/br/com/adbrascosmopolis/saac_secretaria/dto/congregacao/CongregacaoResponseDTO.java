package br.com.adbrascosmopolis.saac_secretaria.dto.congregacao;

import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;

public class CongregacaoResponseDTO {

    private Integer congregacaoId;
    private String setor;
    private String nome;
    private String sigla;
    private String endereco;

    public CongregacaoResponseDTO(
            Integer congregacaoId,
            String setor,
            String nome,
            String sigla,
            String endereco
    ){
        this.congregacaoId = congregacaoId;
        this.setor = setor;
        this.nome = nome;
        this.sigla = sigla;
        this.endereco = endereco;
    }

    public static CongregacaoResponseDTO fromCongregacao(Congregacao c){
        if(c == null) return null;

        return new CongregacaoResponseDTO(
                c.getCongregacaoId(),
                c.getSetor() != null ? c.getSetor().getDescricao() : null,
                c.getNome(),
                c.getSigla(),
                c.getEndereco()
        );
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
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
