package main.java.org.example.demacstracking.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;

public class SceltaInsegnamentiController {
    public void tastoPrecedente(MouseEvent mouseEvent) {
    }

    public void tastoSuccessivo(MouseEvent mouseEvent) {
    }

    public void tastoIndietro(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.BACK_SPACE) {
            try {
                SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
