package services;

import dto.request.EnderecoRequestDTO;
import dto.response.EnderecoResponseDTO;
import entities.Endereco;
import repositories.EnderecoRepository;

public class EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public EnderecoResponseDTO createEndereco(EnderecoRequestDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        boolean adicionado = this.repository.createEndereco(endereco);
        return adicionado ? new EnderecoResponseDTO(endereco) : null;
    }

    public EnderecoResponseDTO getEndereco(String id) {
        Endereco e = this.repository.getEndereco(id);
        if (e != null) {
            return new EnderecoResponseDTO(e);
        }
        return null;
    }

    public EnderecoResponseDTO updateEndereco(String id, EnderecoRequestDTO enderecoDTO) {
        Endereco novoEndereco = new Endereco(enderecoDTO);
        boolean atualizado = this.repository.updateEndereco(id, novoEndereco);
        return atualizado ? new EnderecoResponseDTO(novoEndereco) : null;
    }

    public EnderecoResponseDTO deleteEndereco(String id) {
        Endereco removido = this.repository.deleteEndereco(id);
        if (removido != null) {
            return new EnderecoResponseDTO(removido);
        }
        return null;
    }
}
