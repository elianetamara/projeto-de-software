public abstract class Lanchonete {

    protected abstract Sanduiche criarSanduiche();

    public void venderSanduiche(){
        Sanduiche s = this.criarSanduiche();
        System.out.println(this);
        System.out.println("Seu sanduiche contem os seguintes ingredientes:");
        System.out.println(s.toString());
    }
}
