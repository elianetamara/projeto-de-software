package services;

import dto.response.PessoaResponseDTO;
import dto.request.PessoaRequestDTO;
import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaService {

    private final PessoaRepository repository;
    private EnderecoService enderecoService;

    public PessoaService() {
        this.repository = new PessoaRepository();
        this.enderecoService = new EnderecoService();
    }

    public PessoaResponseDTO createPessoa(PessoaRequestDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO);
        boolean adicionado = this.repository.createPessoa(pessoa);
        return adicionado ? new PessoaResponseDTO(pessoa) : null;
    }

    public PessoaResponseDTO getPessoa(String cpf){
        Pessoa pessoa = this.repository.getPessoa(cpf);
        if(pessoa != null){
            return new PessoaResponseDTO(pessoa);
        }else {
            return null;
        }
    }

    public PessoaResponseDTO updatePessoa(PessoaRequestDTO pessoaDTO){
        Pessoa novaPessoa = new Pessoa(pessoaDTO);
        boolean atualizado = this.repository.updatePessoa(pessoaDTO.cpf(), novaPessoa);
        return atualizado ? new PessoaResponseDTO(novaPessoa) : null;
    }

    public PessoaResponseDTO deletePessoa(String cpf){
        Pessoa removida = this.repository.deletePessoa(cpf);
        return removida != null ? new PessoaResponseDTO(removida) : null;
    }

//    public boolean addNewEnderecoInPessoa(String cpf, String rua){
//        Endereco endereco = enderecoRepository.getEndereco(rua);
//        return this.repository.addNewEnderecoInPessoa(cpf, endereco);
//    }
}
