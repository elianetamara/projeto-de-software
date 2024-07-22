package services;

import dto.response.PessoaResponseDTO;
import dto.request.PessoaRequestDTO;
import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService() {
        this.repository = new PessoaRepository();
    }

    public PessoaResponseDTO createPessoa(PessoaRequestDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO);
        boolean adicionado = this.repository.createPessoa(pessoa);
        return adicionado ? new PessoaResponseDTO(pessoa) : null;
    }

    public PessoaResponseDTO getPessoa(String cpf){
        Pessoa pessoa = this.repository.getPessoa(cpf);
        return pessoa != null ? new PessoaResponseDTO(pessoa) : null;
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

    public PessoaResponseDTO addNewEnderecoInPessoa(String cpf, String id){
        return this.repository.addNewEnderecoInPessoa(cpf, id) ? this.getPessoa(cpf) : null;
    }

    public PessoaResponseDTO updateEnderecoInPessoa(String cpf, String id){
        return this.repository.updateEnderecoInPessoa(cpf, id) ? this.getPessoa(cpf) : null;
    }

    public PessoaResponseDTO deleteEnderecoInPessoa(String cpf, String id){
        return this.repository.deleteEnderecoInPessoa(cpf, id) ? this.getPessoa(cpf) : null;
    }
}
