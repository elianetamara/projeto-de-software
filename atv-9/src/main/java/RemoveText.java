public class RemoveText implements Command{

    private TextManager tm;

    public RemoveText(TextManager tm) {
        this.tm = tm;
    }

    @Override
    public void execute() {
        tm.removeText();
    }

    @Override
    public void revert() {
        tm.revert();
    }
}
