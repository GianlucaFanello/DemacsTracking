package org.example.demacstracking.controller;

import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;


import java.io.IOException;

public class SceltaAccessoController {

    public void tastoOspite(MouseEvent mouseEvent) {
        try {
            SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
        } catch (IOException e) {

        }
    }

    public void tastoAccedi(MouseEvent mouseEvent) {
        try {
            SceneHandler.getInstance().sceneLoader("LoginPage.fxml");
        } catch (IOException e) {

        }
    }

    public void tastoRegistrati(MouseEvent mouseEvent) {
        try {
            SceneHandler.getInstance().sceneLoader("RegisterPage.fxml");
        } catch (IOException e) {

        }

    }
}
