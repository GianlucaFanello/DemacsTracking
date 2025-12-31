package org.example.demacstracking.controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.AulaHandler;
import org.example.demacstracking.model.DistributoreHandler;
import org.example.demacstracking.model.FactoryMethod.CreaAula;
import org.example.demacstracking.model.FactoryMethod.CreaDistributore;
import org.example.demacstracking.model.FactoryMethod.CreaSegreteria;
import org.example.demacstracking.model.FactoryMethod.StrutturaFactory;
import org.example.demacstracking.model.SegreteriaHandler;
import org.example.demacstracking.model.dto.strutture.Distributore;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;

public class CosaInserireController {


    public void tastoInserisciAula(MouseEvent mouseEvent) {
        AulaHandler.getInstance().aulaCreator();

    }

    public void tastoInserisciSegreteria(MouseEvent mouseEvent) {
        SegreteriaHandler.getInstance().SegreteriaCreator();
    }

    public void tastoInserisciDistributore(MouseEvent mouseEvent) {
        DistributoreHandler.getInstance().distributoreCreator();
    }

    public void tastoIndietro(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.BACK_SPACE) {
            SceneHandler.getInstance().sceneLoader("CuboPage.fxml");

        }

    }

    public void tastoLogOut(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("HomePageDemacsTracking.fxml");


    }
}
