package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.SegreteriaHandler;
import org.example.demacstracking.model.dto.strutture.Segreteria;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class InserisciSegreteriaController {
    @FXML
    public TextField ubicazione;
    @FXML
    public TextField id;
    @FXML
    public TextField cubo;
    @FXML
    public Label messaggioDiRiuscita;

    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.BACK_SPACE) {
            SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
        }

    }



    public void tastoInvia(MouseEvent mouseEvent) throws SQLException, IOException {
        if(!id.getText().equals("") && !ubicazione.getText().equals("") && !cubo.getText().equals("")) {
            SegreteriaHandler.getInstance().init(Integer.parseInt(id.getText()), ubicazione.getText(), cubo.getText());
            messaggioDiRiuscita.setVisible(true);
            SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
        }
        else {
            messaggioDiRiuscita.setText("Si è verificato un errore!");
            messaggioDiRiuscita.setVisible(true);

        }

    }

    public void tastoLogOut(MouseEvent mouseEvent) {

    }
}
