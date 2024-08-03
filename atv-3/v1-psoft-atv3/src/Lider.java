public class Lider implements Equipe {

    private String nome;

    public Lider(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

}
