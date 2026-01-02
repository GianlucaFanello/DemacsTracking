package org.example.demacstracking.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;

public class InterniFacoltàController {
    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.ESCAPE) {
            SceneHandler.getInstance().sceneLoader("SceltaFacoltaPage.fxml");


        }

    }

    public void tastoPrimoAnno(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("listaInsegnamenti.fxml");

    }

    public void tastoSecondoAnno(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("listaInsegnamenti.fxml");

    }

    public void tastoTerzoAnno(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("listaInsegnamenti.fxml");

    }

    public void tastoInsegnamento(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("InserisciInsegnamento.fxml");

    }

    public void tastoModifica(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("ModificaFacoltà.fxml");

    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");


    }
}
