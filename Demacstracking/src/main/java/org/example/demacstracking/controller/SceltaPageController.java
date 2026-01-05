package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.Strategy.RoleStrategy;
import org.example.demacstracking.model.Strategy.StrategyFactory;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.view.SceneHandler;


import java.io.IOException;

public class SceltaPageController {

    @FXML
    public Button logout;
    @FXML
    public Button segnala;
    @FXML
    public Button segnalazioni;

    public void initialize() {
        RoleStrategy strategy = StrategyFactory.creaStrategy(UtenteCorrente.getInstance().getStatus());

        segnala.setVisible(strategy.puoSegnalare());
        segnalazioni.setVisible(strategy.puoEliminare());
    }

    public void tastoCubi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaCubo.fxml");
    }

    public void tastoFacolta(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaFacoltaPage.fxml");
    }

    public void tastoLogout(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoSegnala(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("InserisciSegnalazione.fxml");

    }

    public void tastoSegnalazioni(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("ArchivioSegnalazioni.fxml");

    }
}
