package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String FXML_RESOURCE = "binaryConverter.fxml";
    private static final String APP_TITLE = "Simple binary converter";

    private static final int WIDTH_SCREEN = 600;
    private static final int HEIGHT_SCREEN = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(FXML_RESOURCE));
        primaryStage.setTitle(APP_TITLE);

        primaryStage.setScene(new Scene(root, WIDTH_SCREEN, HEIGHT_SCREEN));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
