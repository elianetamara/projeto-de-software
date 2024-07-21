package entities;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    public String nome;
    public int idade;
    public String cpf;
    public String telefone;
    public List<Endereco> endereco;
    public String profissao;

    public Pessoa(String nome, int idade, String cpf, String telefone, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.endereco = new ArrayList<>();
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void addEndereco(Endereco endereco) {
        this.endereco.add(endereco);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public String getProfissao() {
        return profissao;
    }
}
