package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.AulaHandler;
import org.example.demacstracking.model.dto.strutture.Aula;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class InserisciAulaController {
    @FXML
    public TextField nome;
    @FXML
    public TextField ubicazione;
    @FXML
    public TextField capienza;
    @FXML
    public TextField cubo;
    @FXML
    public Label messaggioDiRiuscita;

    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.BACK_SPACE) {
            SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
        }

    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");
    }


    public void tastoInvia(MouseEvent mouseEvent) throws SQLException, IOException {
        if(!nome.getText().equals("") && !ubicazione.getText().equals("") && !capienza.getText().equals("") && !cubo.getText().equals("")) {
            AulaHandler.getInstance().init(nome.getText(), ubicazione.getText(), Integer.parseInt(capienza.getText()), cubo.getText());
            messaggioDiRiuscita.setVisible(true);
            SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
        }
        else {
            messaggioDiRiuscita.setText("Si è verificato un errore!");
            messaggioDiRiuscita.setVisible(true);
        }
    }
}
