package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.SegnalazioneDao;
import org.example.demacstracking.model.dto.Segnalazione;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ArchivioSegnalazioniController {

    @FXML
    private TextArea num1;
    @FXML
    private TextArea num2;
    @FXML
    private TextArea num3;
    @FXML
    private TextArea num4;
    @FXML
    private TextArea num5;

    private static final int pagine = 5;
    private List<Segnalazione> segnalazioniCorrenti;

    private int offset = 0;

    private List<TextArea> textAreas;

    private final SegnalazioneDao segnalazioneDao = new SegnalazioneDao();

    public void initialize() {
        textAreas = List.of(num1, num2, num3, num4, num5);

        try {
            caricaPagina();
        } catch (SQLException e) {
            mostraErrore();
            e.printStackTrace();
        }
    }

    private void caricaPagina() throws SQLException {

        segnalazioniCorrenti =
                segnalazioneDao.prendiSegnalazioni(pagine, offset);

        for (int i = 0; i < textAreas.size(); i++) {
            if (i < segnalazioniCorrenti.size()) {
                textAreas.get(i).setText(segnalazioniCorrenti.get(i).getDescrizione());
                textAreas.get(i).setDisable(false);
                textAreas.get(i).setVisible(true);
            } else {
                textAreas.get(i).clear();
                textAreas.get(i).setDisable(true);
                textAreas.get(i).setVisible(false);
            }
        }
    }

    private void eliminaSegnalazioneIndice(int indice) {
        try {
            if (indice < segnalazioniCorrenti.size()) {
                int id = segnalazioniCorrenti.get(indice).getId();

                boolean eliminata = segnalazioneDao.eliminaSegnalazione(id);

                if (eliminata) {
                    caricaPagina();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            mostraErrore();
        }
    }


    @FXML
    public void tastoSuccessivo(MouseEvent event) throws SQLException {
        if(!num5.getText().equals("")) {
            offset += pagine;
            caricaPagina();
        }

    }

    @FXML
    public void tastoPrecedente(MouseEvent event) throws SQLException {
        if (offset >= pagine) {
                offset -= pagine;
                caricaPagina();
            }

    }

    private void mostraErrore() {
        for (TextArea ta : textAreas) {
            ta.setText("Errore nel caricamento dati");
        }
    }

    public void tastoElimina1(MouseEvent mouseEvent) throws SQLException {
        eliminaSegnalazioneIndice(0);

    }

    public void tastoElimina2(MouseEvent mouseEvent) {
        eliminaSegnalazioneIndice(1);
    }

    public void tastoElimina3(MouseEvent mouseEvent) {
        eliminaSegnalazioneIndice(2);
    }

    public void tastoElimina4(MouseEvent mouseEvent) {
        eliminaSegnalazioneIndice(3);
    }

    public void tastoElimina5(MouseEvent mouseEvent) {
        eliminaSegnalazioneIndice(4);
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaPage.fxml");
    }
}
