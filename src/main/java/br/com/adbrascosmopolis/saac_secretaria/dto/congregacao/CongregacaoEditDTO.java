package br.com.adbrascosmopolis.saac_secretaria.dto.congregacao;

import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;

import java.time.LocalDateTime;

public class CongregacaoEditDTO {

    private Integer congregacaoId;
    private Integer setorId;
    private String nome;
    private String sigla;
    private String endereco;
    private LocalDateTime deletedAt;

    public static CongregacaoEditDTO fromCongregacao(Congregacao c){

        CongregacaoEditDTO dto = new CongregacaoEditDTO();

        dto.congregacaoId = c.getCongregacaoId();
        dto.setorId = c.getSetor() != null ? c.getSetor().getSetorId() : null;
        dto.nome = c.getNome();
        dto.sigla = c.getSigla();
        dto.endereco = c.getEndereco();
        dto.deletedAt = c.getDeletedAt();

        return dto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSetorId() {
        return setorId;
    }

    public void setSetorId(Integer setorId) {
        this.setorId = setorId;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
