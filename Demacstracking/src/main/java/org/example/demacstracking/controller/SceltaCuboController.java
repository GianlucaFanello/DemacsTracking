package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.example.demacstracking.model.Strategy.RoleStrategy;
import org.example.demacstracking.model.Strategy.StrategyFactory;
import org.example.demacstracking.model.dao.CuboDao;
import org.example.demacstracking.model.dto.Cubo;
import org.example.demacstracking.model.dto.Facolta;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import javax.swing.text.LabelView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SceltaCuboController {
    @FXML
    public Button aggiungi;
    @FXML
    public Button elimina;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane btnGrid;
    @FXML
    private Label errore;

    private final CuboDao  cuboDao = new CuboDao();

    public void initialize() throws SQLException {
        configuraStrategy();
        creaGrigliaFacolta();
    }

    private void configuraStrategy() {
        RoleStrategy strategy = StrategyFactory.creaStrategy(UtenteCorrente.getInstance().getStatus());

        aggiungi.setVisible(strategy.puoCreare());
        elimina.setVisible(strategy.puoEliminare());
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    public void tastoAggiungi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("AggiungiCubo.fxml");
    }

    public void tastoElimina(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("eliminaCubo.fxml");
    }

    public void tastoHome(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    public void tastoLogout(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    private void creaGrigliaFacolta() throws SQLException {

        btnGrid.getChildren().clear();
        scrollPane.setFitToWidth(true);

        List<Cubo> allCubi = cuboDao.getAllCubi();

        errore.setVisible(allCubi.isEmpty());
        errore.setManaged(allCubi.isEmpty());

        int col = 0, row = 0;
        for (Cubo c : allCubi) {

            // ← QUANDO COL=0: NUOVA RIGA → CREA CONSTRAINT!
            if (col == 0) {
                RowConstraints rowConst = new RowConstraints();
                rowConst.setMinHeight(50);
                rowConst.setPrefHeight(50);
                btnGrid.getRowConstraints().add(rowConst);
            }

            Button btnCubo = new Button("Cubo" + c.getNome());
            btnCubo.setMaxWidth(Double.MAX_VALUE);
            btnCubo.getStyleClass().add("buttonCubo");

            btnCubo.setOnMouseClicked(e -> {
                VisualizzazioneCorrente.getInstance().setCuboCorrente(c);
                try {
                    SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            GridPane.setConstraints(btnCubo, col, row);
            btnGrid.getChildren().add(btnCubo);

            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }
    }
}
