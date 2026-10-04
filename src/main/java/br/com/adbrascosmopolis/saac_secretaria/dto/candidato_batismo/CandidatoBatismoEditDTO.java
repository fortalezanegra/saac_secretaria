package br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo;

import br.com.adbrascosmopolis.saac_secretaria.models.CandidatoBatismo;

import java.time.LocalDateTime;

public class CandidatoBatismoEditDTO {

    private Long candidatoBatismoId;
    private Long batismoId;
    private Integer congregacaoId;
    private Long pessoaId;
    private Integer situacaoId;
    private LocalDateTime deletedAt;

    public static CandidatoBatismoEditDTO fromCandidatoBatismo(CandidatoBatismo c){
        CandidatoBatismoEditDTO dto = new CandidatoBatismoEditDTO();

        dto.candidatoBatismoId = c.getCandidatoBatismoId();
        dto.batismoId = c.getBatismo() != null ? c.getBatismo().getBatismoId() : null;
        dto.congregacaoId = c.getCongregacao() != null ? c.getCongregacao().getCongregacaoId() : null;
        dto.pessoaId = c.getPessoa() != null ? c.getPessoa().getPessoaId() : null;
        dto.situacaoId = c.getSituacao() != null ? c.getSituacao().getSituacaoId() : null;
        dto.deletedAt = c.getDeletedAt();

        return dto;
    }

    public Long getCandidatoBatismoId() {
        return candidatoBatismoId;
    }

    public void setCandidatoBatismoId(Long candidatoBatismoId) {
        this.candidatoBatismoId = candidatoBatismoId;
    }

    public Long getBatismoId() {
        return batismoId;
    }

    public void setBatismoId(Long batismoId) {
        this.batismoId = batismoId;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Integer getSituacaoId() {
        return situacaoId;
    }

    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
