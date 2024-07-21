package services;

import dto.PessoaDTO;
import entities.Endereco;
import entities.Pessoa;
import repositories.EnderecoRepository;
import repositories.PessoaRepository;

public class PessoaService {

    private final PessoaRepository repository;
    private EnderecoRepository enderecoRepository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public boolean createPessoa(String nome, int idade, String cpf, String telefone, String profissao, String rua) {
        Pessoa pessoa = new Pessoa(nome, idade, cpf, telefone, profissao);
        Endereco endereco = this.enderecoRepository.getEndereco(rua);
        return this.repository.createPessoa(pessoa, endereco);
    }

    public PessoaDTO getPessoa(String cpf){
        Pessoa pessoa = this.repository.getPessoa(cpf);
        if(pessoa != null){
            return new PessoaDTO(pessoa);
        }else {
            return null;
        }
    }

    public boolean updatePessoa(String cpf, int idade, String telefone, String profissao){
        return this.repository.updatePessoa(cpf, idade, telefone, profissao);
    }

    public boolean deletePessoa(String cpf){
        return this.repository.deletePessoa(cpf);
    }

    public boolean addNewEnderecoInPessoa(String cpf, String rua){
        Endereco endereco = enderecoRepository.getEndereco(rua);
        return this.repository.addNewEnderecoInPessoa(cpf, endereco);
    }
}
