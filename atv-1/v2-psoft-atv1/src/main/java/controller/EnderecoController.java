package controller;

import dto.request.EnderecoRequestDTO;
import dto.response.EnderecoResponseDTO;
import services.EnderecoService;

public class EnderecoController {

    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    public EnderecoResponseDTO createEndereco(EnderecoRequestDTO enderecoDTO) {
        return this.service.createEndereco(enderecoDTO);
    }

    public EnderecoResponseDTO getEndereco(String id) {
        return this.service.getEndereco(id);
    }

    public EnderecoResponseDTO updateEndereco(String id, EnderecoRequestDTO enderecoDTO) {
        return this.service.updateEndereco(id, enderecoDTO);
    }

    public EnderecoResponseDTO deleteEndereco(String id) {
        return this.service.deleteEndereco(id);
    }
}
