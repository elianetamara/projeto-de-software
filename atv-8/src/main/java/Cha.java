public class Cha extends Bebida{

    @Override
    protected void misturar() {
        System.out.println("mergulhando saquinho de chá");
    }

    @Override
    protected void finalizar() {
        System.out.println("adicionando limão");
    }
}
