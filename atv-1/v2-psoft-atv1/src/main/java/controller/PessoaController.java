package controller;

import dto.PessoaDTO;
import services.EnderecoService;
import services.PessoaService;

public class PessoaController {

    private PessoaService service;
    private EnderecoService enderecoService;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    public boolean createPessoa(String nome, int idade, String cpf, String telefone, String profissao, String rua, String cep) {
        this.enderecoService.createEndereco(rua, cep);
        return this.service.createPessoa(nome, idade, cpf, telefone, profissao, rua);
    }

    public PessoaDTO getPessoa(String cpf){
        return this.service.getPessoa(cpf);
    }

    public boolean updatePessoa(String cpf, int idade, String telefone, String profissao){
        return this.service.updatePessoa(cpf, idade, telefone, profissao);
    }

    public boolean deletePessoa(String cpf){
        return this.service.deletePessoa(cpf);
    }

    public boolean addNewEnderecoInPessoa(String cpf, String rua, String cep){
        this.enderecoService.createEndereco(rua, cep);
        return this.service.addNewEnderecoInPessoa(cpf, rua);
    }

}
