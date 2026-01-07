package org.example.demacstracking.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.UtenteDao;
import org.example.demacstracking.model.dto.Utente;
import org.example.demacstracking.service.authService.PasswordService;
import org.example.demacstracking.service.authService.RegistrazioneService;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterPageController {

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCognome;
    @FXML
    private TextField campoUsername;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoPassword;
    @FXML
    private Label errore;

    private UtenteDao utenteDao = new UtenteDao();

    public RegisterPageController() throws SQLException {
    }

    public void initialize(){

        errore.setVisible(false);
    }


    public void tastoRegistrati(ActionEvent actionEvent) throws IOException, SQLException {

        String nome = campoNome.getText().trim();
        String cognome = campoCognome.getText().trim();
        String username = campoUsername.getText().trim();
        String email = campoEmail.getText().trim().toLowerCase();
        String password = campoPassword.getText();

        RegistrazioneService registrazioneService = new RegistrazioneService(utenteDao);
        String result = registrazioneService.registrazione(nome,cognome,username,email,password);
        if (result.equals("OK"))
            SceneHandler.getInstance().sceneLoader("LoginPage.fxml");
        else
            showError(result);
    }


    public void tastoAccedi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("LoginPage.fxml");
    }

    public void tastoOspite(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().setStatus("ospite");
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    private void showError(String s) {
        errore.setText(s);
        errore.setVisible(true);
    }
}
