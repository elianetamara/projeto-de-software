package dto;

import entities.Endereco;
import entities.Pessoa;

import java.util.List;

public record PessoaDTO(String nome, int idade, String cpf, String telefone, List<Endereco> endereco, String profissao) {

    public PessoaDTO(Pessoa pessoa) {
        this(pessoa.getNome(), pessoa.getIdade(), pessoa.getCpf(), pessoa.getTelefone(), pessoa.getEndereco(), pessoa.getProfissao());
    }
}
