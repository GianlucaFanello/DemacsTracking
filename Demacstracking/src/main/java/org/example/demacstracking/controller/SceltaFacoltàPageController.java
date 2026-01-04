package org.example.demacstracking.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;

public class SceltaFacoltàPageController {
    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.ESCAPE) {
            SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");


        }

    }

    public void tastoHome(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");

    }

    public void tastoMatematica(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");

    }

    public void tastoInformatica(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");

    }

    public void tastoSfp(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");

    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");

    }

    public void tastoElimina(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("eliminaFacolt.fxml");

    }

    public void tastoAggiungi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("aggiungoFacoltà.fxml");


    }
}
