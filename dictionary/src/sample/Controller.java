package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;


public class Controller {
    private Dictionary mydic = new Dictionary();
    private Vocabulary currentVocab = null;

    String cwd = System.getProperty("user.dir"); // return current working directory
    String sep = System.getProperty("file.separator"); // each os is not the same sep

    File jarDir = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    String p = jarDir.getParentFile().getAbsolutePath();

    File newFile = new File(p + sep + "dicDataBase");

    ObservableList<String> partOfSpeechList = FXCollections.observableArrayList("verb", "noun", "pronoun", "adjective", "adverb");
    ObservableList<String> formatList = FXCollections.observableArrayList("JSON", "XML");

//    File dicFile = new File("myDic.txt");
//    BufferedReader buffet = new BufferedReader(new FileReader(dicFile));
//    BufferedWriter buffer = new BufferedWriter(new FileWriter(dicFile))

    @FXML private AnchorPane menuAnchropane;
    @FXML private TableView dicTableView;
    @FXML private TableColumn wordColumn, partOfSpeechColumn, meaningColumn, exampleColumn;
    @FXML private TextField wordTextField, meaningTextField, exampleTextField, serchMeaningTextField;
    @FXML private ComboBox partOfSpeechComboBox, formatComboBox;
    @FXML private Button addWordButton, editWordButton, chooseButton, closeShowFormatLabel, closeButton;
    @FXML private Label exceptionLabel, warnningEditVocabLable, showFormat, meaningLabel, exceptionLabel1;

    public Controller() throws FileNotFoundException {
    }

