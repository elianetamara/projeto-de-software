public abstract class Bebida {

    public final void preparar(){
        esquentarAgua();
        misturar();
        servir();
        finalizar();
    }

    private void esquentarAgua(){
        System.out.println("esquentando água");
    }

    private void servir(){
        System.out.println("servindo em um copo");
    }

    protected abstract void misturar();

    protected abstract void finalizar();
}
