package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.DistributoreDao;
import org.example.demacstracking.model.dto.strutture.Distributore;
import org.example.demacstracking.model.dto.strutture.Struttura;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class ModificaDistributoreController {
    @FXML
    private Button annulla;

    @FXML
    private Button bottoneInvia;

    @FXML
    private Label errore;

    @FXML
    private Button logout;

    @FXML
    private TextField ubicazione;

    private final DistributoreDao distributoreDao = new DistributoreDao();

    private Struttura distributore;

    public void initialize(){
        distributore = VisualizzazioneCorrente.getInstance().getStruttura();
        inserisciDati();
        errore.setVisible(false);
    }

    private void inserisciDati() {
        ubicazione.setText(distributore.getUbicazione());
    }

    @FXML
    void tastoAnnulla(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().resetStruttura();
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }

    @FXML
    void tastoHome(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    @FXML
    void tastoInvia(MouseEvent event) throws SQLException, IOException {

        String _ubicazione = ubicazione.getText();

        if (_ubicazione.isEmpty()) {
            errore.setVisible(true);
            return;
        }

        distributore.setUbicazione(_ubicazione);

        VisualizzazioneCorrente.getInstance().resetStruttura();
        if(!distributoreDao.modificaDistributore( (Distributore) distributore)){
            errore.setVisible(true);
            return;
        }

        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }

    @FXML
    void tastoLogout(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }
}
