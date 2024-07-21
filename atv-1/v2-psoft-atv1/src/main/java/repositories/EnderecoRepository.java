package repositories;

import entities.Endereco;

import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository {

    private final List<Endereco> enderecos;

    public EnderecoRepository() {
        this.enderecos = new ArrayList<>();
    }

    public boolean createEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
        return true;
    }

    public Endereco getEndereco(String rua){
        Endereco endereco = null;
        for (Endereco e: enderecos){
            if(e.getRua().equals(rua)){
                endereco = e;
            }
        }
        return endereco;
    }

    public boolean updateEndereco(String rua, String cep){
        Endereco endereco = this.getEndereco(rua);
        int idx = this.enderecos.indexOf(endereco);
        this.enderecos.get(idx).setCep(cep);
        return true;
    }

    public boolean deleteEndereco(String rua){
        Endereco endereco = this.getEndereco(rua);
        this.enderecos.remove(endereco);
        return true;
    }
}
