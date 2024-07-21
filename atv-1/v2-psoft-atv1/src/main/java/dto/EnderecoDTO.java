package dto;

import entities.Endereco;

public record EnderecoDTO(String rua, String numero, String bairro, String cidade, String estado, String cep) {

    public EnderecoDTO(Endereco endereco) {
        this(endereco.getRua(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
    }

}
