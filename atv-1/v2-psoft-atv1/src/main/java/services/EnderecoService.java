package services;

import dto.EnderecoDTO;
import entities.Endereco;
import repositories.EnderecoRepository;

public class EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public boolean createEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        return this.repository.createEndereco(endereco);
    }

    public EnderecoDTO getEndereco(String id){
        Endereco e = this.repository.getEndereco(id);
        if(e != null){
            return new EnderecoDTO(e);
        }else{
            return null;
        }
    }

    public boolean updateEndereco(String id, EnderecoDTO enderecoDTO){
        Endereco novoEndereco = new Endereco(enderecoDTO);
        return this.repository.updateEndereco(id, novoEndereco);
    }

    public boolean deleteEndereco(String id){
        return this.repository.deleteEndereco(id);
    }
}
