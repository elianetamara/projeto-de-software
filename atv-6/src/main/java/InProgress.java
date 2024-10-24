public class InProgress implements Status{

    private UserStorie us;

    InProgress(UserStorie us){
        this.us = us;
    }

    @Override
    public void mover(User u) {
        if(u.equals(User.DESENVOLVEDOR)){
            Status s = new ToVerify(this.us);
            this.us.setStatus(s);
        }
    }
}
