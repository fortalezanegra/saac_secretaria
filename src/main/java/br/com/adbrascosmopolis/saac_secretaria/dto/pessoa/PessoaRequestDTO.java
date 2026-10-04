package br.com.adbrascosmopolis.saac_secretaria.dto.pessoa;

import br.com.adbrascosmopolis.saac_secretaria.models.*;

import java.time.LocalDate;

public class PessoaRequestDTO {

    private Integer tipoVinculoId;
    private String nome;
    private Integer sexoId;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String rg;
    private String cpf;
    private Integer formacaoId;
    private Integer profissaoId;
    private String pai;
    private String mae;
    private Integer estadoCivilId;
    private String conjuge;
    private String certidao;
    private String tipoSanguineo;
    private Integer congregacaoId;
    private Integer cargoMinisterialId;
    private LocalDate dataBatismo;
    private Integer situacaoId;
    private String foto;
    private LocalDate dataConversao;

    public PessoaRequestDTO(
            Integer tipoVinculoId,
            String nome,
            Integer sexoId,
            LocalDate dataNascimento,
            String telefone,
            String email,
            String rg,
            String cpf,
            Integer formacaoId,
            Integer profissaoId,
            String pai,
            String mae,
            Integer estadoCivilId,
            String conjuge,
            String certidao,
            String tipoSanguineo,
            Integer congregacaoId,
            Integer cargoMinisterialId,
            LocalDate dataBatismo,
            String foto,
            LocalDate dataConversao){

        this.tipoVinculoId = tipoVinculoId;
        this.nome = nome;
        this.sexoId = sexoId;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.formacaoId = formacaoId;
        this.profissaoId = profissaoId;
        this.pai = pai;
        this.mae = mae;
        this.estadoCivilId = estadoCivilId;
        this.conjuge = conjuge;
        this.certidao = certidao;
        this.tipoSanguineo = tipoSanguineo;
        this.congregacaoId = congregacaoId;
        this.cargoMinisterialId = cargoMinisterialId;
        this.dataBatismo = dataBatismo;
        this.situacaoId = situacaoId;
        this.foto = foto;
        this.dataConversao = dataConversao;
    }

    public Pessoa mapToPessoa() {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(this.nome);
        pessoa.setDataNascimento(this.dataNascimento);
        pessoa.setTelefone(this.telefone);
        pessoa.setEmail(this.email);
        pessoa.setRg(this.rg);
        pessoa.setCpf(this.cpf);
        pessoa.setPai(this.pai);
        pessoa.setMae(this.mae);
        pessoa.setConjuge(this.conjuge);
        pessoa.setCertidao(this.certidao);
        pessoa.setTipoSanguineo(this.tipoSanguineo);
        pessoa.setDataBatismo(this.dataBatismo);
        pessoa.setFoto(this.foto);
        pessoa.setDataConversao(this.dataConversao);

        // Relacionamentos
        if (this.tipoVinculoId != null) {
            TipoVinculo tipoVinculo = new TipoVinculo();
            tipoVinculo.setTipoVinculoId(this.tipoVinculoId);
            pessoa.setTipoVinculo(tipoVinculo);
        }

        if (this.sexoId != null) {
            Sexo sexo = new Sexo();
            sexo.setSexoId(this.sexoId);
            pessoa.setSexo(sexo);
        }

        if (this.formacaoId != null) {
            Formacao formacao = new Formacao();
            formacao.setFormacaoId(this.formacaoId);
            pessoa.setFormacao(formacao);
        }

        if (this.profissaoId != null) {
            Profissao profissao = new Profissao();
            profissao.setProfissaoId(this.profissaoId);
            pessoa.setProfissao(profissao);
        }

        if (this.estadoCivilId != null) {
            EstadoCivil estadoCivil = new EstadoCivil();
            estadoCivil.setEstadoCivilId(this.estadoCivilId);
            pessoa.setEstadoCivil(estadoCivil);
        }

        if (this.congregacaoId != null) {
            Congregacao congregacao = new Congregacao();
            congregacao.setCongregacaoId(this.congregacaoId);
            pessoa.setCongregacao(congregacao);
        }

        if (this.cargoMinisterialId != null) {
            CargoMinisterial cargo = new CargoMinisterial();
            cargo.setCargoMinisterialId(this.cargoMinisterialId);
            pessoa.setCargoMinisterial(cargo);
        }

        if (this.situacaoId != null) {
            Situacao situacao = new Situacao();
            situacao.setSituacaoId(this.situacaoId);
            pessoa.setSituacao(situacao);
        }

        return pessoa;
    }

    public Integer getTipoVinculoId() {
        return tipoVinculoId;
    }

    public void setTipoVinculoId(Integer tipoVinculoId) {
        this.tipoVinculoId = tipoVinculoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSexoId() {
        return sexoId;
    }

    public void setSexoId(Integer sexoId) {
        this.sexoId = sexoId;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getFormacaoId() {
        return formacaoId;
    }

    public void setFormacaoId(Integer formacaoId) {
        this.formacaoId = formacaoId;
    }

    public Integer getProfissaoId() {
        return profissaoId;
    }

    public void setProfissaoId(Integer profissaoId) {
        this.profissaoId = profissaoId;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public Integer getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(Integer estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public String getCertidao() {
        return certidao;
    }

    public void setCertidao(String certidao) {
        this.certidao = certidao;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Integer getCongregacaoId() {
        return congregacaoId;
    }

    public void setCongregacaoId(Integer congregacaoId) {
        this.congregacaoId = congregacaoId;
    }

    public Integer getCargoMinisterialId() {
        return cargoMinisterialId;
    }

    public void setCargoMinisterialId(Integer cargoMinisterialId) {
        this.cargoMinisterialId = cargoMinisterialId;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public LocalDate getDataConversao() {
        return dataConversao;
    }

    public void setDataConversao(LocalDate dataConversao) {
        this.dataConversao = dataConversao;
    }
}
