package entities;

import dto.request.PessoaRequestDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pessoa {

    private String cpf;
    private String nome;
    private int idade;
    private String telefone;
    private List<Endereco> enderecos;
    private String profissao;

    public Pessoa(String nome, int idade, String cpf, String telefone, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.enderecos = new ArrayList<>();
    }

    public Pessoa(PessoaRequestDTO pessoaDTO) {
        this(pessoaDTO.nome(), pessoaDTO.idade(), pessoaDTO.cpf(), pessoaDTO.telefone(), pessoaDTO.profissao());
        this.enderecos = new ArrayList<>();
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
        this.enderecos.add(endereco);
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public String getProfissao() {
        return profissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(cpf, pessoa.cpf) && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome);
    }
}
