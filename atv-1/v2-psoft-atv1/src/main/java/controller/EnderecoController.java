package controller;

import dto.EnderecoDTO;
import services.EnderecoService;

public class EnderecoController {

    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    public boolean createEndereco(EnderecoDTO enderecoDTO) {
        return this.service.createEndereco(enderecoDTO);
    }

    public EnderecoDTO getEndereco(String id) {
        return this.service.getEndereco(id);
    }

    public boolean updateEndereco(String id, EnderecoDTO enderecoDTO) {
        return this.service.updateEndereco(id, enderecoDTO);
    }

    public boolean deleteEndereco(String id) {
        return this.service.deleteEndereco(id);
    }
}
