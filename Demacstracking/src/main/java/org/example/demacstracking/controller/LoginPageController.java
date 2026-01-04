package org.example.demacstracking.controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;

public class LoginPageController {
    public void tastoAccedi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    public void tastoRegistrati(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("RegisterPageD.fxml");
    }

    public void tastoHome(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");
    }
    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.ESCAPE) {
            SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");

        }

    }
}
