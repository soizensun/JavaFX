package sample;

public interface Sample {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notification();
}
