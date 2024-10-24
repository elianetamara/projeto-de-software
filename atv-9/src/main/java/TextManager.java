import java.util.Stack;

public class TextManager {

    private Stack<String> texts;
    private Stack<String> removed;
    private String lastOP;

    public TextManager() {
        this.texts = new Stack<>();
        this.removed = new Stack<>();
    }

    public void addText(String text){
        texts.add(text);
        this.lastOP = "add";
    }

    public void removeText(){
        String removedText = texts.pop();
        removed.add(removedText);
        this.lastOP = "remove";
    }

    public void printText(){
        for(String s: texts){
            System.out.println(s);
        }
    }

    public void revert(){
        if(this.lastOP != null){
            if (this.lastOP.equals("add")) {
                texts.pop();
            }
            texts.add(removed.pop());
        }
    }
}
