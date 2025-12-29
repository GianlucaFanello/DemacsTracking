package main.java.org.example.demacstracking.controller;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CardDistributoreController {
    public Label numeroCubo;
    public Label ubicazione;

    public void tastoIcona(MouseEvent mouseEvent) {
        numeroCubo.setVisible(true);
        ubicazione.setVisible(true);
    }
}
