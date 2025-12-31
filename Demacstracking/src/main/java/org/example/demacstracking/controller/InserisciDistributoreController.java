package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.DistributoreHandler;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class InserisciDistributoreController {
    @FXML
    public TextField cubo;
    @FXML
    public TextField ubicazione;
    @FXML
    public Label messaggioDiRiuscita;
    @FXML
    public TextField id;

    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.BACK_SPACE) {
            SceneHandler.getInstance().sceneLoader("CuboPage.fxml");

        }

    }

    public void tastoInvia(MouseEvent mouseEvent) throws IOException, SQLException {
        if(!id.getText().equals("") && !ubicazione.getText().equals("") && !cubo.getText().equals("")) {
            DistributoreHandler.getInstance().init(Integer.parseInt(id.getText()),ubicazione.getText(),cubo.getText());
            messaggioDiRiuscita.setVisible(true);
            SceneHandler.getInstance().sceneLoader("CuboPage.fxml");

        }
    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");


    }


}
