package br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoOcorrencia;
import br.com.adbrascosmopolis.saac_secretaria.models.Atividades;
import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;

public class OcorrenciaRequestDTO {

    private Integer congregacaoId;
    private Long atividadeId;
    private TipoOcorrencia tipoOcorrencia;
    private Integer quantidade;

    public OcorrenciaRequestDTO(
            Integer congregacaoId,
            Long atividadeId,
            TipoOcorrencia tipoOcorrencia,
            Integer quantidade
    ){
        this.congregacaoId = congregacaoId;
        this.atividadeId = atividadeId;
        this.tipoOcorrencia = tipoOcorrencia;
        this.quantidade = quantidade;
    }

    public Ocorrencia mapToOcorrencia(){
        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setQuantidade(this.quantidade);

        //Relacionamento
        if(this.atividadeId != null){
            Atividades atividade = new Atividades();
            atividade.setAtividadeId(this.atividadeId);
            ocorrencia.setAtividade(atividade);
        }

        return  ocorrencia;
    }


    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public Long getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Long atividadeId) {
        this.atividadeId = atividadeId;
    }

    public TipoOcorrencia getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
