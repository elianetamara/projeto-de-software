import java.util.ArrayList;
import java.util.List;

public class Sprint {

    private List<Equipe> equipe;

    public Sprint() {
        this.equipe = new ArrayList<>();
    }

    public void defineEquipe(Equipe gerente, Equipe lider, List<Equipe> desenvolvedores) {
        setGerente(gerente);
        setLider(lider);
        setDevs(desenvolvedores);
    }

    public void setDevs(List<Equipe> desenvolvedores) {
        this.equipe.addAll(this.checkDev(desenvolvedores));
    }

    /*
     * desenvolvedor recebe uma promoção e passa a ter *apenas a responsabilidade de gerente* de um time
     * */
    public void promoveDev(Equipe dev){
        this.equipe.removeIf(x -> x.getNome().equals(dev.getNome()));
        this.equipe.removeIf(x -> x instanceof Gerente);
        this.setGerente(new Gerente(dev.getNome()));
    }

    /*
     * desenvolvedor assume o papel de líder do time e *acumula as duas responsabilidades*
     * */
    public void assumeLideranca(Equipe dev){
        this.equipe.removeIf(x -> x instanceof Lider);
        this.setLider(new Lider(dev.getNome()));
    }

    private void setGerente(Equipe gerente){
        this.equipe.add(gerente);
    }

    private void setLider(Equipe lider){
        this.equipe.add(lider);
    }

    /*
    * checa se algum dev da lista de desenvolvedores a ser
    * adicionada ja foi colocado como gerente
    * */
    private List<Equipe> checkDev(List<Equipe> devs){
        Equipe gerente = this.equipe.stream().filter(x -> x instanceof Gerente).findAny().orElse(null);
        boolean removido = gerente != null && devs.removeIf(x -> x.getNome().equals(gerente.getNome()));
        return devs;
    }
}
