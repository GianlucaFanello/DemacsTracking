package org.example.demacstracking.controller;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.SegreteriaDao;
import org.example.demacstracking.model.dto.strutture.Segreteria;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class CardSegreteriaController {
    @FXML
    public Label ubicazione;
    @FXML
    private ImageView modifica;
    @FXML
    private ImageView elimina;

    private final SegreteriaDao segreteriaDao = new SegreteriaDao();
    private Segreteria segreteria;

    public void bindEditMode(BooleanProperty editMode) {
        modifica.visibleProperty().bind(editMode);
        modifica.visibleProperty().bind(editMode);
    }

    public void bindElimMode(BooleanProperty elimMode) {
        elimina.visibleProperty().bind(elimMode);
        elimina.visibleProperty().bind(elimMode);
    }

    public void inserisciDati(Segreteria s) {
        segreteria = s;

        ubicazione.setText(segreteria.getUbicazione());
    }

    public void tastoModifica(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().setStruttura(segreteria);
        SceneHandler.getInstance().sceneLoader("ModificaSegreteria.fxml");
    }

    public void tastoElimina(MouseEvent mouseEvent) throws SQLException, IOException {
        segreteriaDao.eliminaSegreteria(segreteria.getId(),segreteria.getCubo());
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }
}
