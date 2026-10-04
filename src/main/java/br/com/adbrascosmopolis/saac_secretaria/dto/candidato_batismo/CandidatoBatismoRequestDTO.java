package br.com.adbrascosmopolis.saac_secretaria.dto.candidato_batismo;

import br.com.adbrascosmopolis.saac_secretaria.models.*;

public class CandidatoBatismoRequestDTO {

    private Long batismoId;
    private Integer congregacaoId;
    private Long pessoaId;
    private Integer situacaoId;

    public CandidatoBatismoRequestDTO(
            Long batismoId,
            Integer congregacaoId,
            Long pessoaId,
            Integer situacaoId
    ){
        this.batismoId = batismoId;
        this.congregacaoId = congregacaoId;
        this.pessoaId = pessoaId;
        this.situacaoId = situacaoId;
    }

    public CandidatoBatismo mapToCandidatoBatismo(){
        CandidatoBatismo candidato = new CandidatoBatismo();

        //Relacionamentos
        if(this.batismoId != null){
            Batismo batismo = new Batismo();
            batismo.setBatismoId(this.batismoId);
            candidato.setBatismo(batismo);
        }

        if(this.congregacaoId != null){
            Congregacao congregacao = new Congregacao();
            congregacao.setCongregacaoId(this.congregacaoId);
            candidato.setCongregacao(congregacao);
        }

        if(this.pessoaId != null){
            Pessoa pessoa = new Pessoa();
            pessoa.setPessoaId(this.pessoaId);
            candidato.setPessoa(pessoa);
        }

        if(this.situacaoId != null){
            Situacao situacao = new Situacao();
            situacao.setSituacaoId(this.situacaoId);
            candidato.setSituacao(situacao);
        }
        return candidato;
    }

    public Long getBatismoId() {
        return batismoId;
    }

    public void setBatismoId(Long batismoId) {
        this.batismoId = batismoId;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Integer getSituacaoId() {
        return situacaoId;
    }

    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
    }
}
