package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.Strategy.RoleStrategy;
import org.example.demacstracking.model.Strategy.StrategyFactory;
import org.example.demacstracking.model.dao.InsegnamentoDao;
import org.example.demacstracking.model.dto.Insegnamento;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class InsegnamentoController {

    @FXML
    private Label cfu;

    @FXML
    private Label codice;

    @FXML
    private Label descrizione;

    @FXML
    private Label docente;

    @FXML
    private Button elimina;

    @FXML
    private Button logout;

    @FXML
    private Button modificaButton;

    @FXML
    private Label nome;

    private Insegnamento insegnamento;

    private final InsegnamentoDao insegnamentoDao = new InsegnamentoDao();

    public void initialize() throws SQLException {
        insegnamento = VisualizzazioneCorrente.getInstance().getInsegnamentoCorrente();
        inserisciDati();

        gestioneButton();
    }

    private void gestioneButton() {
        RoleStrategy roleStrategy = StrategyFactory.creaStrategy(UtenteCorrente.getInstance().getStatus());

        modificaButton.setVisible(roleStrategy.puoModificare());
        elimina.setVisible(roleStrategy.puoEliminare());
    }

    private void inserisciDati() throws SQLException {
        cfu.setText(String.valueOf(insegnamento.getCfu()));
        codice.setText(insegnamento.getId());
        descrizione.setText(insegnamento.getDescrizione());
        docente.setText(insegnamento.getDocente());
        nome.setText(insegnamento.getNome());
    }

    public void modificaButton(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("ModificaInsegnamento.fxml");
    }

    public void tastoElimina(MouseEvent mouseEvent) throws IOException, SQLException {
        VisualizzazioneCorrente.getInstance().resetInsegnamento();
        insegnamentoDao.eliminaInsegnamento(insegnamento.getId());
        SceneHandler.getInstance().sceneLoader("InsegnamentiPage.fxml");
    }

    public void tastoLogout(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().resetInsegnamento();
        SceneHandler.getInstance().sceneLoader("InsegnamentiPage.fxml");
    }
}
