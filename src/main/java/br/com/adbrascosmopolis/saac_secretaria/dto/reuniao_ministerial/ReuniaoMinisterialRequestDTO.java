package br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoReuniao;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoReuniaoMinisterial;
import br.com.adbrascosmopolis.saac_secretaria.models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReuniaoMinisterialRequestDTO {

    private TipoReuniao tipoReuniao;
    private Integer congregacaoId;
    private LocalDate dataReuniao;
    private SituacaoReuniaoMinisterial situacao;
    private LocalDateTime deletedAt;

    public ReuniaoMinisterialRequestDTO(
            TipoReuniao tipoReuniao,
            Integer congregacaoId,
            LocalDate dataReuniao,
            SituacaoReuniaoMinisterial situacao,
            LocalDateTime deletedAt
    ){
        this.tipoReuniao = tipoReuniao;
        this.congregacaoId = congregacaoId;
        this.dataReuniao = dataReuniao;
        this.situacao = situacao;
        this.deletedAt = deletedAt;
    }

    public ReuniaoMinisterialRequestDTO(){}

    public ReuniaoMinisterial mapToReuniaoMinisterial(){

        ReuniaoMinisterial reuniao = new ReuniaoMinisterial();

        reuniao.setTipoReuniao(this.tipoReuniao);
        reuniao.setDataReuniao(this.dataReuniao);
        reuniao.setSituacao(this.situacao);
        reuniao.setDeletedAt(this.deletedAt);

        if(this.congregacaoId != null){
            Congregacao congregacao = new Congregacao();
            congregacao.setCongregacaoId(this.congregacaoId);
            reuniao.setCongregacao(congregacao);
        }

        return reuniao;
    }

    public TipoReuniao getTipoReuniao() {
        return tipoReuniao;
    }

    public void setTipoReuniao(TipoReuniao tipoReuniao) {
        this.tipoReuniao = tipoReuniao;
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

    public SituacaoReuniaoMinisterial getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoReuniaoMinisterial situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
