package org.example.demacstracking.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;


import java.io.IOException;

public class SceltaPageController {
    public void tastoIndietro(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.BACK_SPACE) {
            try {
                SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void tastoCubi(MouseEvent mouseEvent) {
    }

    public void tastoFacolta(MouseEvent mouseEvent) {
    }

    public void tastoHome(MouseEvent mouseEvent) {
    }

    public void tastoLogOut(MouseEvent mouseEvent) {

    }
}
