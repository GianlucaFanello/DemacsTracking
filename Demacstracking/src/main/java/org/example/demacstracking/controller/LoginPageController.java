package org.example.demacstracking.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.UtenteDao;
import org.example.demacstracking.model.dto.Utente;
import org.example.demacstracking.service.authService.LoginService;
import org.example.demacstracking.service.authService.PasswordService;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class LoginPageController {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label errore;

    private final UtenteDao utenteDao = new UtenteDao();

    public void initialize(){
        errore.setVisible(false);
    }

    public LoginPageController() throws SQLException {
    }

    public void tastoAccedi(ActionEvent actionEvent) throws IOException, SQLException {

        String emailInserita = email.getText().trim();
        String passwordInserita = password.getText();

        LoginService  loginService = new LoginService(utenteDao);

        Utente utente = loginService.login(emailInserita,passwordInserita);
        if( utente != null){
            UtenteCorrente.getInstance().setUtente(utente);
            System.out.println(UtenteCorrente.getInstance().getUtente().getEmail());
            SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
        }
        else{
            showError();
        }
    }

    public void tastoRegistrati(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("RegisterPage.fxml");
    }

    public void tastoHome(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoOspite(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().setStatus("ospite");
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    public void showError() {
        errore.setVisible(true);
    }
}
