package dto;

import entities.Endereco;

public record EnderecoDTO(String rua, String cep) {

    public EnderecoDTO(Endereco endereco) {
        this(endereco.getRua(), endereco.getCep());
    }
}
