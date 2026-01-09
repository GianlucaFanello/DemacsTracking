package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
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
import java.time.temporal.UnsupportedTemporalTypeException;

public class ModificaFacoltaController {

    @FXML
    private Label nome;
    @FXML
    private TextField cfu;
    @FXML
    private TextField durata;
    @FXML
    private TextField lingua;

    @FXML
    private Label errore;

    private Facolta facolta;

    private final FacoltaDao facoltaDao = new FacoltaDao();

    public ModificaFacoltaController() throws SQLException {
    }

    public void initialize(){
        facolta = VisualizzazioneCorrente.getInstance().getFacoltaCorrente();
        errore.setVisible(false);
        inserisciDati();
    }

    private void inserisciDati() {
        nome.setText(facolta.getNome());
        String _cfu =  String.valueOf(facolta.getCfu());
        cfu.setText(_cfu);
        String _durata =  String.valueOf(facolta.getDurata());
        durata.setText(_durata);
        lingua.setText(facolta.getLingua());
    }

    public void tastoHome(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    public void tastoInvia(MouseEvent mouseEvent) throws SQLException, IOException {
        String _nome = nome.getText();
        int _cfu = Integer.parseInt(cfu.getText());
        int _durata = Integer.parseInt(durata.getText());
        String _lingua = lingua.getText();

        Facolta _facolta = new Facolta(_nome,_durata,_cfu,facolta.getDipartimento(),_lingua);

        if(!facoltaDao.modificaFacolta(_facolta) ) {
            showError();
            return;
        }

        VisualizzazioneCorrente.getInstance().setFacoltaCorrente(_facolta);
        SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");
    }

    private void showError() {
        errore.setVisible(true);
    }

    public void tastoLogout(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoAnnulla(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");
    }
}
