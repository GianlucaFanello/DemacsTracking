package org.example.demacstracking.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;

public class InsegnamentoController {
    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.ESCAPE) {
            SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");


        }

    }

    public void modificaButton(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("ModificaInsegnamento.fxml");

    }

    public void tastoElimina(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("eliminaInsegnamento.fxml");

    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");


    }
}
