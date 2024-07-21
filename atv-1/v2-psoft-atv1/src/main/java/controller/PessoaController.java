package controller;

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

//    public PessoaResponseDTO addNewEnderecoInPessoa(String cpf, String rua, String cep){
//        this.enderecoController.createEndereco(rua, cep);
//        return this.service.addNewEnderecoInPessoa(cpf, rua);
//    }

}
