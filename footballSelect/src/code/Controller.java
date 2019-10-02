package code;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    private boolean isNoFile;
    private PlayerManager playerManager;
    @FXML
    private Label dfLabel, mfLabel, fwLabel, gkLabel, planLabel;

    @FXML
    public void initialize() {
        isNoFile = false;
        try {
            playerManager = new PlayerManager();
            setPlanLabel("Select Plan First");
        } catch (Exception e) {
            setPlanLabel("No File!");
            isNoFile = true;
        }
    }

    private void setPlanLabel(String plan) {
        planLabel.setText(plan);
    }

    private void setPlayerPositionLabel(int df, int mf, int fw) {
        dfLabel.setText(playerManager.plan("DF", df));
        mfLabel.setText(playerManager.plan("MF", mf));
        fwLabel.setText(playerManager.plan("FW", fw));
        gkLabel.setText(playerManager.plan("GK", 1));
        playerManager.clearSelectedPlayer();
    }

    @FXML
    public void plan442() {
        if (!isNoFile) {
            setPlanLabel("Selected Plan : 4-4-2");
            setPlayerPositionLabel(4, 4, 2);
        } else {
            initialize();
        }
    }

    @FXML
    public void plan451() {
        if (!isNoFile) {
            setPlanLabel("Selected Plan : 4-5-1");
            setPlayerPositionLabel(4, 5, 1);
        } else {
            initialize();
        }
    }

    @FXML
    public void plan433() {
        if (!isNoFile) {
            setPlanLabel("Selected Plan : 4-3-3");
            setPlayerPositionLabel(4, 3, 3);
        } else {
            initialize();
        }
    }

    @FXML
    public void plan343() {
        if (!isNoFile) {
            setPlanLabel("Selected Plan : 3-4-3");
            setPlayerPositionLabel(3, 4, 3);
        } else {
            initialize();
        }
    }
}