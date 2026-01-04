package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CardAulaController {
    @FXML
    public Label ubicazione;
    @FXML
    public Label capienza;
    @FXML
    public Label numeroCubo;
    @FXML
    public Label nome;

    public void tastoIcona(MouseEvent mouseEvent) {
        ubicazione.setVisible(true);
        capienza.setVisible(true);
        numeroCubo.setVisible(true);
    }
}
