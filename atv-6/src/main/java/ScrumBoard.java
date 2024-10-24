import java.util.ArrayList;
import java.util.List;

public class ScrumBoard {

    private List<UserStorie> userStories;

    public ScrumBoard() {
        this.userStories = new ArrayList<>();
    }

    public boolean addUs(int idUs){
        UserStorie userStorie = this.getUsById(idUs);
        if (userStorie != null){
            throw new UnsupportedOperationException("US com essa indentificação já está cadastrada");
        }
        return this.userStories.add(new UserStorie(idUs));
    }

    public boolean removeUs(int idUs){
        UserStorie userStorie = this.getUsById(idUs);
        this.validateUs(userStorie);
        return this.userStories.remove(userStorie);
    }

    public UserStorie getUsById(int idUs){
        return this.userStories.stream().filter(us -> us.getId() == idUs).findAny().orElse(null);
    }

    public void aprovarUs(int idUs, User u){
        UserStorie userStorie = this.getUsById(idUs);
        this.validateUs(userStorie);

        userStorie.aprovar(u);
    }

    public void moverUs(int idUs, User u){
        UserStorie userStorie = this.getUsById(idUs);
        this.validateUs(userStorie);

        userStorie.mover(u);
    }

    private void validateUs(UserStorie us){
        if (us == null){
            throw new UnsupportedOperationException("US com essa indentificação não está cadastrada");
        }
    }
}
