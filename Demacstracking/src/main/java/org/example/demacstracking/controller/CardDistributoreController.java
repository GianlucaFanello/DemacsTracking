package org.example.demacstracking.controller;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.DistributoreDao;
import org.example.demacstracking.model.dto.strutture.Distributore;
import org.example.demacstracking.model.dto.strutture.Segreteria;
import org.example.demacstracking.model.dto.strutture.Struttura;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;


import java.io.IOException;
import java.sql.SQLException;

public class CardDistributoreController {

    @FXML
    public Label ubicazione;
    @FXML
    private ImageView modifica;
    @FXML
    private ImageView elimina;

    private Struttura distributore;

    private final DistributoreDao distributoreDao = new DistributoreDao();

    public void initialize() {
    }

    public void bindEditMode(BooleanProperty editMode) {
        modifica.visibleProperty().bind(editMode);
        modifica.visibleProperty().bind(editMode);
    }

    public void bindElimMode(BooleanProperty elimMode) {
        elimina.visibleProperty().bind(elimMode);
        elimina.visibleProperty().bind(elimMode);
    }

    public void inserisciDati(Distributore d) {
        distributore = d;

        ubicazione.setText(distributore.getUbicazione());
    }

    public void tastoModifica(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().setStruttura(distributore);
        SceneHandler.getInstance().sceneLoader("ModificaDistributore.fxml");
    }

    public void tastoElimina(MouseEvent mouseEvent) throws SQLException, IOException {
        distributoreDao.eliminaDistributore((Distributore) distributore);
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }
}
