public class Gerente implements Equipe {

    private String nome;

    public Gerente(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

}
