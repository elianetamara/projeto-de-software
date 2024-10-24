public class Done implements Status{

    private UserStorie us;

    Done(UserStorie us){
        this.us = us;
    }

    @Override
    public void mover(User u) {
        // does nothing
    }
}
