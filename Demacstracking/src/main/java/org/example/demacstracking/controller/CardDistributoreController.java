package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CardDistributoreController {
    @FXML
    public Label numeroCubo;
    @FXML
    public Label ubicazione;
    @FXML
    public Label id;

    public void tastoIcona(MouseEvent mouseEvent) {
        numeroCubo.setVisible(true);
        ubicazione.setVisible(true);
    }
}
