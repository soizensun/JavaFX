package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartPage {


    @FXML private Button startGame;

    @FXML
    public void handleStartGameButtonOnClick(ActionEvent actionEvent) {
        Stage stage = (Stage) startGame.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 700, 550);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }
}
