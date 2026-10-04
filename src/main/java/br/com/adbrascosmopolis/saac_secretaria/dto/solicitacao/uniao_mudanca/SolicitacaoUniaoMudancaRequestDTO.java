package br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao_mudanca;

import br.com.adbrascosmopolis.saac_secretaria.models.*;

public class SolicitacaoUniaoMudancaRequestDTO {

    private Long reuniaoMinisterialId;
    private Integer congregacaoSolicitanteId;
    private Integer tipoSolicitacaoId;
    private Long pessoaId;
    private Integer igrejaOrigemId;
    private Integer cargoIgrejaOrigemId;
    private Integer cargoRecebidoId;
    private String historico;
    private Integer situacaoId;

    public SolicitacaoUniaoMudancaRequestDTO(
            Long reuniaoMinisterialId,
            Integer congregacaoSolicitanteId,
            Integer tipoSolicitacaoId,
            Long pessoaId,
            Integer igrejaOrigemId,
            Integer cargoIgrejaOrigemId,
            Integer cargoRecebidoId,
            String historico,
            Integer situacaoId
    ){
        this.reuniaoMinisterialId = reuniaoMinisterialId;
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
        this.tipoSolicitacaoId = tipoSolicitacaoId;
        this.pessoaId = pessoaId;
        this.igrejaOrigemId = igrejaOrigemId;
        this.cargoIgrejaOrigemId = cargoIgrejaOrigemId;
        this.cargoRecebidoId = cargoRecebidoId;
        this.historico = historico;
        this.situacaoId = situacaoId;
    }

    public Solicitacao mapToSolicitacao(){
        Solicitacao solicitacao = new Solicitacao();

        solicitacao.setHistorico(this.historico);

        /* ********************* */
        /* ** Relacionamentos ** */
        /* ********************* */

        //ReuniaoMinisterial
        if(this.reuniaoMinisterialId != null){
            ReuniaoMinisterial reuniao = new ReuniaoMinisterial();
            reuniao.setReuniaoMinisterialId(this.reuniaoMinisterialId);
            solicitacao.setReuniaoMinisterial(reuniao);
        }

        //CongregacaoSolicitante
        if(this.congregacaoSolicitanteId != null){
            Congregacao solicitante = new Congregacao();
            solicitante.setCongregacaoId(this.congregacaoSolicitanteId);
            solicitacao.setCongregacaoSolicitante(solicitante);
        }

        //TipoSolicitacao
        if(this.tipoSolicitacaoId != null){
            TipoSolicitacao tipo = new TipoSolicitacao();
            tipo.setTipoSolicitacaoId(this.tipoSolicitacaoId);
            solicitacao.setTipoSolicitacao(tipo);
        }

        //Pessoa
        if(this.pessoaId != null ){
            Pessoa pessoa = new Pessoa();
            pessoa.setPessoaId(this.pessoaId);
            solicitacao.setPessoa(pessoa);
        }

        //Igreja Origem
        if(this.igrejaOrigemId != null){
            IgrejaOrigem igreja = new IgrejaOrigem();
            igreja.setIgrejaOrigemId(this.igrejaOrigemId);
            solicitacao.setIgrejaOrigem(igreja);
        }

        //Cargo Igreja Origem
        if(this.cargoIgrejaOrigemId != null){
            CargoMinisterial cargoOrigem = new CargoMinisterial();
            cargoOrigem.setCargoMinisterialId(this.cargoIgrejaOrigemId);
            solicitacao.setCargoIgrejaOrigem(cargoOrigem);
        }

        //Cargo Recebido
        if(this.cargoRecebidoId != null){
            CargoMinisterial cargoRecebido = new CargoMinisterial();
            cargoRecebido.setCargoMinisterialId(this.cargoIgrejaOrigemId);
            solicitacao.setCargoRecebido(cargoRecebido);
        }

        return solicitacao;
    }

    public Long getReuniaoMinisterialId() {
        return reuniaoMinisterialId;
    }

    public void setReuniaoMinisterialId(Long reuniaoMinisterialId) {
        this.reuniaoMinisterialId = reuniaoMinisterialId;
    }

    public Integer getCongregacaoSolicitanteId() {
        return congregacaoSolicitanteId;
    }

    public void setCongregacaoSolicitanteId(Integer congregacaoSolicitanteId) {
        this.congregacaoSolicitanteId = congregacaoSolicitanteId;
    }

    public Integer getTipoSolicitacaoId() {
        return tipoSolicitacaoId;
    }

    public void setTipoSolicitacaoId(Integer tipoSolicitacaoId) {
        this.tipoSolicitacaoId = tipoSolicitacaoId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Integer getIgrejaOrigemId() {
        return igrejaOrigemId;
    }

    public void setIgrejaOrigemId(Integer igrejaOrigemId) {
        this.igrejaOrigemId = igrejaOrigemId;
    }

    public Integer getCargoIgrejaOrigemId() {
        return cargoIgrejaOrigemId;
    }

    public void setCargoIgrejaOrigemId(Integer cargoIgrejaOrigemId) {
        this.cargoIgrejaOrigemId = cargoIgrejaOrigemId;
    }

    public Integer getCargoRecebidoId() {
        return cargoRecebidoId;
    }

    public void setCargoRecebidoId(Integer cargoRecebidoId) {
        this.cargoRecebidoId = cargoRecebidoId;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Integer getSituacaoId() {
        return situacaoId;
    }

    public void setSituacaoId(Integer situacaoId) {
        this.situacaoId = situacaoId;
    }
}
