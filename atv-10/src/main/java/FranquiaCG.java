public class FranquiaCG extends Lanchonete{

    @Override
    protected Sanduiche criarSanduiche() {
        return new SanduicheCG();
    }

    @Override
    public String toString() {
        return "FranquiaCG";
    }
}
