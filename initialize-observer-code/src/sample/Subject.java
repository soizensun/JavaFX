package sample;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notification();
}
