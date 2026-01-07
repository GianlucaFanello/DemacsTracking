package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.example.demacstracking.model.dao.FacoltaDao;
import org.example.demacstracking.model.dto.Facolta;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;
import org.springframework.beans.factory.support.ScopeNotActiveException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EliminaFacoltaController {

    @FXML
    private Button precedente;
    @FXML
    private Button successivo;

    @FXML
    private Label errore;

    @FXML
    private Label nome1;
    @FXML
    private Label nome2;
    @FXML
    private Label nome3;

    private Label [] nomeList = null;


    @FXML
    private Button elimina1;
    @FXML
    private Button elimina2;
    @FXML
    private Button elimina3;

    private Button[] buttonList;

    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;

    private Pane[] panelist;


    private int indiceCorrente = 0;
    private List<Facolta> allFacolta;

    private final FacoltaDao facoltaDao = new FacoltaDao();

    public void initialize() throws SQLException {
        errore.setVisible(false);

        buttonList = new Button[]{elimina1, elimina2, elimina3};
        nomeList = new Label[]{nome1, nome2, nome3};
        panelist = new Pane[] {pane1,pane2,pane3};

        allFacolta = facoltaDao.getAllFacolta();
        mostraCardFacolta();
    }

    public EliminaFacoltaController() throws SQLException {
    }

    public void tastoLogout(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void  eliminaUno(MouseEvent mouseEvent) throws IOException, SQLException {
        if(!facoltaDao.eliminaFacolta(nome1.getText()))
            showError();
        SceneHandler.getInstance().sceneLoader("EliminaFacoltaPage.fxml");
    }

    public void eliminaDue(MouseEvent mouseEvent) throws IOException, SQLException {
        if(!facoltaDao.eliminaFacolta(nome2.getText()))
            showError();
        SceneHandler.getInstance().sceneLoader("EliminaFacoltaPage.fxml");
    }

    public void eliminaTre(MouseEvent mouseEvent) throws IOException, SQLException {
        if(!facoltaDao.eliminaFacolta(nome3.getText()))
            showError();
        SceneHandler.getInstance().sceneLoader("EliminaFacoltaPage.fxml");
    }

    public void tastoSuccessivo(MouseEvent mouseEvent) throws SQLException {
        if (indiceCorrente < allFacolta.size()) {
            indiceCorrente += 3;
            mostraCardFacolta();
        }
    }

    public void tastoPrecedente(MouseEvent mouseEvent) throws SQLException {
        if (indiceCorrente >= 3) {
            indiceCorrente -= 3;
            mostraCardFacolta();
        }
    }

    private void showError() {
        errore.setVisible(true);
    }


    public void mostraCardFacolta() throws SQLException {
        precedente.setVisible(indiceCorrente != 0);

        successivo.setVisible(indiceCorrente + 3 < allFacolta.size());

        int indiceFinale = Math.min(indiceCorrente + 3, allFacolta.size());

        for (int i = 0; i < 3; i++) {
            if (indiceCorrente + i < indiceFinale) {
                panelist[i].setVisible(true);
                nomeList[i].setVisible(true);
                nomeList[i].setText(allFacolta.get(indiceCorrente + i).getNome());
                buttonList[i].setVisible(true);

            } else {
                nomeList[i].setVisible(false);
                buttonList[i].setVisible(false);
                panelist[i].setVisible(false);
            }
        }
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaFacoltaPage.fxml");
    }
}

