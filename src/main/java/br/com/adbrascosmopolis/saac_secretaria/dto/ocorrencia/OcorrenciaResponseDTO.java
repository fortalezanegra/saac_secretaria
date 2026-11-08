package br.com.adbrascosmopolis.saac_secretaria.dto.ocorrencia;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoOcorrencia;
import br.com.adbrascosmopolis.saac_secretaria.models.Ocorrencia;

public class OcorrenciaResponseDTO {

    private Long ocorrenciaId;
    private Integer congregacaoId;
    private String congregacao;
    private Long eventoId;
    private String evento;
    private TipoOcorrencia tipoOcorrencia;
    private Integer quantidade;

    public OcorrenciaResponseDTO(
            Long ocorrenciaId,
            Integer congregacaoId,
            String congregacao,
            Long eventoId,
            String evento,
            TipoOcorrencia tipoOcorrencia,
            Integer quantidade
    ){
        this.ocorrenciaId = ocorrenciaId;
        this.congregacaoId = congregacaoId;
        this.congregacao = congregacao;
        this.eventoId = eventoId;
        this.evento = evento;
        this.tipoOcorrencia = tipoOcorrencia;
        this.quantidade = quantidade;
    }

    public static OcorrenciaResponseDTO fromOcorrencia(Ocorrencia o){
        if(o == null) return null;

        return new OcorrenciaResponseDTO(

                o.getOcorrenciaId(),
                o.getCongregacao() != null ? o.getCongregacao().getCongregacaoId() : null,
                o.getCongregacao() != null ? o.getCongregacao().getNome() : null,
                o.getEvento() != null ? o.getEvento().getEventoId() : null,
                o.getEvento() != null ? o.getEvento().getDescricao()  : null,

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

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
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
