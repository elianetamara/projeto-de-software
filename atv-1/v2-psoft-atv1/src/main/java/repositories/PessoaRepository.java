package repositories;

import entities.Endereco;
import entities.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {

    private final List<Pessoa> pessoas;

    public PessoaRepository() {
        this.pessoas = new ArrayList<>();
    }

    public boolean createPessoa(Pessoa pessoa, Endereco endereco) {
        pessoa.addEndereco(endereco);
        this.pessoas.add(pessoa);
        return true;
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

    public boolean updatePessoa(String cpf, int idade, String telefone, String profissao){
        Pessoa pessoa = this.getPessoa(cpf);
        int idx = this.pessoas.indexOf(pessoa);
        this.pessoas.get(idx).setIdade(idade);
        this.pessoas.get(idx).setTelefone(telefone);
        this.pessoas.get(idx).setProfissao(profissao);
        return true;
    }

    public boolean deletePessoa(String cpf){
        Pessoa pessoa = this.getPessoa(cpf);
        this.pessoas.remove(pessoa);
        return true;
    }


    public boolean addNewEnderecoInPessoa(String cpf, Endereco endereco){
        Pessoa pessoa = this.getPessoa(cpf);
        int idx = this.pessoas.indexOf(pessoa);
        this.pessoas.get(idx).addEndereco(endereco);
        return true;
    }
}
