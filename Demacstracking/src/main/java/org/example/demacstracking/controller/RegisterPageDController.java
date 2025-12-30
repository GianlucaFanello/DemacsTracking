package main.java.org.example.demacstracking.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import main.java.org.example.demacstracking.view.SceneHandler;


import java.io.IOException;

public class RegisterPageDController {
    public void tastoIndietro(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.BACK_SPACE) {
            try {
                SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void tastoRegistrati(MouseEvent mouseEvent) {
    }

    public void labelAccedi(MouseEvent mouseEvent) {

    }
}
