public class FranquiaSZ extends Lanchonete{

    @Override
    protected Sanduiche criarSanduiche() {
        return new SanduicheSZ();
    }

    @Override
    public String toString() {
        return "FranquiaSZ";
    }
}
