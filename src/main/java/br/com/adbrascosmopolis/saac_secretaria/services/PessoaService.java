package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaDropdownDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.pessoa.PessoaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Historico;
import br.com.adbrascosmopolis.saac_secretaria.models.Pessoa;
import br.com.adbrascosmopolis.saac_secretaria.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private final TipoVinculoRepository tipoVinculoRepository;
    @Autowired
    private final PessoaRepository pessoaRepository;
    @Autowired
    private final CongregacaoRepository congregacaoRepository;
    @Autowired
    private final CargoMinisterialRepository cargoMinisterialRepository;
    @Autowired
    private final EstadoCivilRepository estadoCivilRepository;
    @Autowired
    private final FormacaoRepository formacaoRepository;
    @Autowired
    private final ProfissaoRepository profissaoRepository;
    @Autowired
    private final SituacaoRepository situacaoRepository;
    @Autowired
    private final SexoRepository sexoRepository;
    @Autowired
    private final HistoricoRepository historicoRepository;

    public PessoaService(
            TipoVinculoRepository tipoVinculoRepository,
            PessoaRepository pessoaRepository,
            CongregacaoRepository congregacaoRepository,
            CargoMinisterialRepository cargoMinisterialRepository,
            EstadoCivilRepository estadoCivilRepository,
            FormacaoRepository formacaoRepository,
            ProfissaoRepository profissaoRepository,
            SituacaoRepository situacaoRepository,
            SexoRepository sexoRepository,
            HistoricoRepository historicoRepository){
        this.tipoVinculoRepository = tipoVinculoRepository;
        this.pessoaRepository = pessoaRepository;
        this.congregacaoRepository = congregacaoRepository;
        this.cargoMinisterialRepository = cargoMinisterialRepository;
        this.estadoCivilRepository = estadoCivilRepository;
        this.formacaoRepository = formacaoRepository;
        this.profissaoRepository = profissaoRepository;
        this.situacaoRepository = situacaoRepository;
        this.sexoRepository = sexoRepository;
        this.historicoRepository = historicoRepository;
    }

    // Dropdown/ComboBox By Congregacao And Situacao
    public List<PessoaDropdownDTO> dropdownByCongregacaoAndSituacao(PessoaRequestDTO dto){
        List<Pessoa> pessoa = pessoaRepository.listarPessoasPorCongregacaoESituacao(dto.getCongregacaoId(), dto.getSituacaoId());

        return pessoa.stream()
                .map(p -> new PessoaDropdownDTO(
                        p.getPessoaId(),
                        p.getNome()
                ))
                .collect(Collectors.toList());
    }

    // Dropdown/ComboBox
    public List<PessoaDropdownDTO> dropdown() {
        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream()
                .map(p -> new PessoaDropdownDTO(
                        p.getPessoaId(),
                        p.getNome()
                ))
                .collect(Collectors.toList());
    }

    // Get All Not Deleted
    public List<PessoaResponseDTO>  getAllNotDeleted(){
        List<Pessoa> pessoas = pessoaRepository.findByDeletedAtIsNull();
        return pessoas.stream()
                .map(p -> new PessoaResponseDTO(
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
                )).toList();
    }

    // Get All
    public List<PessoaResponseDTO>  getAll(){
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream()
                .map(p -> new PessoaResponseDTO(
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
                )).toList();
    }

    // List By Vinculo and Situacao
    public List<PessoaResponseDTO>  listPessoaByVinculoAndSituacao(String vinculo, String situacao){
        List<Pessoa> pessoas = pessoaRepository.findPessoaByVinculoAndSituacao(vinculo, situacao);
        return pessoas.stream()
                .map(p -> new PessoaResponseDTO(
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
                )).toList();
    }

    // List By Congregação
    public List<PessoaResponseDTO>  listByCongregacao(Integer congregacaoId){

        List<Pessoa> pessoas = pessoaRepository.findByCongregacaoCongregacaoId(congregacaoId);

        return pessoas.stream()
                .map(p -> new PessoaResponseDTO(
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
                )).toList();
    }

    /* List By ID */
    public Pessoa listById(Long id){
        Pessoa pessoa = pessoaRepository.findByPessoaId(id);
        return pessoa;
    }

    /* Search By Name */
    public List<PessoaResponseDTO>  listByPessoas(String name){

        List<Pessoa> pessoas = pessoaRepository.findByNome(name);

        return pessoas.stream()
                .map(p -> new PessoaResponseDTO(
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
                )).toList();
    }

    /* Search By Name - Search Advanced */
    public List<Pessoa> searchByPessoa(String nome){

        var pessoa = new Pessoa();

        pessoa.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths(
                        "pessoaId",
                        "tipoVinculoId",
                        //"nome",
                        "sexoId",
                        "dataNascimento",
                        "telefone",
                        "email",
                        "rg",
                        "cpf",
                        "formacaoId",
                        "profissaoId",
                        "pai",
                        "mae",
                        "estadoCivilId",
                        "conjuge",
                        "certidao",
                        "tipoSanguineo",
                        "congregacaoId",
                        "cargoMinisterialId",
                        "dataBatismo",
                        "situacaoId",
                        "foto")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Pessoa> membroExample = Example.of(pessoa, matcher);

        return pessoaRepository.findAll(membroExample);
    }

    /*Search By Name Paged - Search Advanced */
    public Page<Pessoa> search(PessoaRequestDTO request, Pageable pageable) {

        List<Specification<Pessoa>> specs = new ArrayList<>();

        // 🔎 nome (principal)
        if (request.getNome() != null && !request.getNome().isBlank()) {
            specs.add((root, query, cb) ->
                    cb.like(
                            cb.lower(root.get("nome")),
                            "%" + request.getNome().toLowerCase() + "%"
                    ));
        }

        // 🔎 vínculo por ID (melhor que string)
        if (request.getTipoVinculoId() != null) {
            specs.add((root, query, cb) ->
                    cb.equal(
                            root.get("tipoVinculo").get("tipoVinculoId"),
                            request.getTipoVinculoId()
                    ));
        }

        // 🔎 situação por ID
        if (request.getSituacaoId() != null) {
            specs.add((root, query, cb) ->
                    cb.equal(
                            root.get("situacao").get("situacaoId"),
                            request.getSituacaoId()
                    ));
        }

        Specification<Pessoa> spec = Specification.allOf(specs);

        return pessoaRepository.findAll(spec, pageable);
    }

    /* Create */
    @Transactional
    public PessoaResponseDTO create(PessoaRequestDTO dto) {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(dto.getNome());
        pessoa.setDataNascimento(dto.getDataNascimento());
        pessoa.setTelefone(dto.getTelefone());
        pessoa.setEmail(dto.getEmail());
        pessoa.setRg(dto.getRg());
        pessoa.setCpf(dto.getCpf());
        pessoa.setPai(dto.getPai());
        pessoa.setMae(dto.getMae());
        pessoa.setConjuge(dto.getConjuge());
        pessoa.setCertidao(dto.getCertidao());
        pessoa.setTipoSanguineo(dto.getTipoSanguineo());
        pessoa.setDataBatismo(dto.getDataBatismo());
        pessoa.setFoto(dto.getFoto());

        // Buscar entidades relacionadas pelo ID
        if (dto.getTipoVinculoId() != null) {
            pessoa.setTipoVinculo(
                    tipoVinculoRepository.findById(dto.getTipoVinculoId())
                            .orElseThrow(() -> new RuntimeException("Tipo Vinculo não encontrado"))
            );
        }

        if (dto.getCongregacaoId() != null) {
            pessoa.setCongregacao(
                    congregacaoRepository.findById(dto.getCongregacaoId())
                            .orElseThrow(() -> new RuntimeException("Congregacao não encontrada"))
            );
        }

        if (dto.getCargoMinisterialId() != null) {
            pessoa.setCargoMinisterial(
                    cargoMinisterialRepository.findById(dto.getCargoMinisterialId())
                            .orElseThrow(() -> new RuntimeException("Cargo Ministerial não encontrado"))
            );
        }

        if (dto.getSexoId() != null) {
            pessoa.setSexo(
                    sexoRepository.findById(dto.getSexoId())
                            .orElseThrow(() -> new RuntimeException("Sexo não encontrado"))
            );
        }

        if (dto.getEstadoCivilId() != null) {
            pessoa.setEstadoCivil(
                    estadoCivilRepository.findById(dto.getEstadoCivilId())
                            .orElseThrow(() -> new RuntimeException("Estado Civil não encontrado"))
            );
        }

        if (dto.getFormacaoId() != null) {
            pessoa.setFormacao(
                    formacaoRepository.findById(dto.getFormacaoId())
                            .orElseThrow(() -> new RuntimeException("Formacao não encontrada"))
            );
        }

        if (dto.getProfissaoId() != null) {
            pessoa.setProfissao(
                    profissaoRepository.findById(dto.getProfissaoId())
                            .orElseThrow(() -> new RuntimeException("Profissao não encontrada"))
            );
        }

        if (dto.getSituacaoId() != null) {
            pessoa.setSituacao(
                    situacaoRepository.findById(dto.getSituacaoId())
                            .orElseThrow(() -> new RuntimeException("Situacao não encontrada"))
            );
        }

        Pessoa salvo = pessoaRepository.save(pessoa);

        Pessoa completo = pessoaRepository.findByIdFetchAll(salvo.getPessoaId())
                .orElseThrow(() -> new RuntimeException("Membro não encontrado"));

        //Criando Historico de Pessoa
        if(completo.getPessoaId() != null){
            Historico historico = new Historico();
            historico.setPessoa(completo);
            historicoRepository.save(historico);
        }

        return PessoaResponseDTO.fromPessoa(completo);
    }

    /* Update */
    @Transactional
    public PessoaResponseDTO update(PessoaEditDTO dto) {

        if (dto.getPessoaId() == null) {
            throw new RuntimeException("PessoaId não pode ser null");
        }

        Pessoa result = pessoaRepository.findById(dto.getPessoaId())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        // Campos simples
        result.setNome(dto.getNome());
        result.setDataNascimento(dto.getDataNascimento());
        result.setTelefone(dto.getTelefone());
        result.setEmail(dto.getEmail());
        result.setRg(dto.getRg());
        result.setCpf(dto.getCpf());
        result.setPai(dto.getPai());
        result.setMae(dto.getMae());
        result.setConjuge(dto.getConjuge());
        result.setCertidao(dto.getCertidao());
        result.setTipoSanguineo(dto.getTipoSanguineo());
        result.setDataBatismo(dto.getDataBatismo());
        result.setMae(dto.getMae());

        if(dto.getFoto() != null && !dto.getFoto().trim().isEmpty()){
            result.setFoto(dto.getFoto());
        }

        // Relacionamentos (CORRETO)
        if (dto.getTipoVinculoId() != null)
            result.setTipoVinculo(
                    tipoVinculoRepository.getReferenceById(dto.getTipoVinculoId())
            );

        if (dto.getSexoId() != null)
            result.setSexo(
                    sexoRepository.getReferenceById(dto.getSexoId())
            );

        if (dto.getFormacaoId() != null)
            result.setFormacao(
                    formacaoRepository.getReferenceById(dto.getFormacaoId())
            );

        if (dto.getProfissaoId() != null)
            result.setProfissao(
                    profissaoRepository.getReferenceById(dto.getProfissaoId())
            );

        if (dto.getEstadoCivilId() != null)
            result.setEstadoCivil(
                    estadoCivilRepository.getReferenceById(dto.getEstadoCivilId())
            );

        if (dto.getCongregacaoId() != null)
            result.setCongregacao(
                    congregacaoRepository.getReferenceById(dto.getCongregacaoId())
            );

        if (dto.getCargoMinisterialId() != null)
            result.setCargoMinisterial(
                    cargoMinisterialRepository.getReferenceById(dto.getCargoMinisterialId())
            );

        if (dto.getSituacaoId() != null)
            result.setSituacao(
                    situacaoRepository.getReferenceById(dto.getSituacaoId())
            );

        var pessoaAtualizada =  pessoaRepository.save(result);

        return PessoaResponseDTO.fromPessoa(pessoaAtualizada);

    }

    /* Delete */
    @Transactional
    public PessoaResponseDTO delete(PessoaEditDTO dto){

        if (dto.getPessoaId() == null) {
            throw new RuntimeException("PessoaId não pode ser null");
        }

        Pessoa result = pessoaRepository.findById(dto.getPessoaId())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        // Campos simples
        result.setDeletedAt(LocalDateTime.now());


        var pessoaAtualizada =  pessoaRepository.save(result);

        return PessoaResponseDTO.fromPessoa(pessoaAtualizada);
    }

    /* Atualizar Foto Membro */
    @Transactional
    public void atualizarFoto(Long pessoaId, String caminhoFoto) {

        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new IllegalArgumentException("Membro não encontrado."));

        pessoa.setFoto(caminhoFoto); // Atualiza campo na entity

        // NÃO precisa salvar, JPA persiste automaticamente por causa do @Transactional
    }

}
