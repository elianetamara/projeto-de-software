public class AddText implements Command{

    private TextManager tm;
    private String text;

    public AddText(TextManager tm, String text) {
        this.tm = tm;
        this.text = text;
    }

    @Override
    public void execute() {
        tm.addText(this.text);
    }

    @Override
    public void revert() {
        tm.revert();
    }
}
