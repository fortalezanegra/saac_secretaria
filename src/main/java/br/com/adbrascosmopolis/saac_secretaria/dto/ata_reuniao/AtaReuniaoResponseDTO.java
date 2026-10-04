package br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao;

import br.com.adbrascosmopolis.saac_secretaria.models.AtaReuniao;

import java.time.LocalDate;

public class AtaReuniaoResponseDTO {

    private Long ataReuniaoId;
    private Long reuniaoMinisterialId;
    private String descricao;
    private LocalDate dataAta;
    private String urlData;
    private Integer situacaoId;

    public AtaReuniaoResponseDTO(
            Long ataReuniaoId,
            Long reuniaoMinisterialId,
            String descricao,
            LocalDate dataAta,
            String urlData,
            Integer situacaoId
    ){
        this.ataReuniaoId = ataReuniaoId;
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.descricao = descricao;
        this.dataAta = dataAta;
        this.urlData = urlData;
        this.situacaoId = situacaoId;
    }

    public static AtaReuniaoResponseDTO fromAtaReuniao(AtaReuniao a){
        if(a == null) return null;

        return new AtaReuniaoResponseDTO(
                a.getAtaReuniaoId(),
                a.getReuniaoMinisterial() != null ? a.getReuniaoMinisterial().getReuniaoMinisterialId() : null,
                a.getDescricao(),
                a.getDataAta(),
                a.getUrlAta(),
                a.getSituacao() != null ? a.getSituacao().getSituacaoId() : null
        );
    }

    public Long getAtaReuniaoId() {
        return ataReuniaoId;
    }

    public void setAtaReuniaoId(Long ataReuniaoId) {
        this.ataReuniaoId = ataReuniaoId;
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAta() {
        return dataAta;
    }

    public void setDataAta(LocalDate dataAta) {
        this.dataAta = dataAta;
    }

    public String getUrlData() {
        return urlData;
    }

    public void setUrlData(String urlData) {
        this.urlData = urlData;
    }

    public Integer getSituacaoId() {
        return situacaoId;
    }

    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
    }
}
