package br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial;

import br.com.adbrascosmopolis.saac_secretaria.models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReuniaoMinisterialRequestDTO {

    private Integer tipoReuniaoId;
    private Integer congregacaoId;
    private LocalDate dataReuniao;
    private Integer situacaoId;
    private LocalDateTime deletedAt;

    public ReuniaoMinisterialRequestDTO(
            Integer tipoReuniaoId,
            Integer congregacaoId,
            LocalDate dataReuniao,
            Integer situacaoId,
            LocalDateTime deletedAt
    ){
        this.tipoReuniaoId = tipoReuniaoId;
        this.congregacaoId = congregacaoId;
        this.dataReuniao = dataReuniao;
        this.situacaoId = situacaoId;
        this.deletedAt = deletedAt;
    }

    public ReuniaoMinisterial mapToReuniaoMinisterial(){

        ReuniaoMinisterial reuniao = new ReuniaoMinisterial();

        reuniao.setDataReuniao(this.dataReuniao);
        reuniao.setDeletedAt(this.deletedAt);

        //Relacionamentos
        if(this.tipoReuniaoId != null){
            TipoReuniao tipo = new TipoReuniao();
            tipo.setTipoReuniaoId(this.tipoReuniaoId);
            reuniao.setTipoReuniao(tipo);
        }

        if(this.congregacaoId != null){
            Congregacao congregacao = new Congregacao();
            congregacao.setCongregacaoId(this.congregacaoId);
            reuniao.setCongregacao(congregacao);
        }

        if(this.situacaoId != null){
            Situacao situacao = new Situacao();
            situacao.setSituacaoId(this.situacaoId);
            reuniao.setSituacao(situacao);
        }

        return reuniao;
    }

    public Integer getTipoReuniaoId() {
        return tipoReuniaoId;
    }

    public void setTipoReuniaoId(Integer tipoReuniaoId) {
        this.tipoReuniaoId = tipoReuniaoId;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public LocalDate getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(LocalDate dataReuniao) {
        this.dataReuniao = dataReuniao;
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
