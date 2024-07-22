package dto.response;

import entities.Endereco;

public record EnderecoResponseDTO(String id, String rua, String numero, String bairro, String cidade, String estado, String cep) {

    public EnderecoResponseDTO(Endereco endereco) {
        this(endereco.getId(), endereco.getRua(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
    }

}
