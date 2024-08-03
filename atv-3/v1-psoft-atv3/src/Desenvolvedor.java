public class Desenvolvedor implements Equipe {

    private String nome;

    public Desenvolvedor(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

}
