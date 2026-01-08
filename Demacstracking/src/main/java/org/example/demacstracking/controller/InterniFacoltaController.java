package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.Strategy.RoleStrategy;
import org.example.demacstracking.model.Strategy.StrategyFactory;
import org.example.demacstracking.model.dao.InsegnamentoDao;
import org.example.demacstracking.model.dto.Facolta;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

/*
    Per semplicità non è possibile aggiungere una facoltà con numero di anni maggiore di 5
 */

public class InterniFacoltaController {
    @FXML
    private Button tastoModifica;
    @FXML
    private Button tastoAggiungi;

    @FXML
    private Button primoAnno;
    @FXML
    private Button secondoAnno;
    @FXML
    private Button terzoAnno;
    @FXML
    private Button quartoAnno;
    @FXML
    private Button quintoAnno;

    private Button[] buttons;

    @FXML
    private Label nome;
    @FXML
    private Label durata;
    @FXML
    private Label lingua;
    @FXML
    private Label cfu;

    private Facolta facolta;

    private final InsegnamentoDao insegnamentoDao = new InsegnamentoDao();

    public InterniFacoltaController() throws SQLException {
    }

    public void initialize(){
        facolta = VisualizzazioneCorrente.getInstance().getFacoltaCorrente();
        buttons = new Button[]{primoAnno,secondoAnno,terzoAnno,quartoAnno,quintoAnno};
        inserisciDati();
        gestioneButton();
    }

    private void gestioneButton() {
        RoleStrategy strategy = StrategyFactory.creaStrategy(UtenteCorrente.getInstance().getStatus());

        tastoModifica.setVisible(strategy.puoModificare());
        tastoAggiungi.setVisible(strategy.puoCreare());

        for(int i = facolta.getDurata(); i < 5; i++){
            buttons[i].setVisible(false);
            buttons[i].setManaged(false);
        }
    }

    private void inserisciDati() {
        nome.setText(facolta.getNome());
        String d = String.valueOf(facolta.getDurata());
        durata.setText(d);
        String l = String.valueOf(facolta.getLingua());
        lingua.setText(l);
        cfu.setText(String.valueOf(facolta.getCfu()));
    }

    public void tastoPrimoAnno(MouseEvent mouseEvent) throws IOException, SQLException {
        VisualizzazioneCorrente.getInstance().setAnno(1);
        SceneHandler.getInstance().sceneLoader("InsegnamentiPage.fxml");
    }

    public void tastoSecondoAnno(MouseEvent mouseEvent) throws IOException, SQLException {
        VisualizzazioneCorrente.getInstance().setAnno(2);
        SceneHandler.getInstance().sceneLoader("InsegnamentiPage.fxml");
    }

    public void tastoTerzoAnno(MouseEvent mouseEvent) throws IOException, SQLException {
        VisualizzazioneCorrente.getInstance().setAnno(3);
        SceneHandler.getInstance().sceneLoader("InsegnamentiPage.fxml");
    }

    public void tastoQuartoAnno(MouseEvent mouseEvent) throws IOException, SQLException {
        VisualizzazioneCorrente.getInstance().setAnno(4);
        SceneHandler.getInstance().sceneLoader("InsegnamentiPage.fxml");
    }

    public void tastoQuintoAnno(MouseEvent mouseEvent) throws IOException, SQLException {
        VisualizzazioneCorrente.getInstance().setAnno(5);
        SceneHandler.getInstance().sceneLoader("InsegnamentiPage.fxml");
    }

    public void tastoAggiungiInsegnamento(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("AggiungiInsegnamento.fxml");

    }

    public void tastoModifica(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("ModificaFacolta.fxml");
    }

    public void tastoLogout(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().resetFacolta();
        SceneHandler.getInstance().sceneLoader("SceltaFacoltaPage.fxml");
    }
}
