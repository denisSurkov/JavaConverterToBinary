package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane SimpleBinary;

    @FXML
    private TextField inputNumToConvert;

    @FXML
    private TextField outputConvertedNum;

    @FXML
    private Button sumbitToConvert;

    @FXML
    private Label errorLabel;

    @FXML
    private Label labelCanBeByte;

    @FXML
    private Label labelCanBeShort;

    @FXML
    private Label labelCanBeInt;

    @FXML
    void initialize() {

        sumbitToConvert.setOnAction(event -> {
            if (checkCanConvert()){
                setResult();
                setCheckedTypes();
            } else {
                setError();
            }
        });
    }

    private void setError(){
        inputNumToConvert.clear();
        errorLabel.setVisible(true);
    }

    private boolean checkCanConvert(){
        String inputData = inputNumToConvert.getText();
        System.out.println(inputData);

        return inputData.matches("-?[0-9]+");
    }

    private void setResult(){
        outputConvertedNum.clear();

        Converter converter = new Converter();
        String inputData = inputNumToConvert.getText();
        long intFromUser = Long.parseLong(inputData);

        String result = converter.convertNumberToBin(intFromUser);
        outputConvertedNum.setText(result);
    }

    private void setCheckedTypes(){
        String styleForUnsucess = getStyleForLabels(false),
                styleForSucess = getStyleForLabels(true);


        labelCanBeByte.setStyle(styleForUnsucess);
        labelCanBeShort.setStyle(styleForUnsucess);
        labelCanBeInt.setStyle(styleForUnsucess);

        String inputData = inputNumToConvert.getText();
        long intFromUser = Long.parseLong(inputData);

        if (Converter.checkCanBeByte(intFromUser)){
            labelCanBeByte.setStyle(styleForSucess);
        }

        if (Converter.checkCanBeShort(intFromUser)){
            labelCanBeShort.setStyle(styleForSucess);
        }

        if (Converter.checkCanBeInt(intFromUser)){
            labelCanBeInt.setStyle(styleForSucess);
        }

    }

    private String getStyleForLabels(boolean success){
        return success ? "-fx-background-color:  #42f448; -fx-background-radius: 45;" :
                "-fx-background-color:   #f45042; -fx-background-radius: 45;";
    }

}

