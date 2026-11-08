package br.com.adbrascosmopolis.saac_secretaria.dto.evento;

public class EventoFilterDTO {
    private Long eventoId;
    private Integer congregacaoId;

    public EventoFilterDTO(){}

    public EventoFilterDTO(Long eventoId, Integer congregacaoId){
        this.eventoId = eventoId;
        this.congregacaoId = congregacaoId;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }
}
