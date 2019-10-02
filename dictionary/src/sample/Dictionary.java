package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Dictionary implements Serializable {
    private ArrayList<Vocabulary> dic;

    public Dictionary() {
        dic = new ArrayList<Vocabulary>();

        dic.add(new Vocabulary("hello", "noun", "a word used as a greeting", "Hello, Christina. How are you?"));
        dic.add(new Vocabulary("know", "verb", "to be certain", "Do you know how to ski?"));
        dic.add(new Vocabulary("bachelor", "noun", "an unmarried man", "He’s a confirmed bachelor."));
        dic.add(new Vocabulary("daughter", "noun" , "someone’s female child", "Their daughter is seven years old."));
        dic.add(new Vocabulary("cat", "noun","kind of an animal","I like a cat" ));
    }

    public void addVocab(Vocabulary vocab) throws Exception {
        if(vocab.getWord().equals("") || vocab.getMeaning().equals("") || vocab.getExmaple().equals("") || vocab.getMeaning().equals("")){
            throw new Exception("Please fill all of fields.");
        }
        else {
            this.dic.add(vocab);
        }
    }

    public String meaning(String word){
        String s = "";
        for (Vocabulary a : dic) {
            if(a.getWord().equals(word)){
                s = "\" " + word+ " \" : " + a.getMeaning();
                break;
            }
            else s = "\" " + word+ " \"" + " is not in this dictionary";
        }
        return s;
    }

    public void deleteVocab(Vocabulary vocabulary){
        this.dic.remove(vocabulary);
    }

    public ArrayList<Vocabulary> getVocab() {
        return dic;
    }

    public String format(MyFormatter format){
        return format.format(this);
    }

    public int getSize(){
        return dic.size();
    }
}
