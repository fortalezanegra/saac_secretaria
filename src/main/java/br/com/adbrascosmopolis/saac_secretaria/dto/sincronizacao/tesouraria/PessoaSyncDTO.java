package br.com.adbrascosmopolis.saac_secretaria.dto.sincronizacao.tesouraria;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoVinculo;

public class PessoaSyncDTO {

    private Long pessoaId;
    private TipoVinculo tipoVinculo;
    private Integer congregacaoId;
    private Integer cargoMinisterialId;
    private String nome;

    public PessoaSyncDTO(
            Long pessoaId,
            TipoVinculo tipoVinculo,
            Integer congregacaoId,
            Integer cargoMinisterialId,
            String nome
    ){
        this.pessoaId = pessoaId;
        this.tipoVinculo = tipoVinculo;
        this.congregacaoId = congregacaoId;
        this.cargoMinisterialId = cargoMinisterialId;
        this.nome = nome;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public TipoVinculo getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(TipoVinculo tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public Integer getCargoMinisterialId() {
        return cargoMinisterialId;
    }

    public void setCargoMinisterialId(Integer cargoMinisterialId) {
        this.cargoMinisterialId = cargoMinisterialId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
