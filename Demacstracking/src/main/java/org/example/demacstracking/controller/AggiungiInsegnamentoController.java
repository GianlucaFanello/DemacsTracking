package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.FacoltaDao;
import org.example.demacstracking.model.dao.InsegnamentoDao;
import org.example.demacstracking.model.dto.Facolta;
import org.example.demacstracking.model.dto.Insegnamento;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class AggiungiInsegnamentoController {

    @FXML
    private TextField nome;
    @FXML
    private TextField codice;
    @FXML
    private TextField docente;
    @FXML
    private TextField anno;
    @FXML
    private TextField cfu;
    @FXML
    private Label errore;
    @FXML
    private TextArea descrizione;

    private final InsegnamentoDao insegnamentoDao = new InsegnamentoDao();
    private final Facolta facolta;

    public AggiungiInsegnamentoController() {
        facolta = VisualizzazioneCorrente.getInstance().getFacoltaCorrente();
    }

    public void initialize(){
        errore.setVisible(false);
    }

    public void tastoHome(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }

    public void tastoInvia(MouseEvent mouseEvent) throws SQLException, IOException {
        String nome = this.nome.getText().trim();
        String codice = this.codice.getText().trim();
        String docente = this.docente.getText().trim();
        String cfu =  this.cfu.getText().trim();
        String anno = this.anno.getText().trim();
        String descrizione = this.descrizione.getText().trim();


        if(nome.isEmpty() || codice.isEmpty() || docente.isEmpty() ||cfu.isEmpty() ||anno.isEmpty() ||descrizione.isEmpty()){
            showError("Compila tutti i campi!");
            return;
        }

        int _cfu =  Integer.parseInt(cfu);
        Insegnamento insegnamento = new Insegnamento(codice, nome, _cfu,descrizione, docente);

        boolean presente = insegnamentoDao.idPresente(codice);

        if (presente) {
            if (insegnamentoDao.associazionePresente(codice, facolta.getNome())) {
                showError("Insegnamento già presente nella facoltà");
                return;
            }
        } else {
            insegnamentoDao.inserisciInsegnamento(insegnamento);
        }

        insegnamentoDao.inserisciAssociazione(insegnamento, anno, facolta.getNome());

        SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");

    }

    private void showError(String s) {
        errore.setText(s);
        errore.setVisible(true);
    }

    public void tastoLogout(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoAnnulla(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");
    }
}
