package main.psoft;

import java.util.Objects;

public class Usuario {

    private int cod;
    private String nome;

    public Usuario(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return cod == usuario.cod;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cod);
    }
}
