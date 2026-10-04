package br.com.adbrascosmopolis.saac_secretaria.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // importante: usa AUTO_INCREMENT do MySQL
    @Column(name = "pessoaId")
    private Long pessoaId;

    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER se quiser carregar junto
    @JoinColumn(name = "tipoVinculoId", referencedColumnName = "tipoVinculoId")
    private TipoVinculo tipoVinculo;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER se quiser carregar junto
    @JoinColumn(name = "sexoId", referencedColumnName = "sexoId")
    private Sexo sexo;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER se quiser carregar junto
    @JoinColumn(name = "formacaoId", referencedColumnName = "formacaoId")
    private Formacao formacao;

    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER se quiser carregar junto
    @JoinColumn(name = "profissaoId", referencedColumnName = "profissaoId")
    private Profissao profissao;

    @Column(name = "pai")
    private String pai;

    @Column(name = "mae")
    private String mae;

    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER se quiser carregar junto
    @JoinColumn(name = "estadoCivilId", referencedColumnName = "estadoCivilId")
    private EstadoCivil estadoCivil;

    @Column(name = "conjuge")
    private String conjuge;

    @Column(name = "certidao")
    private String certidao;

    @Column(name = "tipoSanguineo")
    private String tipoSanguineo;

    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER se quiser carregar junto
    @JoinColumn(name = "congregacaoId", referencedColumnName = "congregacaoId")
    private Congregacao congregacao;

    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER se quiser carregar junto
    @JoinColumn(name = "cargoMinisterialId", referencedColumnName = "cargoMinisterialId")
    private CargoMinisterial cargoMinisterial;

    @Column(name = "dataBatismo")
    private LocalDate dataBatismo;

    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER se quiser carregar junto
    @JoinColumn(name = "situacaoId", referencedColumnName = "situacaoId")
    private Situacao situacao;

    @Column(name = "foto")
    private String foto;

    @Column(name = "dataConversao")
    private LocalDate dataConversao;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;

    @Column(name = "modifiedBy")
    private Integer modifiedBy;

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

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
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

    public Congregacao getCongregacao() {
        return congregacao;
    }

    public void setCongregacao(Congregacao congregacao) {
        this.congregacao = congregacao;
    }

    public CargoMinisterial getCargoMinisterial() {
        return cargoMinisterial;
    }

    public void setCargoMinisterial(CargoMinisterial cargoMinisterial) {
        this.cargoMinisterial = cargoMinisterial;
    }

    public LocalDate getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDate dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
