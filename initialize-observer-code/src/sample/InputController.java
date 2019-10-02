package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class InputController implements Subject{
    @FXML TextField inputText;
    @FXML ChoiceBox unitSelector;
    @FXML Button submitBtn;

    ArrayList<Observer> observerArrayList;

    public void initialize(){

        observerArrayList = new ArrayList<>();
        createEnglishStage();
        createMetricStage();
        unitSelector.getItems().addAll("kg", "lb", "ตำลึง");
        unitSelector.setValue("kg");

        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                notification();
            }
        });


    }


    public void createEnglishStage(){
        Stage engStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("englishSystem.fxml"));
            engStage.setTitle("EnglishSystem");
            engStage.setScene(new Scene(loader.load(), 300, 275));

            EnglishSystemController esc = (EnglishSystemController) loader.getController();
            registerObserver(esc);

            engStage.setX(0);
            engStage.setY(0);
            engStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createMetricStage(){
        Stage metricStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("metricSystem.fxml"));
            metricStage.setTitle("MetricSystem");
            metricStage.setScene(new Scene(loader.load(), 300, 275));

            MetricSystemController msc = (MetricSystemController) loader.getController();
            registerObserver(msc);



            metricStage.setX(0);
            metricStage.setY(310);
            metricStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observerArrayList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerArrayList.remove(observer);
    }

    @Override
    public void notification() {
        for (Observer o :
                observerArrayList) {
            o.update(Double.parseDouble(inputText.getText()), String.valueOf(unitSelector.getValue()));
        }
    }
}
