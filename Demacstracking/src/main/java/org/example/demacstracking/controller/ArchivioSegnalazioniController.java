package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;

public class ArchivioSegnalazioniController {
    @FXML
    public TextArea num1;
    @FXML
    public TextArea num2;
    @FXML
    public TextArea num3;
    @FXML
    public TextArea num4;
    @FXML
    public TextArea num5;

    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.ESCAPE) {
            SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");


        }

    }

    public void tastoElimina1(MouseEvent mouseEvent) {
        num1.setVisible(false);
    }

    public void tastoElimina2(MouseEvent mouseEvent) {
        num2.setVisible(false);
    }

    public void tastoElimina3(MouseEvent mouseEvent) {
        num3.setVisible(false);
    }

    public void tastoElimina4(MouseEvent mouseEvent) {
        num4.setVisible(false);
    }

    public void tastoElimina5(MouseEvent mouseEvent) {
        num5.setVisible(false);
    }

    public void tastoPrecedente(MouseEvent mouseEvent) {
    }

    public void tastoSuccessivo(MouseEvent mouseEvent) {
    }
}
