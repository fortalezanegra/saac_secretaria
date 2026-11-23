package br.com.adbrascosmopolis.saac_secretaria.dto.pessoa;

import br.com.adbrascosmopolis.saac_secretaria.enumeration.EstadoCivil;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.Sexo;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.TipoVinculo;
import br.com.adbrascosmopolis.saac_secretaria.enumeration.situacoes.SituacaoPessoa;
import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PessoaEditDTO {

    private Long pessoaId;
    private TipoVinculo tipoVinculo;
    private String nome;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String rg;
    private String cpf;
    private Integer formacaoId;
    private Integer profissaoId;
    private String pai;
    private String mae;
    private EstadoCivil estadoCivil;
    private String conjuge;
    private String certidao;
    private String tipoSanguineo;
    private Integer congregacaoId;
    private Integer cargoMinisterialId;
    private LocalDate dataBatismo;
    private String foto;
    private LocalDate dataConversao;
    private SituacaoPessoa situacao;
    private LocalDateTime deletedAt;

    // Cria DTO a partir do Membro
    public static PessoaEditDTO fromPessoa(Pessoa p) {
        PessoaEditDTO dto = new PessoaEditDTO();

        dto.pessoaId = p.getPessoaId();
        dto.tipoVinculo = p.getTipoVinculo();
        dto.nome = p.getNome();
        dto.sexo = p.getSexo();
        dto.dataNascimento = p.getDataNascimento();
        dto.telefone = p.getTelefone();
        dto.email = p.getEmail();
        dto.rg = p.getRg();
        dto.cpf = p.getCpf();
        dto.formacaoId = p.getFormacao() != null ? p.getFormacao().getFormacaoId() : null;
        dto.profissaoId = p.getProfissao() != null ? p.getProfissao().getProfissaoId() : null;
        dto.pai = p.getPai();
        dto.mae = p.getMae();
        dto.estadoCivil = p.getEstadoCivil();
        dto.conjuge = p.getConjuge();
        dto.certidao = p.getCertidao();
        dto.tipoSanguineo = p.getTipoSanguineo();
        dto.congregacaoId = p.getCongregacao() != null ? p.getCongregacao().getCongregacaoId() : null;
        dto.cargoMinisterialId = p.getCargoMinisterial() != null ? p.getCargoMinisterial().getCargoMinisterialId() : null;
        dto.dataBatismo = p.getDataBatismo();
        dto.foto = p.getFoto();
        dto.dataConversao = p.getDataConversao();
        dto.situacao = p.getSituacao();
        dto.deletedAt = p.getDeletedAt();
        return dto;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public TipoVinculo getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(TipoVinculo tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
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

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
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

    public SituacaoPessoa getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPessoa situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
