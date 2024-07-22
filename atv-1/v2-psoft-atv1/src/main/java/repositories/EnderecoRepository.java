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
        if (this.enderecos.contains(endereco)) {
            return false;
        }
        return this.enderecos.add(endereco);
    }

    public Endereco getEndereco(String id) {
        for (Endereco endereco : this.enderecos) {
            if (endereco.getId().equals(id)) {
                return endereco;
            }
        }
        return null;
    }

    public boolean updateEndereco(String id, Endereco novoEndereco) {
        Endereco enderecoPersistido = this.getEndereco(id);
        this.enderecos.set(enderecos.indexOf(enderecoPersistido), novoEndereco);
        return true;
    }

    public Endereco deleteEndereco(String id) {
        Endereco endereco = this.getEndereco(id);
        return this.enderecos.remove(endereco) ? endereco : null;
    }
}
