package entities;

import dto.EnderecoDTO;

import java.util.Objects;

public class Endereco {

    private String id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.setId();
    }

    public Endereco(EnderecoDTO enderecoDTO) {
        this(enderecoDTO.rua(), enderecoDTO.numero(), enderecoDTO.bairro(), enderecoDTO.cidade(), enderecoDTO.estado(), enderecoDTO.cep());
    }

    public String getId() {
        return id;
    }

    public void setId() {
        String id = numero + bairro + cep;
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
