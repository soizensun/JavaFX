package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;

public class vendingMachineController {
    @FXML private Label possibleValueLabel;
    @FXML private TextField insertMoneyTextField;
    @FXML private TextField changeTextField;
    @FXML private CheckBox spriteCheckBox;
    @FXML private CheckBox mountainDewCheckBox;
    @FXML private CheckBox fantaCheckBox;
    @FXML private CheckBox drPepperCheckBox;
    @FXML private CheckBox pepsiCheckBox;
    @FXML private CheckBox pepsiMaxCheckBox;
    @FXML private CheckBox cokeCheckBox;
    @FXML private CheckBox cokeZeroCheckBox;
    private boolean pickSprite, pickMountainDew, pickFanta, pickDrPepper, pickPepsi, pickPepsiMax, pickCoke, pickCokeZero;


    public vendingMachineController(){
        pickSprite = false; pickMountainDew = false; pickFanta = false; pickDrPepper = false;
        pickPepsi = false; pickPepsiMax = false; pickCoke= false; pickCokeZero= false;
    }
    @FXML public void initialize() throws IOException {
        readAndWriteFileModel.readFileQuantityDrinks();
        readAndWriteFileModel.readFileQuantityCash();
        possibleValueLabel.setVisible(false);
        changeTextField.setEditable(false);
        if(stockModel.isSpriteRunOut()){spriteCheckBox.setDisable(true); spriteCheckBox.setStyle("-fx-text-background-color:#FF1434;");} else {spriteCheckBox.setDisable(false);spriteCheckBox.setStyle("-fx-text-background-color:#000000;");}
        if(stockModel.isMountainDewRunOut()){ mountainDewCheckBox.setDisable(true); mountainDewCheckBox.setStyle("-fx-text-background-color:#FF1434;");} else {mountainDewCheckBox.setDisable(false); mountainDewCheckBox.setStyle("-fx-text-background-color:#000000;");}
        if(stockModel.isFantaRunOut()){ fantaCheckBox.setDisable(true); fantaCheckBox.setStyle("-fx-text-background-color:#FF1434;");} else {fantaCheckBox.setDisable(false); fantaCheckBox.setStyle("-fx-text-background-color:#000000;");}
        if(stockModel.isDrPepperRunOut()){ drPepperCheckBox.setDisable(true); drPepperCheckBox.setStyle("-fx-text-background-color:#FF1434;");} else {drPepperCheckBox.setDisable(false); drPepperCheckBox.setStyle("-fx-text-background-color:#000000;");}
        if(stockModel.isPepsiRunOut()){ pepsiCheckBox.setDisable(true); pepsiCheckBox.setStyle("-fx-text-background-color:#FF1434;");} else {pepsiCheckBox.setDisable(false); pepsiCheckBox.setStyle("-fx-text-background-color:#000000;");}
        if(stockModel.isPepsiMaxRunOut()){ pepsiMaxCheckBox.setDisable(true); pepsiMaxCheckBox.setStyle("-fx-text-background-color:#FF1434;");} else {pepsiMaxCheckBox.setDisable(false); pepsiMaxCheckBox.setStyle("-fx-text-background-color:#000000;");}
        if(stockModel.isCokeRunOut()){ cokeCheckBox.setDisable(true); cokeCheckBox.setStyle("-fx-text-background-color:#FF1434;");} else {cokeCheckBox.setDisable(false); cokeCheckBox.setStyle("-fx-text-background-color:#000000;");}
        if(stockModel.isCokeZeroRunOut()){ cokeZeroCheckBox.setDisable(true);cokeZeroCheckBox.setStyle("-fx-text-background-color:#FF1434;");} else {cokeZeroCheckBox.setDisable(false); cokeZeroCheckBox.setStyle("-fx-text-background-color:#000000;");}
    }
    @FXML public void onCheckSpriteBox(ActionEvent actionEvent) throws IOException {
        if (pickSprite==false){
            vendingMachineModel.purchase(17);
            stockModel.purchaseSprite(-1);
            pickSprite = true;
        }else{
            vendingMachineModel.cancelPurchase(17);
            stockModel.purchaseSprite(1);
            pickSprite = false;
        }
    }
    @FXML public void onCheckMountainDewBox(ActionEvent actionEvent) throws IOException {
        if (pickMountainDew==false){
            vendingMachineModel.purchase(23);
            stockModel.purchaseMountainDew(-1);
            pickMountainDew = true;
        }else{
            vendingMachineModel.cancelPurchase(23);
            stockModel.purchaseMountainDew(1);
            pickMountainDew = false;
        }
    }@FXML public void onCheckFantaBox(ActionEvent actionEvent) throws IOException {
        if (pickFanta==false){
            vendingMachineModel.purchase(16);
            stockModel.purchaseFanta(-1);
            pickFanta = true;
        }else{
            vendingMachineModel.cancelPurchase(16);
            stockModel.purchaseFanta(1);
            pickFanta = false;
        }
    }@FXML public void onCheckDrPepperBox(ActionEvent actionEvent) throws IOException {
        if (pickDrPepper==false){
            vendingMachineModel.purchase(25);
            stockModel.purchaseDrPepper(-1);
            pickDrPepper = true;
        }else{
            vendingMachineModel.cancelPurchase(25);
            stockModel.purchaseDrPepper(1);
            pickDrPepper = false;
        }
    }@FXML public void onCheckPepsiBox(ActionEvent actionEvent) throws IOException {
        if (pickPepsi==false){
            vendingMachineModel.purchase(18);
            stockModel.purchasePepsi(-1);
            pickPepsi = true;
        }else{
            vendingMachineModel.cancelPurchase(18);
            stockModel.purchasePepsi(1);
            pickPepsi = false;
        }
    }@FXML public void onCheckPepsiMaxBox(ActionEvent actionEvent) throws IOException {
        if (pickPepsiMax==false){
            vendingMachineModel.purchase(20);
            stockModel.purchasePepsiMax(-1);
            pickPepsiMax = true;
        }else{
            vendingMachineModel.cancelPurchase(20);
            stockModel.purchasePepsiMax(1);
            pickPepsiMax = false;
        }
    }@FXML public void onCheckCokeBox(ActionEvent actionEvent) throws IOException {
        if (pickCoke==false){
            vendingMachineModel.purchase(18);
            stockModel.purchaseCoke(-1);
            pickCoke = true;
        }else{
            vendingMachineModel.cancelPurchase(18);
            stockModel.purchaseCoke(1);
            pickCoke = false;
        }
    }@FXML public void onCheckCokeZeroBox(ActionEvent actionEvent) throws IOException {
        if (pickCokeZero==false){
            vendingMachineModel.purchase(20);
            stockModel.purchaseCokeZero(-1);
            pickCokeZero = true;
        }else{
            vendingMachineModel.cancelPurchase(20);
            stockModel.purchaseCokeZero(1);
            pickCokeZero = false;
        }
    }
    @FXML public void onClickAdminButton(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        stage.setTitle("Admin");
        stage.setScene(new Scene(root, 600, 600));
    }
    @FXML public void onClickEnterButton() throws IOException{
        vendingMachineModel.setInsertMoney(Integer.parseInt(insertMoneyTextField.getText()));
        possibleValueLabel.setVisible(false);
        if (vendingMachineModel.getInsertMoney()>1000 || vendingMachineModel.getInsertMoney()<0 || vendingMachineModel.getInsertMoney()<vendingMachineModel.getTotalValue()){
            possibleValueLabel.setVisible(true);
            insertMoneyTextField.setText("");
        }else{
            stockModel.insertCash(vendingMachineModel.getInsertMoney());
            changeTextField.setText(vendingMachineModel.getChange());
            insertMoneyTextField.setText("");

            readAndWriteFileModel.writeFileQuantityDrinks();
            readAndWriteFileModel.writeFileQuantityCash();
            readAndWriteFileModel.readFileQuantityDrinks();
            readAndWriteFileModel.readFileQuantityCash();

            pickSprite = false; spriteCheckBox.setSelected(false);
            if(stockModel.isSpriteRunOut()){
                spriteCheckBox.setStyle("-fx-text-background-color:#FF1434;");
                spriteCheckBox.setDisable(true);
            } else {
                spriteCheckBox.setStyle("-fx-text-background-color:#000000;");
                spriteCheckBox.setDisable(false);
            }
            pickMountainDew = false; mountainDewCheckBox.setSelected(false);
            if(stockModel.isMountainDewRunOut()){
                mountainDewCheckBox.setStyle("-fx-text-background-color:#FF1434;");
                mountainDewCheckBox.setDisable(true);
            } else {
                mountainDewCheckBox.setStyle("-fx-text-background-color:#000000;");
                mountainDewCheckBox.setDisable(false);
            }
            pickFanta = false; fantaCheckBox.setSelected(false);
            if(stockModel.isFantaRunOut()){
                fantaCheckBox.setStyle("-fx-text-background-color:#FF1434;");
                fantaCheckBox.setDisable(true);
            } else {
                fantaCheckBox.setStyle("-fx-text-background-color:#000000;");
                fantaCheckBox.setDisable(false);
            }
            pickDrPepper = false; drPepperCheckBox.setSelected(false);
            if(stockModel.isDrPepperRunOut()){
                drPepperCheckBox.setStyle("-fx-text-background-color:#FF1434;");
                drPepperCheckBox.setDisable(true);
            } else {
                drPepperCheckBox.setStyle("-fx-text-background-color:#000000;");
                drPepperCheckBox.setDisable(false);
            }
            pickPepsi = false; pepsiCheckBox.setSelected(false);
            if(stockModel.isPepsiRunOut()){
                pepsiCheckBox.setStyle("-fx-text-background-color:#FF1434;");
                pepsiCheckBox.setDisable(true);
            } else {
                pepsiCheckBox.setStyle("-fx-text-background-color:#000000;");
                pepsiCheckBox.setDisable(false);
            }
            pickPepsiMax = false; pepsiMaxCheckBox.setSelected(false);
            if(stockModel.isPepsiMaxRunOut()){
                pepsiMaxCheckBox.setStyle("-fx-text-background-color:#FF1434;");
                pepsiMaxCheckBox.setDisable(true);
            } else {
                pepsiMaxCheckBox.setStyle("-fx-text-background-color:#000000;");
                pepsiMaxCheckBox.setDisable(false);
            }
            pickCoke= false; cokeCheckBox.setSelected(false);
            if(stockModel.isCokeRunOut()){
                cokeCheckBox.setStyle("-fx-text-background-color:#FF1434;");
                cokeCheckBox.setDisable(true);
            } else {
                cokeCheckBox.setStyle("-fx-text-background-color:#000000;");
                cokeCheckBox.setDisable(false);
            }
            pickCokeZero= false;cokeZeroCheckBox.setSelected(false);
            if(stockModel.isCokeZeroRunOut()){
                cokeZeroCheckBox.setStyle("-fx-text-background-color:#FF1434;");
                cokeZeroCheckBox.setDisable(true);
            } else {
                cokeZeroCheckBox.setStyle("-fx-text-background-color:#000000;");
                cokeZeroCheckBox.setDisable(false);
            }

            if(stockModel.isCashRunOut()){
                insertMoneyTextField.setText("No Service.");
                insertMoneyTextField.setStyle("-fx-background-color:#FA93A1;");
                insertMoneyTextField.setEditable(false);
            }else{
                insertMoneyTextField.setText("");
                insertMoneyTextField.setStyle("-fx-background-color:#FFFFFF;");
                insertMoneyTextField.setEditable(true);
            }
        }
    }
}
