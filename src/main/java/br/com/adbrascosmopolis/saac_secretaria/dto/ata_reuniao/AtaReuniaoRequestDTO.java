package br.com.adbrascosmopolis.saac_secretaria.dto.ata_reuniao;

import br.com.adbrascosmopolis.saac_secretaria.models.AtaReuniao;
import br.com.adbrascosmopolis.saac_secretaria.models.ReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.Situacao;

import java.time.LocalDate;

public class AtaReuniaoRequestDTO {

    private Long reuniaoMinisterialId;
    private String descricao;
    private LocalDate dataAta;
    private String urlAta;
    private Integer situacaoId;

    // 🔹 Construtor vazio (obrigatório para Jackson)
    public AtaReuniaoRequestDTO() {
    }

    // 🔹 Construtor completo
    public AtaReuniaoRequestDTO(
            Long reuniaoMinisterialId,
            String descricao,
            LocalDate dataAta,
            String urlAta,
            Integer situacaoId
    ){
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.descricao = descricao;
        this.dataAta = dataAta;
        this.urlAta = urlAta;
        this.situacaoId = situacaoId;
    }

    // 🔹 Mapper para entidade
    public AtaReuniao mapToAtaReuniao(){
        AtaReuniao ata = new AtaReuniao();

        ata.setDescricao(this.descricao);
        ata.setDataAta(this.dataAta);
        ata.setUrlAta(this.urlAta);

        // Relacionamento: Reunião Ministerial
        if(this.reuniaoMinisterialId != null){
            ReuniaoMinisterial reuniao = new ReuniaoMinisterial();
            reuniao.setReuniaoMinisterialId(this.reuniaoMinisterialId);
            ata.setReuniaoMinisterial(reuniao);
        }

        // Relacionamento: Situação
        if(this.situacaoId != null){
            Situacao situacao = new Situacao();
            situacao.setSituacaoId(this.situacaoId);
            ata.setSituacao(situacao);
        }

        return ata;
    }

    // 🔹 Getters e Setters

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

    public String getUrlAta() {
        return urlAta;
    }

    public void setUrlAta(String urlAta) {
        this.urlAta = urlAta;
    }

    public Integer getSituacaoId() {
        return situacaoId;
    }

    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
    }
}
