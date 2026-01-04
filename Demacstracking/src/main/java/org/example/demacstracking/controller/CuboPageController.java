package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;

public class CuboPageController {
    @FXML
    public Button modificaTasto;
    @FXML
    public Button aggiungiTasto;
    @FXML
    public ScrollPane aule;
    @FXML
    public ScrollPane distributori;
    @FXML
    public ScrollPane segreteria;


    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.ESCAPE) {
            SceneHandler.getInstance().sceneLoader("SceltaCubo.fxml");
        }
    }

    public void TastoLogOut(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");

    }

    public void tastoAggiungi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("CosaInserire.fxml");

    }

    public void tastoModifica(MouseEvent mouseEvent) throws IOException {
    }
}
