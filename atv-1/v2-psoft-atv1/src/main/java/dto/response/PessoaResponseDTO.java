package dto.response;

import entities.Endereco;
import entities.Pessoa;

import java.util.List;

public record PessoaResponseDTO(String nome, int idade, String cpf, String telefone, List<Endereco> enderecos, String profissao) {

    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.getNome(), pessoa.getIdade(), pessoa.getCpf(), pessoa.getTelefone(), pessoa.getEnderecos(), pessoa.getProfissao());
    }
}
