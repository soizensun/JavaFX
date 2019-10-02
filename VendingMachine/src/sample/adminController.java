package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class adminController {
    @FXML private Label notifyLabel;
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordPasswordField;
    private String admin,password,inputUsername,inputPassword;

    public adminController(){
        this.admin = "admin";
        this.password = "123456789";
    }

    @FXML public void initialize(){
        notifyLabel.setVisible(false);
    }

    @FXML public void onClickEnterButton(ActionEvent actionEvent) throws IOException {
        inputUsername = usernameTextField.getText();
        inputPassword = passwordPasswordField.getText();
        usernameTextField.setText("");
        passwordPasswordField.setText("");
        if (inputUsername.equals(admin) && inputPassword.equals(password)){
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Stock.fxml"));
            stage.setScene(new Scene(root, 600, 600));
        }else {
            notifyLabel.setVisible(true);
        }
    }

    @FXML public void onClickBackButton(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("VendingMachine.fxml"));
        stage.setScene(new Scene(root, 600, 600));
    }
}
