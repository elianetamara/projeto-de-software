public class Print implements Command{

    private TextManager tm;

    public Print(TextManager tm) {
        this.tm = tm;
    }

    @Override
    public void execute() {
        tm.printText();
    }

    @Override
    public void revert() {
        tm.revert();
    }
}
