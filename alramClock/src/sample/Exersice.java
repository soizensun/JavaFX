package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Exersice {
    private Image imageSolution;
    private String answer;

    public Exersice(Image imageSolution, String answer) {
        this.imageSolution = imageSolution;
        this.answer = answer;
    }

    public Image getImageSolution() {
        return imageSolution;
    }

    public String getAnswer() {
        return answer;
    }
}