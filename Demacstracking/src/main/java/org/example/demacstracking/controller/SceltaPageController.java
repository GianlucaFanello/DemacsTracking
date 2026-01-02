package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;


import java.io.IOException;

public class SceltaPageController {
    @FXML
    public Button segnalazioni;

    public void tastoIndietro(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ESCAPE) {
            try {
                SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void tastoCubi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaCubo.fxml");
    }

    public void tastoFacolta(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaFacoltaPage.fxml");
    }

    public void tastoHome(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");
    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");


    }

    public void tastoFaiSegnalazione(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("inserisciSegnalazione.fxml");

    }

    public void tastoSegnalazioni(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("ArchivioSegnalazioni.fxml");

    }
}
