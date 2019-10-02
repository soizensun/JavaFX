package sample;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class SubjectButton extends Button{
    private Subject ownSubject;

    public SubjectButton(String text, Subject ownSubject) {
        super(text);
        this.ownSubject = ownSubject;
    }

    public Subject getOwnSubject() {
        return ownSubject;
    }
}
