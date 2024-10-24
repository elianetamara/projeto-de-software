public abstract class Sanduiche {

    private final int qtdFatiasPao = 2;
    private boolean hasSalada;
    private Pao tipoPao;
    private Presunto presunto;
    private Queijo queijo;

    public Sanduiche(boolean hasSalada, Pao tipoPao, Presunto presunto, Queijo queijo) {
        this.hasSalada = hasSalada;
        this.tipoPao = tipoPao;
        this.presunto = presunto;
        this.queijo = queijo;
    }

    @Override
    public String toString() {
        String salada = hasSalada ? ", com verdura" : ", sem verdura";
        return qtdFatiasPao + " fatias de pão " + tipoPao +
                ", presunto de " + presunto +
                ", queijo " + queijo + salada;
    }
}
