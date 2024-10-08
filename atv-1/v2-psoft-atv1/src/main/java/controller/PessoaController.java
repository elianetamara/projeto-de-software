package controller;

import dto.request.EnderecoRequestDTO;
import dto.response.EnderecoResponseDTO;
import dto.response.PessoaResponseDTO;
import dto.request.PessoaRequestDTO;
import services.PessoaService;

public class PessoaController {

    private PessoaService service;
    private EnderecoController enderecoController;

    public PessoaController() {
        this.service = new PessoaService();
        enderecoController = new EnderecoController();
    }

    public PessoaResponseDTO createPessoa(PessoaRequestDTO pessoaDTO) {
        return this.service.createPessoa(pessoaDTO);
    }

    public PessoaResponseDTO getPessoa(String cpf){
        return this.service.getPessoa(cpf);
    }

    public PessoaResponseDTO updatePessoa(PessoaRequestDTO pessoaDTO){
        return this.service.updatePessoa(pessoaDTO);
    }

    public PessoaResponseDTO deletePessoa(String cpf){
        return this.service.deletePessoa(cpf);
    }

    public PessoaResponseDTO addNewEnderecoInPessoa(String cpf, EnderecoRequestDTO enderecoDTO){
        EnderecoResponseDTO endereco = this.enderecoController.createEndereco(enderecoDTO);
        return this.service.addNewEnderecoInPessoa(cpf, endereco.id());
    }

    public PessoaResponseDTO updateEnderecoInPessoa(String cpf, String id, EnderecoRequestDTO enderecoDTO){
        EnderecoResponseDTO endereco = this.enderecoController.updateEndereco(id, enderecoDTO);
        return this.service.updateEnderecoInPessoa(cpf, endereco.id());
    }

    public PessoaResponseDTO deleteEnderecoInPessoa(String cpf, String id){
        EnderecoResponseDTO removido = this.enderecoController.deleteEndereco(id);
        return this.service.deleteEnderecoInPessoa(cpf, removido.id());
    }

}
