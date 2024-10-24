import entities.ItemVenda;
import entities.Venda;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private List<Venda> vendas;

    public Mercado() {
        this.vendas = new ArrayList<Venda>();
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public boolean createVenda(List<ItemVenda> itens, String formaPagamento, int idVenda) {
        Venda venda = new Venda(itens, formaPagamento, idVenda);
        return this.vendas.contains(venda) ? false : this.vendas.add(venda);
    }

    public Venda getVenda(int idVenda) {
        return this.vendas.stream().filter(v -> v.getIdVenda() == idVenda).findAny().orElse(null);
    }

    public boolean removeVenda(int idVenda) {
        return this.vendas.removeIf(v -> v.getIdVenda() == idVenda);
    }

    public boolean updatePagamentoVenda(String formaPagamento, int idVenda) {
        Venda venda = getVenda(idVenda);
        if (venda != null) {
            int idx = this.vendas.indexOf(venda);
            venda.setFormaPagamento(formaPagamento);
            this.vendas.set(idx, venda);
            return true;
        }
        return false;
    }

    public boolean addItemVenda(ItemVenda item, int idVenda) {
        Venda venda = getVenda(idVenda);
        if (venda != null) {
            int idx = this.vendas.indexOf(venda);
            venda.addItem(item);
            this.vendas.set(idx, venda);
            return true;
        }
        return false;
    }

    public boolean removeItemVenda(ItemVenda item, int idVenda) {
        Venda venda = getVenda(idVenda);
        boolean removido = false;
        if (venda != null) {
            int idx = this.vendas.indexOf(venda);
            removido = venda.removeItem(item);
            this.vendas.set(idx, venda);
        }
        return removido;
    }
}
