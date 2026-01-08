package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.SegreteriaHandler;
import org.example.demacstracking.model.dto.strutture.Segreteria;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class InserisciSegreteriaController {
    @FXML
    public TextField ubicazione;

    @FXML
    public Label errore;

    public void initialize(){
        errore.setVisible(false);
    }

    public void tastoInvia(MouseEvent mouseEvent) throws SQLException, IOException {
        String _ubicazione =  ubicazione.getText().trim();

        String cubo = VisualizzazioneCorrente.getInstance().getCuboCorrente().getNome();

        if(_ubicazione.isEmpty()) {
            showError("Compila tutti i campi!");
            return;
        }

        SegreteriaHandler.getInstance().init(ubicazione.getText(), cubo);
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");

    }

    private void showError(String s) {
        errore.setText(s);
        errore.setVisible(true);
    }

    public void tastoAnnulla(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }
}
