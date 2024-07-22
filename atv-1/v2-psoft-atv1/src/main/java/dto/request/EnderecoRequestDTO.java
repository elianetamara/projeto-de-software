package dto.request;

import entities.Endereco;

public record EnderecoRequestDTO(String rua, String numero, String bairro, String cidade, String estado, String cep) {

    public EnderecoRequestDTO(Endereco endereco) {
        this(endereco.getRua(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
    }

}
