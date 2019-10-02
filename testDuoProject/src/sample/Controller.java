package sample;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class Controller {
    FileManaging f ;
    SubjectButton subjectButton;
    Double buttonPositionTop = 0.0;
    @FXML
    private void initialize(){
        f = new FileManaging();
        f.readAll();
    }

    @FXML private ListView subjectListView;

    @FXML private AnchorPane showButtonPane;

    @FXML
    private void handleRegisterButtonOnClick(ActionEvent actionEvent){
        Subject subject;
        subject = (Subject) subjectListView.getSelectionModel().getSelectedItem();
        System.out.println(subject);
        subjectButton = new SubjectButton(subject.getName(), subject);
        showButtonPane.getChildren().add(subjectButton);

        AnchorPane.setTopAnchor(subjectButton, buttonPositionTop);
        buttonPositionTop += 50;


        //       AnchorPane.setLeftAnchor(button, 100.0);
    }

    @FXML
    private void handleYear1_1ButtonOnClick(ActionEvent actionEvent){
        File fileYear1_1 = new File("subjectYear1_1.txt");
        ObservableList<Subject> itemsYear1_1 =FXCollections.observableArrayList ();
        HashSet<Subject> year1_1 = f.readFromTXTFile(fileYear1_1);
        for (Subject s :
                year1_1) {
            itemsYear1_1.add(s);
        }
        subjectListView.setItems(itemsYear1_1);
    }

    @FXML
    private void handleYear1_2ButtonOnClick(ActionEvent actionEvent){
        File fileYear1_2 = new File("subjectYear1_2.txt");
        ObservableList<Subject> itemsYear1_2 =FXCollections.observableArrayList ();
        HashSet<Subject> year1_2 = f.readFromTXTFile(fileYear1_2);
        for (Subject s :
                year1_2) {
            itemsYear1_2.add(s);
        }
        subjectListView.setItems(itemsYear1_2);
    }

    @FXML
    private void handleYear2_1ButtonOnClick(ActionEvent actionEvent){
        File fileYear2_1 = new File("subjectYear2_1.txt");
        ObservableList<Subject> itemsYear2_1 =FXCollections.observableArrayList ();
        HashSet<Subject> year1_2 = f.readFromTXTFile(fileYear2_1);
        for (Subject s :
                year1_2) {
            itemsYear2_1.add(s);
        }
        subjectListView.setItems(itemsYear2_1);
    }
}
