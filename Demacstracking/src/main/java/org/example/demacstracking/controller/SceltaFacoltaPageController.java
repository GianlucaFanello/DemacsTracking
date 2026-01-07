package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.example.demacstracking.model.Strategy.RoleStrategy;
import org.example.demacstracking.model.Strategy.StrategyFactory;
import org.example.demacstracking.model.dao.FacoltaDao;
import org.example.demacstracking.model.dto.Facolta;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SceltaFacoltaPageController {

    @FXML
    private Button aggiungi;
    @FXML
    private Button elimina;
    @FXML
    private ScrollPane  scrollPane;
    @FXML
    private GridPane btnGrid;

    private final FacoltaDao facoltaDao = new FacoltaDao();

    public SceltaFacoltaPageController() throws SQLException {
    }

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

    public void tastoHome(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    public void tastoElimina(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("EliminaFacolta.fxml");

    }

    public void tastoAggiungi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("AggiungiFacolta.fxml");
    }

    private void creaGrigliaFacolta() throws SQLException {

        btnGrid.getChildren().clear();
        scrollPane.setFitToWidth(true);

        List<Facolta> allFacolta = facoltaDao.getAllFacolta();

        int col = 0, row = 0;
        for (Facolta f : allFacolta) {

            // ← QUANDO COL=0: NUOVA RIGA → CREA CONSTRAINT!
            if (col == 0) {
                RowConstraints rowConst = new RowConstraints();
                rowConst.setMinHeight(50);
                rowConst.setPrefHeight(50);
                btnGrid.getRowConstraints().add(rowConst);
            }

            Button btnFacolta = new Button(f.getNome());
            btnFacolta.setMaxWidth(Double.MAX_VALUE);
            btnFacolta.getStyleClass().add("buttonCubo");

            btnFacolta.setOnMouseClicked(e -> {
                VisualizzazioneCorrente.getInstance().setFacoltaCorrente(f);
                try {
                    SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            GridPane.setConstraints(btnFacolta, col, row);
            btnGrid.getChildren().add(btnFacolta);

            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }
    }
}
