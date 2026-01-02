package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;

public class SceltaCuboController {
    @FXML
    public Button aggiungi;
    @FXML
    public Button elimina;

    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.ESCAPE) {
            SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");


        }

    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");

    }

    public void tastoAggiungi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("inserisciCubo.fxml");

    }

    public void tastoElimina(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("eliminaCubo.fxml");


    }
}
