package org.example.demacstracking.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;


import java.io.IOException;

public class RegisterPageDController {
    public void tastoIndietro(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ESCAPE ) {
            try {
                SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void tastoRegistrati(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    public void labelAccedi(MouseEvent mouseEvent) {

    }
}
