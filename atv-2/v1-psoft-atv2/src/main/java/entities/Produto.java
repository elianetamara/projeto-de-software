package entities;

import java.util.Objects;

public class Produto {

    private String nome;
    private String descricao;
    private double preco;
    private int codigoBarra;

    public Produto(String nome, String descricao, double preco, int codigoBarra) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.codigoBarra = codigoBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return codigoBarra == produto.codigoBarra;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoBarra);
    }
}
