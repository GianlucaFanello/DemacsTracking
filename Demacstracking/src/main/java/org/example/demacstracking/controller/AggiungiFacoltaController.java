package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.FacoltaDao;
import org.example.demacstracking.model.dto.Facolta;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class AggiungiFacoltaController {

    @FXML
    private TextField nome;
    @FXML
    private TextField cfu;
    @FXML
    private TextField durata;
    @FXML
    private TextField lingua;
    @FXML
    private Label errore;

    private final FacoltaDao facoltaDao = new FacoltaDao();

    public AggiungiFacoltaController() throws SQLException {
    }

    public void initialize() {
        errore.setVisible(false);
    }

    public void tastoInvia(MouseEvent mouseEvent) throws SQLException, IOException {

        String nome = this.nome.getText().trim();
        String cfu = this.cfu.getText().trim();
        String durata = this.durata.getText().trim();
        String lingua = this.lingua.getText().trim();
        String dipartimento = "Matematica e Informatica";

        if(nome.isEmpty() || cfu.isEmpty() || durata.isEmpty() || lingua.isEmpty()) {
            showErrore("Inserisci i dati mancanti");
            return ;
        }

        if(facoltaDao.nomeFacoltaEsistente(nome)){
            showErrore("Nome Facoltà già esistente");
            return ;
        }

        if(facoltaDao.inserisciFacolta(new Facolta(nome,Integer.parseInt(durata),Integer.parseInt(cfu),dipartimento,lingua))){
            SceneHandler.getInstance().sceneLoader("SceltaFacoltaPage.fxml");
        }
        else {
            showErrore("Errore nella creazione della facolta");
        }
    }

    public void tastoHome(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoAnnulla(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaFacoltaPage.fxml");
    }

    public void showErrore(String s) {
        errore.setText(s);
        errore.setVisible(true);
    }
}
