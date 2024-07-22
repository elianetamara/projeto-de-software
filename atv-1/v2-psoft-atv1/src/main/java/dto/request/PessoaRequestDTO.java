package dto.request;

import entities.Pessoa;

public record PessoaRequestDTO(String nome, int idade, String cpf, String telefone, String profissao) {

    public PessoaRequestDTO(Pessoa pessoa) {
        this(pessoa.getNome(), pessoa.getIdade(), pessoa.getCpf(), pessoa.getTelefone(), pessoa.getProfissao());
    }
}
