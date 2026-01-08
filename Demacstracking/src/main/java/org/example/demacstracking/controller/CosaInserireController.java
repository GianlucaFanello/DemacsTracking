package org.example.demacstracking.controller;

import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.AulaHandler;
import org.example.demacstracking.model.DistributoreHandler;
import org.example.demacstracking.model.SegreteriaHandler;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;

public class CosaInserireController {


    public void tastoInserisciAula(MouseEvent mouseEvent) throws IOException {
        AulaHandler.getInstance().aulaCreator();
        SceneHandler.getInstance().sceneLoader("InserisciAula.fxml");
    }

    public void tastoInserisciSegreteria(MouseEvent mouseEvent) throws IOException {
        SegreteriaHandler.getInstance().SegreteriaCreator();
        SceneHandler.getInstance().sceneLoader("InserisciSegreteria.fxml");
    }

    public void tastoInserisciDistributore(MouseEvent mouseEvent) throws IOException {
        DistributoreHandler.getInstance().distributoreCreator();
        SceneHandler.getInstance().sceneLoader("InserisciDistributore.fxml");
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }

    public void tastoLogout(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }
}
