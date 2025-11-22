package DesiginPatternHomework.Memento;

import java.util.Stack;

//Memento 对 Manager 是“黑盒”,只负责管理但是不知道Memento的细节
public class HistoryManager {
    private final Stack<Editor.Memento> history = new Stack<>();

    public void push(Editor.Memento memento) {
        history.push(memento);
    }

    public Editor.Memento pop() {
        return history.isEmpty() ? null : history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
