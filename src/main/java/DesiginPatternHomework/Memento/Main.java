package DesiginPatternHomework.Memento;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        HistoryManager history = new HistoryManager();
        editor.write("Hello word");
        editor.change(9);
        editor.write("l");
        editor.change(100);
        editor.write("!");
        System.out.println(editor.getContent());
        history.push(editor.save());
        editor.write("I'm John_doe.");
        System.out.println(editor.getContent());
        editor.restore(history.pop());
        System.out.println(editor.getContent());
        editor.restore(history.pop());
        System.out.println(editor.getContent());
    }
}
