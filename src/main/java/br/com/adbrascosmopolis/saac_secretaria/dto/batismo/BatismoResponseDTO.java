package br.com.adbrascosmopolis.saac_secretaria.dto.batismo;

import br.com.adbrascosmopolis.saac_secretaria.models.Batismo;

import java.time.LocalDate;

public class BatismoResponseDTO {

    private Long batismoId;
    private String congregacao;
    private LocalDate dataBatismo;
    private String situacao;

    public BatismoResponseDTO(
            Long batismoId,
            String congregacao,
            LocalDate dataBatismo,
            String situacao
    ){
        this.batismoId = batismoId;
        this.congregacao = congregacao;
        this.dataBatismo = dataBatismo;
        this.situacao = situacao;
    }

    public static BatismoResponseDTO fromBatismo(Batismo b){

        if(b == null) return null;

        return new BatismoResponseDTO(
                b.getBatismoId(),
                b.getCongregacao() != null ? b.getCongregacao().getNome() : null,
                b.getDataBatismo(),
                b.getSituacao() != null ? b.getSituacao().getDescricao() : null
        );
    }

    public Long getBatismoId() {
        return batismoId;
    }

    public void setBatismoId(Long batismoId) {
        this.batismoId = batismoId;
    }

    public String getCongregacao() {
        return congregacao;
    }

    public void setCongregacao(String congregacao) {
        this.congregacao = congregacao;
    }

    public LocalDate getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDate dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
