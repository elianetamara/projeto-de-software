package repositories;

import entities.Endereco;
import entities.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {

    private final List<Pessoa> pessoas;
    private EnderecoRepository enderecoRepository;

    public PessoaRepository() {
        this.pessoas = new ArrayList<>();
        this.enderecoRepository = new EnderecoRepository();
    }

    public boolean createPessoa(Pessoa pessoa) {
        if(this.pessoas.contains(pessoa)) {
            return false;
        }
        return this.pessoas.add(pessoa);
    }

    public Pessoa getPessoa(String cpf){
        Pessoa pessoa = null;
        for (Pessoa p: pessoas) {
            if (p.getCpf().equals(cpf)){
                pessoa = p;
            }
        }
        return pessoa;
    }

    public boolean updatePessoa(String cpf, Pessoa novaPessoa){
        Pessoa pessoaPersistida = this.getPessoa(cpf);
        this.pessoas.set(pessoas.indexOf(pessoaPersistida), novaPessoa);
        return true;
    }

    public Pessoa deletePessoa(String cpf){
        Pessoa pessoa = this.getPessoa(cpf);
        return this.pessoas.remove(pessoa) ? pessoa : null;
    }

    public boolean addNewEnderecoInPessoa(String cpf, String id){
        Pessoa pessoa = this.getPessoa(cpf);
        Endereco endereco = this.enderecoRepository.getEndereco(id);
        pessoa.addEndereco(endereco);
        return this.updatePessoa(cpf, pessoa);
    }
}
