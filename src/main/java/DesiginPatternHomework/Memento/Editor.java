package DesiginPatternHomework.Memento;

public class Editor {
    private Integer cursor;
    private String content;

    public Editor() {
        this.content = "";
        this.cursor = 0;
    }
    public Editor(String content) {
        this.content = content;
        this.cursor = content.length();
    }

    public void write(String text) {
        content = content.substring(0, cursor) + text + content.substring(cursor);
        cursor += text.length();
    }
    public void change(int index) {
        cursor = Math.min(index, content.length());
    }
    public String getContent() {
        return content;
    }

    public Memento save(){
        return new Memento(content, cursor);
    }

    public void restore(Memento memento){
        if (memento == null){
            content = "";
            cursor = 0;
            return;
        }
        content = memento.content;
        cursor = memento.cursor;
    }
    //只读，且对其他对象不可见
    public static class Memento{
        private final String content;
        private final Integer cursor;
        private Memento(String content, Integer cursor) {
            this.content = content;
            this.cursor = cursor;
        }
    }

}
