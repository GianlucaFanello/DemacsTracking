package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.InsegnamentoDao;
import org.example.demacstracking.model.dto.Insegnamento;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class ModificaInsegnamentoController {

    @FXML
    private TextField anno;

    @FXML
    private Button bottoneInvia;

    @FXML
    private Button bottoneInvia1;

    @FXML
    private TextField cfu;

    @FXML
    private Label codice;

    @FXML
    private TextArea descrizione;

    @FXML
    private TextField docente;

    @FXML
    private Label errore;

    @FXML
    private Button logOut;

    @FXML
    private TextField nome;

    private Insegnamento insegnamento;

    private final InsegnamentoDao  insegnamentoDao = new InsegnamentoDao();

    public void initialize() throws SQLException {
        inserisciDati();
        errore.setVisible(false);
    }

    private void inserisciDati() throws SQLException {
        insegnamento = VisualizzazioneCorrente.getInstance().getInsegnamentoCorrente();

        cfu.setText(String.valueOf(insegnamento.getCfu()));
        codice.setText(insegnamento.getId());
        descrizione.setText(insegnamento.getDescrizione());
        docente.setText(insegnamento.getDocente());
        nome.setText(insegnamento.getNome());
        anno.setText(String.valueOf(VisualizzazioneCorrente.getInstance().getAnno()));
    }

    @FXML
    void tastoAnnulla(MouseEvent event) throws IOException {
        SceneHandler.getInstance().sceneLoader("Insegnamento.fxml");
    }

    @FXML
    void tastoHome(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    @FXML
    void tastoInvia(MouseEvent event) throws SQLException, IOException {
        String _nome = nome.getText();
        String _cfu = cfu.getText();
        String _descrizione = descrizione.getText();
        String _docente = docente.getText();
        String _anno = anno.getText();

        insegnamento.setNome(_nome);
        insegnamento.setCfu(Integer.parseInt(_cfu));
        insegnamento.setDocente(_docente);
        insegnamento.setDescrizione(_descrizione);

        if(!insegnamentoDao.modificaInsegnamento(insegnamento) ||
                !insegnamentoDao.modificaAssociazione(Integer.parseInt(_anno))){
            errore.setVisible(true);
            return;
        }

        VisualizzazioneCorrente.getInstance().setInsegnamentoCorrente(insegnamento);
        SceneHandler.getInstance().sceneLoader("Insegnamento.fxml");
    }

    @FXML
    void tastoLogOut(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("Insegnamento.fxml");


    }
}
