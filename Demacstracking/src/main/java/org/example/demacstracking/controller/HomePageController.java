package main.java.org.example.demacstracking.controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import main.java.org.example.demacstracking.view.SceneHandler;


import java.io.IOException;

public class HomePageController {

    public void tastoOspite(MouseEvent mouseEvent) {
        try {
            SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tastoAccedi(MouseEvent mouseEvent) {
        try {
            SceneHandler.getInstance().sceneLoader("LoginPage.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tastoRegistrati(MouseEvent mouseEvent) {
        try {
            SceneHandler.getInstance().sceneLoader("RegisterPageD.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
