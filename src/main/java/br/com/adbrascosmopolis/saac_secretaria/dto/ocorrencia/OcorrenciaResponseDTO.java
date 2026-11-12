package br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoOcorrencia;
import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;

public class OcorrenciaResponseDTO {

    private Long ocorrenciaId;
    private Integer congregacaoId;
    private String congregacao;
    private Long atividadeId;
    private String atividade;
    private TipoOcorrencia tipoOcorrencia;
    private Integer quantidade;

    public OcorrenciaResponseDTO(
            Long ocorrenciaId,
            Integer congregacaoId,
            String congregacao,
            Long atividadeId,
            String atividade,
            TipoOcorrencia tipoOcorrencia,
            Integer quantidade
    ){
        this.ocorrenciaId = ocorrenciaId;
        this.congregacaoId = congregacaoId;
        this.congregacao = congregacao;
        this.atividadeId = atividadeId;
        this.atividade = atividade;
        this.tipoOcorrencia = tipoOcorrencia;
        this.quantidade = quantidade;
    }

    public static OcorrenciaResponseDTO fromOcorrencia(Ocorrencia o){
        if(o == null) return null;

        return new OcorrenciaResponseDTO(

                o.getOcorrenciaId(),
                o.getCongregacao() != null ? o.getCongregacao().getCongregacaoId() : null,
                o.getCongregacao() != null ? o.getCongregacao().getNome() : null,
                o.getAtividade() != null ? o.getAtividade().getAtividadeId() : null,
                o.getAtividade() != null ? o.getAtividade().getDescricao()  : null,

                o.getTipoOcorrencia(),
                o.getQuantidade()
        );
    }

    public Long getOcorrenciaId() {
        return ocorrenciaId;
    }

    public void setOcorrenciaId(Long ocorrenciaId) {
        this.ocorrenciaId = ocorrenciaId;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public String getCongregacao() {
        return congregacao;
    }

    public void setCongregacao(String congregacao) {
        this.congregacao = congregacao;
    }

    public Long getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Long atividadeId) {
        this.atividadeId = atividadeId;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
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
