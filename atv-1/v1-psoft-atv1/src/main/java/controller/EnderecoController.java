package controller;

import dto.EnderecoDTO;
import services.EnderecoService;

public class EnderecoController {

    private EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    public boolean createEndereco(String rua, String bairro, String numero, String cep) {
        return this.service.createEndereco(rua, cep);
    }

    public EnderecoDTO getEndereco(String rua){
        return this.service.getEndereco(rua);
    }

    public boolean updateEndereco(String rua, String cep){
        return this.service.updateEndereco(rua, cep);
    }

    public boolean deleteEndereco(String rua){
        return this.service.deleteEndereco(rua);
    }
}
