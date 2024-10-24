package entities;

import java.util.List;
import java.util.Objects;

public class Venda {

    private List<ItemVenda> itens;
    private double valorTotal;
    private String formaPagamento;
    private int idVenda;

    public Venda(List<ItemVenda> itens, String formaPagamento, int idVenda) {
        this.itens = itens;
        this.valorTotal = 0;
        this.formaPagamento = formaPagamento;
        this.idVenda = idVenda;
        calculaValorTotal();
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean addItem(ItemVenda item) {
        boolean adicionado = this.itens.add(item);
        if (adicionado) calculaValorTotal();
        return adicionado;
    }

    public boolean removeItem(ItemVenda item) {
        // valida que venda nao pode ter uma lista vazia de itens
        if (this.itens.size() == 1 && this.itens.contains(item)){
           return false;
        }
        boolean removido = this.itens.remove(item);
        if (removido) calculaValorTotal();
        return removido;
    }

    private void calculaValorTotal() {
        double valor = 0;
        for (ItemVenda iv : this.itens) {
            valor += iv.calculaValorItem();
        }
        this.valorTotal = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return idVenda == venda.idVenda;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idVenda);
    }
}
