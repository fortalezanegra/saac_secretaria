package br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.format.DateTimeFormatter;

public class CandidatoBatismoDropdownDTO {


    private Long candidatoBatismoId;
    private String pessoa;
    private String situacao;

    public CandidatoBatismoDropdownDTO(
            Long candidatoBatismoId,
            String pessoa,
            String situacao
    ){
        this.candidatoBatismoId = candidatoBatismoId;
        this.pessoa = pessoa;
        this.situacao = situacao;
    }

    public Long getCandidatoBatismoId() {
        return candidatoBatismoId;
    }

    public void setCandidatoBatismoId(Long candidatoBatismoId) {
        this.candidatoBatismoId = candidatoBatismoId;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
