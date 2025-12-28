package org.example.demacstracking.controller;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CardAulaController {
    public Label ubicazione;
    public Label capienza;
    public Label numeroCubo;

    public void tastoIcona(MouseEvent mouseEvent) {
        ubicazione.setVisible(true);
        capienza.setVisible(true);
        numeroCubo.setVisible(true);
    }
}
