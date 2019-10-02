package sample;

public class ModelMain {
    public static void main(String[] args) {
        Vocabulary vo1 = new Vocabulary("hello", "noun", "a word used as a greeting", "Hello, Christina. How are you?");
        Vocabulary vo2 = new Vocabulary("dog", "n.", "a kind of animal", "This is a dog");
        Vocabulary vo3 = new Vocabulary("moon", "n.", "a kind of star", "The moon shild in the night.");
        System.out.println(vo1.toString());


        Dictionary dictionary = new Dictionary();
        try {
            dictionary.addVocab(vo1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            dictionary.addVocab(vo2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            dictionary.addVocab(vo3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String a = null;
        a = dictionary.meaning("hello");

        System.out.println(a);

    }
}
