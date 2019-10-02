package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Controller {
    @FXML private AnchorPane popup;
    @FXML private ComboBox minuteComboBox;
    @FXML private ComboBox hourComboBox;
    @FXML private Button addTimeButton, submitButton;
    @FXML private ListView<TimeAlarm> timeListView;
    @FXML private Button test, cancleButton;
    @FXML private ImageView imageSolution;
    @FXML private Label exceptionLabel, statusLabel;
    @FXML private TextField submitTextField;
    @FXML private Label hourLabel, minuteLabel, secondLabel, hourLabel1, minuteLabel1, secondLabel1, dot;

    private Media s = new Media((this.getClass().getClassLoader().getResource("sound.mp3").toString()));
    private MediaPlayer sound = new MediaPlayer(s);

    private String cwd = System.getProperty("user.dir");
    private String sep = System.getProperty("file.separator");

    private File jarDir = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    private String p = jarDir.getParentFile().getAbsolutePath();

    File newFile = new File(p + sep + "timeAlramFile.txt");
    FileWriter fileOUT = null;
    BufferedWriter out = null;
    FileReader fileIN = null;
    BufferedReader in = null;

    private int currentIDExer;

    private int count = 0;
    ObservableList<TimeAlarm> timeAlarmsList = FXCollections.observableArrayList();

    HashMap<Integer, Exersice> exersiceHashMap = new HashMap<>();

    Image zero = new Image("imageExersice" + "/" + "0.png");
    Image one = new Image("imageExersice" + "/" + "1.png");
    Image two = new Image("imageExersice" + "/" + "2.png");
    Image three = new Image("imageExersice" + "/" + "3.png");
    Image four = new Image("imageExersice" + "/" + "4.png");
    Image five = new Image("imageExersice" + "/" + "5.png");
    Image six = new Image("imageExersice" + "/" + "6.png");
    Image seven = new Image("imageExersice" + "/" + "7.png");
    Image eight = new Image("imageExersice" + "/" + "8.png");
    Image nine = new Image("imageExersice" + "/" + "6.png");
    Image ten = new Image("imageExersice" + "/" + "0.png");
    Exersice ex0 = new Exersice(zero, "1");
    Exersice ex1 = new Exersice(one, "9");
    Exersice ex2 = new Exersice(two, "5");
    Exersice ex3 = new Exersice(three, "100.5");
    Exersice ex4 = new Exersice(four, "5");
    Exersice ex5 = new Exersice(five, "15");
    Exersice ex6 = new Exersice(six, "70");
    Exersice ex7 = new Exersice(seven, "55");
    Exersice ex8 = new Exersice(eight, "9");
    Exersice ex9 = new Exersice(nine, "70");
    Exersice ex10 = new Exersice(ten, "1");

    ObservableList<String> hourList = FXCollections.observableArrayList("00",
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        "21", "22", "23");
    ObservableList<String> minuteList = FXCollections.observableArrayList("00",
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
        "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
        "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
        "51", "52", "53", "54", "55", "56", "57", "58", "59");

    @FXML
    public void initialize() {
        String cwd = System.getProperty("user.dir");
        System.out.println(cwd);
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                timerTick();
                Platform.runLater(()->{
                    LocalTime c = LocalTime.now();
                    int minutes = c.getMinute();
                    int hours = c.getHour();
                    int second = c.getSecond();
                    hourLabel.setText(hours + "");
                    minuteLabel.setText(minutes + "");
                    secondLabel.setText(second + "");
                    hourLabel1.setText(hours + "");
                    minuteLabel1.setText(minutes + "");
                    secondLabel1.setText(second + "");
                });
            }
        },0,1000);

        hourComboBox.setItems(hourList);
        minuteComboBox.setItems(minuteList);
        try {
            if(!newFile.createNewFile()){
                readFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        popup.setVisible(false);
        exceptionLabel.setVisible(false);
        exersiceHashMap.put(0, ex0);
        exersiceHashMap.put(1, ex1);
        exersiceHashMap.put(2, ex2);
        exersiceHashMap.put(3, ex3);
        exersiceHashMap.put(4, ex4);
        exersiceHashMap.put(5, ex5);
        exersiceHashMap.put(6, ex6);
        exersiceHashMap.put(7, ex7);
        exersiceHashMap.put(8, ex8);
        exersiceHashMap.put(9, ex9);
        exersiceHashMap.put(10, ex10);


    }

    public void writeFile(){
        try {
            fileOUT = new FileWriter(newFile);
            out = new BufferedWriter(fileOUT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (TimeAlarm a : timeAlarmsList) {
            try {
                out.write(a.toString());
                out.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readFile(){
        try {
            fileIN = new FileReader(newFile);
            in = new BufferedReader(fileIN);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean cont = true;

        try {
            String line = "";
            while((line =  in.readLine()) != null){
                TimeAlarm timeAlarm = new TimeAlarm("", "");
                timeAlarm.setSetHour(line.split("  :  ")[0]);
                timeAlarm.setSetMinutes(line.split("  :  ")[1]);
                timeAlarmsList.add(timeAlarm);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeListView.setItems(timeAlarmsList);
    }


    public void setupPopupAnchorPane(){
        Exersice ex = null;
        int randomID = (int) (10 * Math.random());
        currentIDExer = randomID;
        ex = exersiceHashMap.get(randomID);
        imageSolution.setImage(ex.getImageSolution());
        imageSolution.setFitHeight(500);
        imageSolution.setFitWidth(500);

        sound.setAutoPlay(true);
        sound.play();

        cancleButton.setVisible(false);
        submitTextField.setVisible(true);
        submitButton.setVisible(true);
    }

    @FXML
    public void handleSubmitButtonOnClick(ActionEvent actionEvent){
        String s = submitTextField.getText();
        Exersice ex = null;
        ex = exersiceHashMap.get(currentIDExer);
        if(s.equals(ex.getAnswer())){
            cancleButton.setVisible(true);
            submitButton.setVisible(false);
            submitTextField.setVisible(false);
            statusLabel.setVisible(false);
        }
        else {
            statusLabel.setText("Your answer is not correct.");
        }
        submitTextField.setText("");
    }

    public void timerTick() {
        LocalTime c = LocalTime.now();
        int minutes = c.getMinute();
        int hours = c.getHour();
        int second = c.getSecond();

        for (TimeAlarm a : timeAlarmsList) {
            if((Integer.parseInt(a.getSetHour()) == hours ) && ( Integer.parseInt(a.getSetMinutes()) == minutes) && count == 0) {
                popup.setVisible(true);
                setupPopupAnchorPane();
                count = 1;
            }
            if((59 == second) && ( Integer.parseInt(a.getSetMinutes()) == minutes)){
                count = 0;
            }
        }
    }
private ArrayList<TimeAlarm> checkDupTime = new ArrayList<>();
    @FXML
    public void handleAddTimeButtonOnClick(ActionEvent actionEvent){
        String hour = (String) hourComboBox.getValue();
        String minutes = (String) minuteComboBox.getValue();
        if((hour != null) && (minutes != null)) {
            timeAlarmsList.add(new TimeAlarm(hour, minutes));
            timeListView.setItems(timeAlarmsList);
            writeFile();
            exceptionLabel.setVisible(false);
        }
        else{
            exceptionLabel.setVisible(true);
            exceptionLabel.setText("Please select hour & minute. !!!");
        }
    }



    @FXML
    public void handleDeleteButtonOnClick(ActionEvent actionEvent){
        ObservableList<TimeAlarm> timeAlarm;
        timeAlarm = timeListView.getSelectionModel().getSelectedItems();
        System.out.println(timeAlarm);
        if(timeAlarm.toString() != "[]"){
            int index = 0;
            for (TimeAlarm a : timeAlarmsList) {
                String aa = "[" + a.toString() + "]";
                if(aa.equals(timeAlarm.toString())){
                    index += 0;
                    break;
                }
                else index += 1;
            }
            timeAlarmsList.remove(index, index + 1);
            writeFile();
            timeListView.setItems(timeAlarmsList);
            exceptionLabel.setVisible(false);
        }
        else {
            exceptionLabel.setVisible(true);
            exceptionLabel.setText("Please select time before you delete.!!");
        }
    }

    @FXML
    public void handleCancleButtonOnClick(ActionEvent actionEvent){
        popup.setVisible(false);
        sound.stop();
    }

}
