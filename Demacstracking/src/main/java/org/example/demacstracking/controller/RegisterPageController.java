package org.example.demacstracking.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.UtenteDao;
import org.example.demacstracking.model.dto.Utente;
import org.example.demacstracking.service.PasswordService;
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

        if(nome.isEmpty() || cognome.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()){
            showError("Non tutti i campi sono stati compilati");
            return;
        }

        if(utenteDao.usernamePresente(username)) {
            showError("Username già usato");
            return;
        }

        if(utenteDao.emailPresente(email)){
            showError("Email già presente");
            return;
        }

        /* --- Status può essere utente o admin
        --- Admin è uno solo istanziato all'inizio
         --- Altri Admin possono essere aggiunti in seguito dagli account Admin (NON IMPLEMENTATA) ---
        */
        Utente utente = new Utente(nome, cognome, username, email, "utente");

        String passwordCryptata = PasswordService.passwordCryptata(password);

        if (utenteDao.inserisciUtente(utente, passwordCryptata) )
            SceneHandler.getInstance().sceneLoader("LoginPage.fxml");
        else
            showError("Dati inseriti non corretti");
    }


    public void tastoAccedi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("LoginPage.fxml");
    }

    public void tastoOspite(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    private void showError(String s) {
        errore.setText(s);
        errore.setVisible(true);
    }
}
