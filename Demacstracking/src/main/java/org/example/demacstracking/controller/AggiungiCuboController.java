package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.CuboDao;
import org.example.demacstracking.model.dto.Cubo;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class AggiungiCuboController {

    @FXML
    private Label errore;
    @FXML
    private TextField nome;

    private CuboDao cuboDao = new CuboDao();

    public void initialize(){
        errore.setVisible(false);
    }


    public void tastoInvia(MouseEvent mouseEvent) throws SQLException, IOException {
        String nome = this.nome.getText().trim();

        if(nome.isEmpty()){
            showError("Compila tutti i campi!");
        }

        if(cuboDao.isCuboPresente(nome))
            showError("Cubo già presente!");

        if(cuboDao.inserisciCubo(new Cubo(nome)) ){
            SceneHandler.getInstance().sceneLoader("SceltaCubo.fxml");
        }
        else {
            showError("Cubo non inserito!");
        }
    }

    private void showError(String s) {
        errore.setText(s);
        errore.setVisible(true);
    }

    public void tastoHome(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }



    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso");
    }

    public void tastoAnnulla(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaCubo.fxml");
    }
}
