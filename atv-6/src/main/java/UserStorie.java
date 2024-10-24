import java.util.Objects;

public class UserStorie {

    private int id;
    private Status status;
    private boolean aprovada;

    UserStorie(int id){
        this.id = id;
        this.status = new ToDo(this);
        this.aprovada = false;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void aprovar(User u){
        if (u.equals(User.SCRUM_MASTER)){
            this.aprovada = true;
        }
    }

    public void mover(User u){
        this.status.mover(u);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserStorie that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
