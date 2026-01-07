package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.SegnalazioneDao;
import org.example.demacstracking.model.dto.Segnalazione;
import org.example.demacstracking.model.tipoSegnalazioneHandler;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class InserisciSegnalazioneController {
    @FXML
    public TextArea descrizione;
    @FXML
    public Label messaggioDiRiuscita;

    private Segnalazione segnalazione = new Segnalazione();
    private SegnalazioneDao segnalazioneDao = new SegnalazioneDao();

    public void initialize(){
        messaggioDiRiuscita.setVisible(false);
    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");

    }

    public void tastoInvia(MouseEvent mouseEvent) throws SQLException {
        segnalazione = new Segnalazione(descrizione.getText(), UtenteCorrente.getInstance().getUtente().getNome(), tipoSegnalazioneHandler.getInstance().tipoSegnalazione());
        segnalazioneDao.inserisciSegnalazione(segnalazione);
        messaggioDiRiuscita.setVisible(true);

    }
}
