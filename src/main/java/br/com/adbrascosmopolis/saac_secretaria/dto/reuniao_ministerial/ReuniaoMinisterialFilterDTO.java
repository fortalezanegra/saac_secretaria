package br.com.adbrascosmopolis.saac_secretaria.dto.reuniao_ministerial;

public class ReuniaoMinisterialFilterDTO {

    private Long reuniaoMinisterialId;

    public ReuniaoMinisterialFilterDTO(Long reuniaoMinisterialId){
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }
}
