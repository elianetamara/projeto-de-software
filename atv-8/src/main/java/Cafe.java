public class Cafe extends Bebida{

    @Override
    protected void misturar() {
        System.out.println("moendo e coando café");
    }

    @Override
    protected void finalizar() {
        System.out.println("adicionando água e açúcar");
    }
}
