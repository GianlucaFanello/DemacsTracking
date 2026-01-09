package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.SegreteriaDao;
import org.example.demacstracking.model.dto.strutture.Segreteria;
import org.example.demacstracking.model.dto.strutture.Struttura;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class ModificaSegreteriaController {

    @FXML
    private Button logout;

    @FXML
    private Label errore;

    @FXML
    private TextField ubicazione;

    private Struttura segreteria;

    private final SegreteriaDao segreteriaDao = new SegreteriaDao();

    public void initialize() {
        segreteria = VisualizzazioneCorrente.getInstance().getStruttura();
        errore.setVisible(false);
        inserisciDati();
    }

    private void inserisciDati() {
        ubicazione.setText(segreteria.getUbicazione());
    }

    @FXML
    void tastoAnnulla(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().resetStruttura();
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }

    @FXML
    void tastoInvia(MouseEvent event) throws SQLException, IOException {
        String _ubicazione = ubicazione.getText();

        if (_ubicazione.isEmpty()) {
            errore.setVisible(true);
            return;
        }

        segreteria.setUbicazione(_ubicazione);

        VisualizzazioneCorrente.getInstance().resetStruttura();

        if(!segreteriaDao.modificaSegreteria( (Segreteria) segreteria)) {
            errore.setVisible(true);
            return;
        }

        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }

    @FXML
    void tastoLogOut(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }
}
