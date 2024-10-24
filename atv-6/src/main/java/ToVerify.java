public class ToVerify implements Status{

    private UserStorie us;

    ToVerify(UserStorie us){
        this.us = us;
    }

    @Override
    public void mover(User u) {
        if(u.equals(User.SCRUM_MASTER)){
            Status s;
            if(this.us.isAprovada()){
                s = new Done(this.us);
            } else {
                s = new ToDo(this.us);
            }
            this.us.setStatus(s);
        }
    }
}
