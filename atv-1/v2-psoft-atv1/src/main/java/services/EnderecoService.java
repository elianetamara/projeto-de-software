package services;

import dto.EnderecoDTO;
import entities.Endereco;
import repositories.EnderecoRepository;

public class EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public boolean createEndereco(String rua, String cep) {
        Endereco endereco = new Endereco(rua, cep);
        return this.repository.createEndereco(endereco);
    }

    public EnderecoDTO getEndereco(String rua){
        Endereco e = this.repository.getEndereco(rua);
        if(e != null){
            return new EnderecoDTO(e);
        }else{
            return null;
        }
    }

    public boolean updateEndereco(String rua, String cep){
        return this.repository.updateEndereco(rua, cep);
    }

    public boolean deleteEndereco(String rua){
        return this.repository.deleteEndereco(rua);
    }
}
