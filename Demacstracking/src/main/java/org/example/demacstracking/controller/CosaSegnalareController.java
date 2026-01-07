package org.example.demacstracking.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.tipoSegnalazioneHandler;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class CosaSegnalareController {
    public void tastoCubo(MouseEvent mouseEvent) throws IOException, SQLException {
        tipoSegnalazioneHandler.getInstance().init("Cubo");
        SceneHandler.getInstance().sceneLoader("inserisciSegnalazione");

    }

    public void tastoFacoltà(MouseEvent mouseEvent) throws IOException, SQLException {
        tipoSegnalazioneHandler.getInstance().init("Facolta");
        SceneHandler.getInstance().sceneLoader("inserisciSegnalazione");
    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");


    }

    public void tastoIndietro(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.BACK_SPACE) {

        }

    }
}
