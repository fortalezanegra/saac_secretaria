package br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo;

import br.com.adbrascosmopolis.saac_secretaria.models.CandidatoBatismo;

import java.time.LocalDate;

public class CandidatoBatismoResponseDTO {

    private Long candidatoBatismoId;
    private LocalDate dataBatismo;
    private String congregacao;
    private String pessoa;
    private String situacao;

    public CandidatoBatismoResponseDTO(
            Long candidatoBatismoId,
            LocalDate dataBatismo,
            String congregacao,
            String pessoa,
            String situacao
    ){
        this.candidatoBatismoId = candidatoBatismoId;
        this.dataBatismo = dataBatismo;
        this.congregacao = congregacao;
        this.pessoa = pessoa;
        this.situacao = situacao;
    }

    public static CandidatoBatismoResponseDTO fromCandidatoBatismo(CandidatoBatismo c){
        if(c == null) return null;

        return new CandidatoBatismoResponseDTO(
                c.getCandidatoBatismoId(),
                c.getBatismo() != null ? c.getBatismo().getDataBatismo() : null,
                c.getCongregacao() != null ? c.getCongregacao().getNome() : null,
                c.getPessoa() != null ? c.getPessoa().getNome() : null,
                c.getSituacao() != null ? c.getSituacao().getDescricao() : null
        );
    }

    public Long getCandidatoBatismoId() {
        return candidatoBatismoId;
    }

    public void setCandidatoBatismoId(Long candidatoBatismoId) {
        this.candidatoBatismoId = candidatoBatismoId;
    }

    public LocalDate getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDate dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public String getCongregacao() {
        return congregacao;
    }

    public void setCongregacao(String congregacao) {
        this.congregacao = congregacao;
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
