package main.psoft;

import java.util.Objects;

public class Livro {

    private int cod;
    private String nome;
    private boolean disponivel;
    private Usuario usuarioReserva;

    public Livro(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
        this.disponivel = true;
        this.usuarioReserva = null;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public Usuario getUsuarioReserva() {
        return usuarioReserva;
    }

    public void setUsuarioReserva(Usuario usuarioReserva) {
        this.usuarioReserva = usuarioReserva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro livro)) return false;
        return cod == livro.cod;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cod);
    }
}