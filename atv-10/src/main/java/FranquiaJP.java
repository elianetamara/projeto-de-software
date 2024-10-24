public class FranquiaJP extends Lanchonete{
    @Override
    protected Sanduiche criarSanduiche() {
        return new SanduicheJP();
    }

    @Override
    public String toString() {
        return "FranquiaJP";
    }
}
