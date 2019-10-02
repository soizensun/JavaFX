package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Vocabulary implements Serializable {
    private String word;
    private String exmaple;
    private String meaning;
    private String partOfSpeech;

    public Vocabulary(String word, String partOfSpeech, String meaning, String exmaple) {
//        this.word = new SimpleStringProperty(word);
//        this.exmaple = new SimpleStringProperty(exmaple);
//        this.meaning = new SimpleStringProperty(meaning);
//        this.partOfSpeech = new SimpleStringProperty(partOfSpeech);
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.exmaple = exmaple;
    }

    public String getWord(){
        return word;
    }

    public String getExmaple() {
        return exmaple;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setWord(String word) {
//        this.word = new SimpleStringProperty(word);
        this.word = word;
    }

    public void setExmaple(String exmaple) {
//        this.exmaple = new SimpleStringProperty(exmaple);
        this.exmaple = exmaple;
    }

    public void setMeaning(String meaning) {
//        this.meaning = new SimpleStringProperty(meaning);
        this.meaning = meaning;
    }

    public void setPartOfSpeech(String partOfSpeech) {
//        this.partOfSpeech = new SimpleStringProperty(partOfSpeech);
        this.partOfSpeech = partOfSpeech;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "word='" + word + '\'' +
                ", exmaple='" + exmaple + '\'' +
                ", meaning='" + meaning + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                '}';
    }
}
