package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    void initialize() {
        Converter converter = new Converter();

        sumbitToConvert.setOnAction(event -> {
            outputConvertedNum.clear();

            String inputData = inputNumToConvert.getText();
            System.out.println(inputData);

            if (inputData.matches("-?[0-9]+")) {
                long intFromUser = Long.parseLong(inputData);

                String result = converter.convertNumberToBin(intFromUser);
                outputConvertedNum.setText(result);
            } else {

                inputNumToConvert.clear();
                errorLabel.setVisible(true);
            }

        });
    }

}

