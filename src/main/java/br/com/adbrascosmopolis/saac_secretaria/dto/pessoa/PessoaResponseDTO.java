package br.com.adbrascosmopolis.saac_secretaria.dto.pessoa;

import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;

import java.time.LocalDate;

public class PessoaResponseDTO {

    private Long pessoaId;
    private String tipoVinculo;
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String rg;
    private String cpf;
    private String formacao;
    private String profissao;
    private String pai;
    private String mae;
    private String estadoCivil;
    private String conjuge;
    private String certidao;
    private String tipoSanguineo;
    private String congregacao;
    private String cargoMinisterial;
    private LocalDate dataBatismo;
    private String situacao;
    private String foto;
    private LocalDate dataConversao;

    public PessoaResponseDTO(
            Long pessoaId,
            String tipoVinculo,
            String nome,
            String sexo,
            LocalDate dataNascimento,
            String telefone,
            String email,
            String rg,
            String cpf,
            String formacao,
            String profissao,
            String pai,
            String mae,
            String estadoCivil,
            String conjuge,
            String certidao,
            String tipoSanguineo,
            String congregacao,
            String cargoMinisterial,
            LocalDate dataBatismo,
            String situacao,
            String foto,
            LocalDate dataConversao)
    {
        this.pessoaId = pessoaId;
        this.tipoVinculo = tipoVinculo;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.formacao = formacao;
        this.profissao = profissao;
        this.pai = pai;
        this.mae = mae;
        this.estadoCivil = estadoCivil;
        this.conjuge = conjuge;
        this.certidao = certidao;
        this.tipoSanguineo = tipoSanguineo;
        this.congregacao = congregacao;
        this.cargoMinisterial = cargoMinisterial;
        this.dataBatismo = dataBatismo;
        this.situacao = situacao;
        this.foto = foto;
        this.dataConversao = dataConversao;
    }

    public static PessoaResponseDTO fromPessoa(Pessoa p) {
        if (p == null) return null;

        String fotoUrl = null;

        return new PessoaResponseDTO(
                p.getPessoaId(),
                p.getTipoVinculo() != null ? p.getTipoVinculo().getDescricao() : null,
                p.getNome(),
                p.getSexo() != null ? p.getSexo().getDescricao() : null,
                p.getDataNascimento(),
                p.getTelefone(),
                p.getEmail(),
                p.getRg(),
                p.getCpf(),
                p.getFormacao() != null ? p.getFormacao().getDescricao() : null,
                p.getProfissao() != null ? p.getProfissao().getDescricao() : null,
                p.getPai(),
                p.getMae(),
                p.getEstadoCivil() != null ? p.getEstadoCivil().getDescricao() : null,
                p.getConjuge(),
                p.getCertidao(),
                p.getTipoSanguineo(),
                p.getCongregacao() != null ? p.getCongregacao().getNome() : null,
                p.getCargoMinisterial() != null ? p.getCargoMinisterial().getDescricao() : null,
                p.getDataBatismo(),
                p.getSituacao() != null ? p.getSituacao().getDescricao() : null,
                p.getFoto(),
                p.getDataConversao()
        );
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(String tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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

    public String getCongregacao() {
        return congregacao;
    }

    public void setCongregacao(String congregacao) {
        this.congregacao = congregacao;
    }

    public String getCargoMinisterial() {
        return cargoMinisterial;
    }

    public void setCargoMinisterial(String cargoMinisterial) {
        this.cargoMinisterial = cargoMinisterial;
    }

    public LocalDate getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDate dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
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
