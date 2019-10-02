package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML private PasswordField addWordPasswordField;
    @FXML private Button addWordButton;
    @FXML private Button addAlphabetButton;
    @FXML private Button restartButton;
    @FXML private TextField addAlphabetTextField;
    @FXML private ImageView dollImageView;
    @FXML private Label showResultLabel;
    @FXML private Label showKeeperLabel;
    @FXML private Label showException;
    private HangMan hangMan;


    @FXML
    public void initialize(){
        String cwd = System.getProperty("user.dir");
        System.out.println(cwd);

            showResultLabel.setText("");
            showResultLabel.setStyle("-fx-font-size: 48px");
            showKeeperLabel.setText("");
            showKeeperLabel.setStyle("-fx-font-size: 30px");
            showException.setText("");
            showException.setStyle("-fx-font-size: 22px");
            addAlphabetButton.setVisible(false);
            addAlphabetTextField.setVisible(false);
            dollImageView.setImage(new Image("dollimage/6.png"));
            dollImageView.setFitHeight(500);
            dollImageView.setFitWidth(580);
            addWordButton.setVisible(true);
            addWordPasswordField.setVisible(true);
            restartButton.setVisible(false);

    }

    @FXML
    public void handleRestartButtonOnClick(){
        initialize();
    }


    @FXML
    public void handleAddWordButtonOnClick(ActionEvent actionEvent){
        String input = addWordPasswordField.getText();
        hangMan = new HangMan(input);
        addWordPasswordField.setText("");
        System.out.println(hangMan.getResult());
        showResultLabel.setText(hangMan.getResult());
        dollImageView.setFitHeight(500);
        dollImageView.setFitWidth(580);
        addAlphabetButton.setVisible(true);
        addAlphabetTextField.setVisible(true);
        addWordButton.setVisible(false);
        addWordPasswordField.setVisible(false);

    }

    @FXML
    public void handleAddlphabetButtonOnClick(ActionEvent actionEvent){
        showException.setText("");
        String s = addAlphabetTextField.getText();
        try {
            hangMan.check(s.charAt(0));
        } catch (IllegalArgumentException e) {
            showException.setText(e.getMessage());
        } catch (StringIndexOutOfBoundsException e) {
            showException.setText("Please enter character!!");
        }
        addAlphabetTextField.setText("");
        showResultLabel.setText(hangMan.getResult());
        dollImageView.setImage(new Image("dollimage/" + hangMan.getLife() + ".png"));

        showKeeperLabel.setText(hangMan.getKeeper());
        if(hangMan.isWin()){
            showKeeperLabel.setText("Y O U   W I N");
            addAlphabetButton.setVisible(false);
            addAlphabetTextField.setVisible(false);
            restartButton.setVisible(true);
        }
        if(hangMan.getLife() == 0) {
            showKeeperLabel.setText("G A M E  O V E R");
            showKeeperLabel.setStyle("-fx-font-size: 30px");
            addAlphabetButton.setVisible(false);
            addAlphabetTextField.setVisible(false);
            showResultLabel.setText(hangMan.getWord());
            restartButton.setVisible(true);

        }


    }
}
