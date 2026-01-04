package org.example.demacstracking.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.UtenteDao;
import org.example.demacstracking.service.PasswordService;
import org.example.demacstracking.view.SceneHandler;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginPageController {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label errore;

    private UtenteDao utenteDao = new UtenteDao();

    public void initialize(){
        errore.setVisible(false);
    }

    public LoginPageController() throws SQLException {
    }

    public void tastoAccedi(ActionEvent actionEvent) throws IOException, SQLException {

        String emailInserita = email.getText().trim();
        String passwordInserita = password.getText();
        String passwordCryptata = utenteDao.getPasswordByEmail(emailInserita);

        if(emailInserita.isEmpty() || passwordInserita.isEmpty() || passwordCryptata.isEmpty()){
            showError();
            return;
        }

        if (PasswordService.verify(passwordInserita,passwordCryptata))
            SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
        else {
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
            SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    public void showError() {
        errore.setVisible(true);
    }
}
