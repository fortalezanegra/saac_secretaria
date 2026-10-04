package br.com.adbrascosmopolis.saac_secretaria.dto.batismo;

import br.com.adbrascosmopolis.saac_secretaria.models.Batismo;
import br.com.adbrascosmopolis.saac_secretaria.models.Congregacao;
import br.com.adbrascosmopolis.saac_secretaria.models.Situacao;

import java.time.LocalDate;

public class BatismoRequestDTO {

    private Integer congregacaoId;
    private LocalDate dataBatismo;
    private Integer situacaoId;

    public BatismoRequestDTO(
            Integer congregacaoId,
            LocalDate dataBatismo,
            Integer situacaoId
    ){
        this.congregacaoId = congregacaoId;
        this.dataBatismo = dataBatismo;
        this.situacaoId = situacaoId;
    }

    public Batismo mapToBatismo(){
        Batismo batismo = new Batismo();

        batismo.setDataBatismo(this.dataBatismo);

        //Relacionamentos
        if(this.congregacaoId != null){
            Congregacao congregacao = new Congregacao();
            congregacao.setCongregacaoId(this.congregacaoId);
            batismo.setCongregacao(congregacao);
        }

        if(this.situacaoId != null){
            Situacao situacao = new Situacao();
            situacao.setSituacaoId(this.situacaoId);
            batismo.setSituacao(situacao);
        }

        return batismo;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public LocalDate getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDate dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public Integer getSituacaoId() {
        return situacaoId;
    }

    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
    }
}
