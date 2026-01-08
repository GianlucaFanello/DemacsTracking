package org.example.demacstracking.controller;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.AulaDao;
import org.example.demacstracking.model.dto.strutture.Aula;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class CardAulaController {
    @FXML
    public Label ubicazione;
    @FXML
    public Label capienza;
    @FXML
    public Label nome;
    @FXML
    public TextArea descrizione;
    @FXML
    private ImageView modifica;
    @FXML
    private ImageView elimina;

    private Aula aula;
    private final AulaDao aulaDao = new AulaDao();

    public void bindEditMode(BooleanProperty editMode) {
            modifica.visibleProperty().bind(editMode);
            modifica.managedProperty().bind(editMode);
    }

    public void bindElimMode(BooleanProperty elimMode) {
            elimina.visibleProperty().bind(elimMode);
            elimina.managedProperty().bind(elimMode);
    }

    public void inserisciDati(Aula a) {
        aula = a;

        nome.setText(a.getNome());
        ubicazione.setText(a.getUbicazione());
        descrizione.setText(a.getDescrizione());
        capienza.setText(String.valueOf(a.getCapienza()));
    }

    public void tastoModifica() throws IOException {
        VisualizzazioneCorrente.getInstance().setStruttura(aula);
        SceneHandler.getInstance().sceneLoader("ModificaAula.fxml");
    }

    public void tastoElimina(MouseEvent mouseEvent) throws SQLException, IOException {
        aulaDao.eliminaAula(aula.getNome(),aula.getCubo());
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }
}
