public class TextEditor {

    private Command c;

    public void setCommand(Command c){
        this.c = c;
    }

    public void executeCommand(){
        c.execute();
    }

    public void revertCommand(){
        c.revert();
    }
}
