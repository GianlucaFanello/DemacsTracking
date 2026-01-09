package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.example.demacstracking.model.dao.AulaDao;
import org.example.demacstracking.model.dao.CuboDao;
import org.example.demacstracking.model.dao.DistributoreDao;
import org.example.demacstracking.model.dao.SegreteriaDao;
import org.example.demacstracking.model.dto.Cubo;
import org.example.demacstracking.model.dto.strutture.Aula;
import org.example.demacstracking.model.dto.strutture.Distributore;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EliminaCuboController {

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

    @FXML
    private Label erroreNoCubo;

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
    private List<Cubo> allCubo;

    private final CuboDao cuboDao = new CuboDao();

    public void initialize() throws SQLException {
        errore.setVisible(false);

        buttonList = new Button[]{elimina1, elimina2, elimina3};
        nomeList = new Label[]{nome1, nome2, nome3};
        panelist = new Pane[] {pane1,pane2,pane3};

        allCubo = cuboDao.getAllCubi();
        erroreNoCubo.setVisible(allCubo.isEmpty());
        errore.setManaged(allCubo.isEmpty());

        mostraCardFacolta();
    }

    public EliminaCuboController() throws SQLException {
    }

    public void tastoLogout(MouseEvent mouseEvent) throws IOException {
        UtenteCorrente.getInstance().logout();
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void  eliminaUno(MouseEvent mouseEvent) throws IOException, SQLException {
        if(!cuboDao.eliminaCubo(nome1.getText())) {
            showError();
            return;
        }
        eliminaStrutture(nome1.getText());
        SceneHandler.getInstance().sceneLoader("EliminaCubo.fxml");
    }

    public void eliminaDue(MouseEvent mouseEvent) throws IOException, SQLException {
        if(!cuboDao.eliminaCubo(nome2.getText())){
            showError();
            return;
        }
        eliminaStrutture(nome2.getText());
        SceneHandler.getInstance().sceneLoader("EliminaCubo.fxml");
    }

    public void eliminaTre(MouseEvent mouseEvent) throws IOException, SQLException {
        if(!cuboDao.eliminaCubo(nome3.getText())) {
            showError();
            return;
        }
        eliminaStrutture(nome3.getText());
        SceneHandler.getInstance().sceneLoader("EliminaCubo.fxml");
    }

    public void tastoSuccessivo(MouseEvent mouseEvent) throws SQLException {
        if (indiceCorrente < allCubo.size()) {
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

    private void eliminaStrutture(String cubo) throws SQLException {

        SegreteriaDao segreteriaDao = new SegreteriaDao();
        DistributoreDao distributoreDao = new DistributoreDao();
        AulaDao aulaDao = new AulaDao();

        segreteriaDao.eliminaSegreteriaByCubo(cubo);
        distributoreDao.eliminaDistributoreByCubo(cubo);
        aulaDao.eliminaAulaByCubo(cubo);
    }


    public void mostraCardFacolta() throws SQLException {
        precedente.setVisible(indiceCorrente != 0);

        successivo.setVisible(indiceCorrente + 3 < allCubo.size());

        int indiceFinale = Math.min(indiceCorrente + 3, allCubo.size());

        for (int i = 0; i < 3; i++) {
            if (indiceCorrente + i < indiceFinale) {
                panelist[i].setVisible(true);
                nomeList[i].setVisible(true);
                nomeList[i].setText(allCubo.get(indiceCorrente + i).getNome());
                buttonList[i].setVisible(true);

            } else {
                nomeList[i].setVisible(false);
                buttonList[i].setVisible(false);
                panelist[i].setVisible(false);
            }
        }
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaCubo.fxml");
    }
}
