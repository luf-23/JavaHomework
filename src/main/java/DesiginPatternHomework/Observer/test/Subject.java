package DesiginPatternHomework.Observer.test;

public interface Subject {
    void registerObserver(Observrer observer);
    void removeObserver(Observrer observer);
    void notifyObservers();
}
