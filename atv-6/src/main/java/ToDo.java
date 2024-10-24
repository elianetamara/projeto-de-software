public class ToDo implements Status{

    private UserStorie us;

    ToDo(UserStorie us){
        this.us = us;
    }

    @Override
    public void mover(User u) {
        Status s = new InProgress(this.us);
        this.us.setStatus(s);
    }
}
