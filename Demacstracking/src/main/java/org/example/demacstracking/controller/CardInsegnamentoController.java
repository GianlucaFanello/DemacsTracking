package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.dao.FacoltaDao;
import org.example.demacstracking.model.dao.InsegnamentoDao;
import org.example.demacstracking.model.dto.Insegnamento;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class CardInsegnamentoController {

    @FXML
    private Label nome;
    @FXML
    private Label codice;
    @FXML
    private Insegnamento insegnamento;

    private final InsegnamentoDao insegnamentoDao = new InsegnamentoDao();

    public CardInsegnamentoController() throws SQLException {
    }


    public void setDati(Insegnamento insegnamento) {

        this.insegnamento = insegnamento;

        nome.setText(insegnamento.getNome());
        codice.setText(insegnamento.getId());
    }

    public void visualizzaInsegnamento(MouseEvent mouseEvent) throws IOException, SQLException {
        insegnamentoDao.prendiInsegnamentoConId(insegnamento);
        VisualizzazioneCorrente.getInstance().setInsegnamentoCorrente(insegnamento);
        SceneHandler.getInstance().sceneLoader("Insegnamento.fxml");
    }
}
