package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class stockController {
    @FXML private TextField spriteStockTextField;
    @FXML private TextField mountainDewStockTextField;
    @FXML private TextField fantaStockTextField;
    @FXML private TextField drPepperStockTextField;
    @FXML private TextField pepsiStockTextField;
    @FXML private TextField pepsiMaxStockTextField;
    @FXML private TextField cokeStockTextField;
    @FXML private TextField cokeZeroStockTextField;
    @FXML private TextField oneThousandBahtStockTextField;
    @FXML private TextField fiveHundredBahtStockTextField;
    @FXML private TextField oneHundredBahtStockTextField;
    @FXML private TextField fiftyBahtStockTextField;
    @FXML private TextField twentyBahtStockTextField;
    @FXML private TextField tenBahtStockTextField;
    @FXML private TextField fiveBahtStockTextField;
    @FXML private TextField oneBahtStockTextField;

    @FXML public void initialize() throws IOException {
        spriteStockTextField.setText(String.valueOf(stockModel.spriteStock));
        mountainDewStockTextField.setText(String.valueOf(stockModel.mountainDewStock));
        fantaStockTextField.setText(String.valueOf(stockModel.fantaStock));
        drPepperStockTextField.setText(String.valueOf(stockModel.drPepperStock));
        pepsiStockTextField.setText(String.valueOf(stockModel.pepsiStock));
        pepsiMaxStockTextField.setText(String.valueOf(stockModel.pepsiMaxStock));
        cokeStockTextField.setText(String.valueOf(stockModel.cokeStock));
        cokeZeroStockTextField.setText(String.valueOf(stockModel.cokeZeroStock));
        oneThousandBahtStockTextField.setText(String.valueOf(stockModel.oneThousandBaht));
        fiveHundredBahtStockTextField.setText(String.valueOf(stockModel.fiveHundredBaht));
        oneHundredBahtStockTextField.setText(String.valueOf(stockModel.oneHundredBaht));
        fiftyBahtStockTextField.setText(String.valueOf(stockModel.fiftyBaht));
        twentyBahtStockTextField.setText(String.valueOf(stockModel.twentyBaht));
        tenBahtStockTextField.setText(String.valueOf(stockModel.tenBaht));
        fiveBahtStockTextField.setText(String.valueOf(stockModel.fiveBaht));
        oneBahtStockTextField.setText(String.valueOf(stockModel.oneBaht));
    }

    @FXML public void onClickEnterButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("VendingMachine.fxml"));
        stage.setScene(new Scene(root, 600, 600));
        stockModel.spriteStock = Integer.parseInt(spriteStockTextField.getText());
        stockModel.mountainDewStock = Integer.parseInt(mountainDewStockTextField.getText());
        stockModel.fantaStock = Integer.parseInt(fantaStockTextField.getText());
        stockModel.drPepperStock = Integer.parseInt(drPepperStockTextField.getText());
        stockModel.pepsiStock = Integer.parseInt(pepsiStockTextField.getText());
        stockModel.pepsiMaxStock = Integer.parseInt(pepsiMaxStockTextField.getText());
        stockModel.cokeStock = Integer.parseInt(cokeStockTextField.getText());
        stockModel.cokeZeroStock = Integer.parseInt(cokeZeroStockTextField.getText());
        stockModel.oneThousandBaht = Integer.parseInt(oneThousandBahtStockTextField.getText());
        stockModel.fiveHundredBaht = Integer.parseInt(fiveHundredBahtStockTextField.getText());
        stockModel.oneHundredBaht = Integer.parseInt(oneHundredBahtStockTextField.getText());
        stockModel.fiftyBaht = Integer.parseInt(fiftyBahtStockTextField.getText());
        stockModel.twentyBaht = Integer.parseInt(twentyBahtStockTextField.getText());
        stockModel.tenBaht = Integer.parseInt(tenBahtStockTextField.getText());
        stockModel.fiveBaht = Integer.parseInt(fiveBahtStockTextField.getText());
        stockModel.oneBaht = Integer.parseInt(oneBahtStockTextField.getText());
        readAndWriteFileModel.writeFileQuantityDrinks();
        readAndWriteFileModel.writeFileQuantityCash();
    }
    @FXML public void onClickBackButton(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("VendingMachine.fxml"));
        stage.setScene(new Scene(root, 600, 600));
    }
}