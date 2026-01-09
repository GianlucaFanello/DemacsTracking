package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.AulaDao;
import org.example.demacstracking.model.dto.strutture.Aula;
import org.example.demacstracking.model.dto.strutture.Struttura;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class ModificaAulaController {

    @FXML
    private Button bottoneInvia;

    @FXML
    private Button buttonAnnulla;

    @FXML
    private TextField capienza;

    @FXML
    private TextArea descrizione;

    @FXML
    private Label errore;

    @FXML
    private Button logout;

    @FXML
    private Label nome;

    @FXML
    private TextField ubicazione;

    private final AulaDao aulaDao = new AulaDao();

    public void initialize(){
        Struttura aula =VisualizzazioneCorrente.getInstance().getStruttura();

        iniserisciDati((Aula) aula);

        errore.setVisible(false);
    }

    private void iniserisciDati(Aula aula) {
        nome.setText(aula.getNome());
        ubicazione.setText(aula.getUbicazione());
        descrizione.setText(aula.getDescrizione());
        capienza.setText(String.valueOf(aula.getCapienza()));
    }

    public void tastoAnnulla(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().resetStruttura();
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }


    public void tastoInvia(MouseEvent event) throws SQLException, IOException {
        String _nome = nome.getText();
        String _ubicazione = ubicazione.getText();
        String _capienza = capienza.getText();
        String _descrizione = descrizione.getText();
        String _cubo = VisualizzazioneCorrente.getInstance().getCuboCorrente().getNome();

        if(_nome.isEmpty() || _ubicazione.isEmpty() || _capienza.isEmpty() || _descrizione.isEmpty() || _cubo.isEmpty()){
            errore.setVisible(true);
            return;
        }

        Aula aula = new Aula(_cubo,_ubicazione,_nome,Integer.parseInt(_capienza),_descrizione);

        if(!aulaDao.modificaAula(aula)) {
            errore.setVisible(true);
            return ;
        }
        VisualizzazioneCorrente.getInstance().resetStruttura();
        SceneHandler.getInstance().sceneLoader("CuboPage.fxml");
    }

    public void tastoLogout(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoHome(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

}
