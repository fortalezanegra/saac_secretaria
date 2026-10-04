package br.com.adbrascosmopolis.saac_secretaria.services;

import br.com.adbrascosmopolis.saac_secretaria.dto.endereco.EnderecoEditDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.endereco.EnderecoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.endereco.EnderecoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.models.Endereco;
import br.com.adbrascosmopolis.saac_secretaria.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
    private final CidadeRepository cidadeRepository;

    public EnderecoService(
            EnderecoRepository enderecoRepository,
            PessoaRepository pessoaRepository,
            CidadeRepository cidadeRepository
    ){
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
        this.cidadeRepository = cidadeRepository;
    }

    // Busca todas os endereços
    public List<EnderecoResponseDTO> getAll(){
        List<Endereco> endereco = enderecoRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));

        return endereco.stream()
                .map(e -> new EnderecoResponseDTO(
                        e.getEnderecoId(),
                        e.getPessoa() != null ? e.getPessoa().getNome() : null,
                        e.getLogradouro(),
                        e.getNumero(),
                        e.getComplemento(),
                        e.getBairro(),
                        e.getCep(),
                        e.getCidade() != null ? e.getCidade().getNome() : null,
                        e.getCidade().getCidadeId(),
                        e.getCidade().getEstado().getSigla()
                )).toList();
    }

    // Busca endereco por Id
    public Endereco getById(Integer id){
        Endereco endereco = enderecoRepository.findByEnderecoId(id);
        return endereco;
    }

    // Busca endereco por membroId
    public EnderecoResponseDTO getByMembro(Integer membroId){
        Endereco endereco = enderecoRepository.findByPessoaPessoaId(membroId);
        var end = EnderecoResponseDTO.fromEndereco(endereco);
        return end;
    }

    // Search By Descrição - Pesquisa avançada
    public List<Endereco> searchByExample(String descricao){

        var endereco = new Endereco();
        endereco.setLogradouro(descricao);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("enderecoId",
                        "pessoaId",
                        //"descricao",
                        "numero",
                        "complemento",
                        "bairro",
                        "cep",
                        "cidadeId")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Endereco> enderecoExample = Example.of(endereco, matcher);
        return enderecoRepository.findAll(enderecoExample);
    }

    //Busca endereco para Edição
    @Transactional
    public EnderecoEditDTO getEdit(int membroId){
        Endereco e = enderecoRepository.findByPessoaPessoaId(membroId);
        EnderecoEditDTO endereco = EnderecoEditDTO.fromEndereco(e);
        return endereco;
    }

    // Create
    @Transactional
    public EnderecoResponseDTO create(EnderecoRequestDTO dto){
        Endereco endereco = new Endereco();

        endereco.setLogradouro(dto.getLogradouro());
        endereco.setNumero(dto.getNumero());
        endereco.setComplemento(dto.getComplemento());       // Buscar entidades relacionadas pelo ID
        endereco.setBairro(dto.getBairro());
        endereco.setCep(dto.getCep());

        // Buscar entidades relacionadas pelo ID
        if(dto.getPessoaId() != null){
            endereco.setPessoa(
                    pessoaRepository.findById(dto.getPessoaId())
                            .orElseThrow(() -> new RuntimeException("Membro não encontrado"))
            );
        }

        if(dto.getCidadeId() != null){
            endereco.setCidade(
                    cidadeRepository.findById(dto.getCidadeId())
                            .orElseThrow(() -> new RuntimeException("Cidade não encontrada"))
            );
        }

        Endereco salvo = enderecoRepository.save(endereco);
        Endereco completo = enderecoRepository.findByIdFetchAll(salvo.getEnderecoId())
                .orElseThrow(()-> new RuntimeException("Endereço não encontrado"));

        return EnderecoResponseDTO.fromEndereco(completo);
    }

    // Update
    public Endereco update(EnderecoEditDTO dto){
        Endereco result = enderecoRepository.findById(dto.getEnderecoId())
                .orElseThrow(()-> new RuntimeException("Endereço não encontrado"));

        result.setLogradouro(dto.getLogradouro());
        result.setNumero(dto.getNumero());
        result.setComplemento(dto.getComplemento());  // Buscar entidades relacionadas pelo ID
        result.setBairro(dto.getBairro());
        result.setCep(dto.getCep());

        // Relacionamentos (CORRETO)
        if(dto.getMembroId() != null){
            result.setPessoa(
                    pessoaRepository.getReferenceById(dto.getMembroId())
            );
        }

        if(dto.getCidadeId() != null){
            result.setCidade(
                    cidadeRepository.getReferenceById(dto.getCidadeId())
            );
        }

        return enderecoRepository.save(result);
    }

    // Delete
    public void delete(Endereco endereco){
        enderecoRepository.delete(endereco);
    }

}