    @FXML
    private void initialize(){
        exceptionLabel.setVisible(false);
        exceptionLabel1.setVisible(false);
        menuAnchropane.setVisible(true);
        partOfSpeechComboBox.setItems(partOfSpeechList);
        formatComboBox.setItems(formatList);
        showFormat.setVisible(false);
        closeShowFormatLabel.setVisible(false);
        try {
            if(newFile.createNewFile()){
                writeObject(mydic);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTableView();
    }

    public void writeObject(Object mydic){
        FileOutputStream fileOS = null;
        try {
            fileOS = new FileOutputStream(newFile);
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream out = new ObjectOutputStream(fileOS);
            out.writeObject(mydic);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readFile(){
        FileInputStream filein = null;
        try {
            filein = new FileInputStream(newFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream in = new ObjectInputStream(filein);
            mydic =  (Dictionary) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setTableView(){
        try {
            if(!newFile.createNewFile()){
                readFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObservableList<Vocabulary> vocabularyList = FXCollections.observableArrayList(mydic.getVocab());
        wordColumn.setCellValueFactory(new PropertyValueFactory<Dictionary ,String>("word"));
        partOfSpeechColumn.setCellValueFactory(new PropertyValueFactory<Dictionary ,String>("partOfSpeech"));
        meaningColumn.setCellValueFactory(new PropertyValueFactory<Dictionary ,String>("meaning"));
        exampleColumn.setCellValueFactory(new PropertyValueFactory<Dictionary ,String>("exmaple"));

        dicTableView.getColumns().setAll(wordColumn, partOfSpeechColumn, meaningColumn, exampleColumn);
        dicTableView.setItems(vocabularyList);
    }

    @FXML void handleSerchMeaningButtonOnClick(ActionEvent actionEvent){
        String s = serchMeaningTextField.getText();
        meaningLabel.setText(mydic.meaning(s));
        serchMeaningTextField.setText("");
        exceptionLabel.setVisible(false);
    }

    @FXML
    private void handleAddVocabButtonOnClick(ActionEvent actionEvent){
        String word, partOfSpeech, meaning, example;

        word = wordTextField.getText();
        partOfSpeech = (String) partOfSpeechComboBox.getValue();
        meaning = meaningTextField.getText();
        example = exampleTextField.getText();
        try {
            mydic.addVocab(new Vocabulary(word, partOfSpeech, meaning, example));
        } catch (Exception e) {
            exceptionLabel1.setVisible(true);
            exceptionLabel1.setText(e.getMessage());
        }
        writeObject(mydic);
        setTableView();

        wordTextField.setText("");
        partOfSpeechComboBox.setValue("");
        meaningTextField.setText("");
        exampleTextField.setText("");
//        menuAnchropane.setVisible(true);
    }

    @FXML
    public void handleDeleteWordButtonOnClick(ActionEvent actionEvent) throws Exception {
        Vocabulary vocabulary;
        vocabulary = (Vocabulary) dicTableView.getSelectionModel().getSelectedItem();
        if(vocabulary == null){
            exceptionLabel.setVisible(true);
            exceptionLabel.setText("Please select vocab do you want to delete.");
        }
        else{
            exceptionLabel.setVisible(false);
            mydic.deleteVocab(vocabulary);
            writeObject(mydic);
        }
        setTableView();
    }

    @FXML
    public void handleEditButtonOnClick(ActionEvent actionEvent){
        String word, partOfSpeech, meaning, example;

        word = wordTextField.getText();
        partOfSpeech = (String) partOfSpeechComboBox.getValue();
        meaning = meaningTextField.getText();
        example = exampleTextField.getText();

        currentVocab.setWord(word);
        currentVocab.setPartOfSpeech(partOfSpeech);
        currentVocab.setMeaning(meaning);
        currentVocab.setExmaple(example);

        writeObject(mydic);
        setTableView();
        wordTextField.setText("");
        partOfSpeechComboBox.setValue("");
        meaningTextField.setText("");
        exampleTextField.setText("");
        menuAnchropane.setVisible(false);
        editWordButton.setVisible(false);
        chooseButton.setVisible(true);
        warnningEditVocabLable.setVisible(true   );
    }

    @FXML
    public void handleChooseButtonOnClick(ActionEvent actionEvent){
        Vocabulary vocabulary;
        vocabulary = (Vocabulary) dicTableView.getSelectionModel().getSelectedItem();
        if(vocabulary == null){
            exceptionLabel1.setVisible(true);
            exceptionLabel1.setText("Please select a word do you want to edit.");
        }
        else{
            exceptionLabel1.setVisible(false);
            wordTextField.setText(vocabulary.getWord());
            partOfSpeechComboBox.setValue(vocabulary.getPartOfSpeech());
            meaningTextField.setText(vocabulary.getMeaning());
            exampleTextField.setText(vocabulary.getExmaple());
            warnningEditVocabLable.setVisible(false);
            chooseButton.setVisible(false);
            editWordButton.setVisible(true);
            for (Vocabulary v : mydic.getVocab())  {
                if(v.getWord() == vocabulary.getWord()){
                    currentVocab = v;
                }
            }
        }
    }

    @FXML
    public void handleShowFormatButtonOnClick(ActionEvent actionEvent){
        String whatFormat;
        whatFormat = (String) formatComboBox.getValue();
        showFormat.setVisible(true);
        closeShowFormatLabel.setVisible(true);

        if (whatFormat == "XML") {
            MyFormatter XmlFormat = new MyFormatter() {
                @Override
                public String format(Object obj) {
                    Dictionary dic = (Dictionary) obj;
                    ArrayList<Vocabulary> vocabularyArrayList = dic.getVocab();
                    String result = "<Dictionary>\n";

                    for (Vocabulary v : vocabularyArrayList) {
                        result += "\t<Vocab word=\"" + v.getWord() + "\">\n"
                                + "\t\t<PartOfSpeech>" + v.getPartOfSpeech() + "</PartOfSpeech>\n"
                                + "\t\t<Meaning>" + v.getMeaning() + "</Meaning>\n"
                                + "\t\t<Example>" + v.getExmaple() + "</Example>\n"
                                + "\t</Vocab>\n";
                    }
                    result += "</Dictionary>";
                    return result;
                }
            };
            showFormat.setText(mydic.format(XmlFormat));
        }
        else if (whatFormat == "JSON"){
            MyFormatter XmlFotmat = new MyFormatter() {
                @Override
                public String format(Object obj) {
                    Dictionary dic = (Dictionary) obj;
                    ArrayList<Vocabulary> vocabularyArrayList = dic.getVocab();
                    int a = vocabularyArrayList.size();
                    String result = "[\n";
                    int index = 1;
                    for (Vocabulary v : vocabularyArrayList) {
                        result += "\t{\n\t\tvocab: \"" + v.getWord() + "\",\n"
                                + "\t\tpartOfSpeech:\"" + v.getPartOfSpeech() + "\",\n"
                                + "\t\tmeaning: \"" + v.getMeaning() + "\",\n"
                                + "\t\texample:" + v.getExmaple() + "\"\n"
                                + "\t}";
                        index += 1;
                        if((index - 1) != a){
                            result += ",\n";
                        }
                        else
                            result += "\n";
                    }
                    result += "]\n";
                    return result;
                }
            };
            showFormat.setText(mydic.format(XmlFotmat));
        }
    }

    @FXML
    public void handleAddVocabInMenuOnClick(ActionEvent actionEvent){
        menuAnchropane.setVisible(false);
        editWordButton.setVisible(false);
        chooseButton.setVisible(false);
        addWordButton.setVisible(true);
        warnningEditVocabLable.setVisible(false);
        exceptionLabel.setVisible(false);
    }

    @FXML
    public void handleEditWordInMenuOnClick(ActionEvent actionEvent){
        menuAnchropane.setVisible(false);
        addWordButton.setVisible(false);
        editWordButton.setVisible(false);
        chooseButton.setVisible(true);
        warnningEditVocabLable.setVisible(true);
        exceptionLabel.setVisible(false);
    }

    @FXML
    public void handleCloseButtonOnClick(ActionEvent actionEvent){
        menuAnchropane.setVisible(true);
        wordTextField.setText("");
        partOfSpeechComboBox.setValue("");
        meaningTextField.setText("");
        exampleTextField.setText("");
        exceptionLabel1.setVisible(false);
        exceptionLabel.setVisible(false);
    }

    @FXML
    public void handleCloseShowFormatLabelButtonOnClick(ActionEvent actionEvent){
        showFormat.setVisible(false);
        closeShowFormatLabel.setVisible(false);
    }
}








