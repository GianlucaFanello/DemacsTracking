package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.AulaHandler;
import org.example.demacstracking.model.dao.AulaDao;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class InserisciAulaController {

   @FXML
    public TextArea attrezzatura;
    @FXML
    private TextField nome;
    @FXML
    private TextField ubicazione;
    @FXML
    private TextField capienza;
    @FXML
    private Label errore;

    private final AulaDao  aulaDao =  new AulaDao();

    public void initialize(){
        errore.setVisible(false);
        errore.setManaged(false);
    }

    public void tastoAnnulla(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }


    public void tastoInvia(MouseEvent mouseEvent) throws SQLException, IOException {
        String _nome = nome.getText().trim();
        String _ubicazione = ubicazione.getText().trim();
        String _capienza = capienza.getText().trim();
        String descrizione = attrezzatura.getText().trim();

        if(_nome.isEmpty() || _ubicazione.isEmpty() || _capienza.isEmpty() || descrizione.isEmpty()) {
            showError("Compila tutti i campi!");
            return;
        }

        String cubo = VisualizzazioneCorrente.getInstance().getCuboCorrente().getNome();

        if(aulaDao.aulaPresente(_nome, cubo)) {
            showError("Aula già presente!");
            return;
        }

        AulaHandler.getInstance().init(nome.getText(), ubicazione.getText(), Integer.parseInt(capienza.getText()), cubo, descrizione);
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }

    private void showError(String s) {
        errore.setText(s);
        errore.setVisible(true);
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("CosaInserire.fxml");
    }
}
