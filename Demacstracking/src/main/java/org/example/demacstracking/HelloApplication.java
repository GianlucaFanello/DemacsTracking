package org.example.demacstracking;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.demacstracking.view.SceneHandler;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Caricamento FXML e Controller
        SceneHandler.getInstance().init(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
