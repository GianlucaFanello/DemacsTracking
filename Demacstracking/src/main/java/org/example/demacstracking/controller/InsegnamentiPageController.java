package org.example.demacstracking.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.example.demacstracking.model.dao.InsegnamentoDao;
import org.example.demacstracking.model.dto.Insegnamento;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class InsegnamentiPageController {

    @FXML
    private Label anno;

    @FXML
    private VBox boxFacolta;

    @FXML
    private Label facolta;

    @FXML
    private Button logout;

    @FXML
    private ScrollPane scrollFacolta;

    @FXML
    private Label errore ;

    private final InsegnamentoDao insegnamentoDao = new InsegnamentoDao();

    private List<Insegnamento> insegnamentoList;

    public void initialize() throws IOException, SQLException {
        insegnamentoList = insegnamentoDao.prendiAllInsegnamentoFacoltaPerAnno();

        errore.setVisible(insegnamentoList.isEmpty());
        errore.setManaged(insegnamentoList.isEmpty());

        inserisciCard();
        int _anno = VisualizzazioneCorrente.getInstance().getAnno();
        anno.setText(String.valueOf(_anno));
        facolta.setText(VisualizzazioneCorrente.getInstance().getFacoltaCorrente().getNome());

    }

    private void inserisciCard() throws IOException {

        for(Insegnamento i: insegnamentoList) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demacstracking/Fxml/CardInsegnamento.fxml"));
            GridPane card = loader.load();

            CardInsegnamentoController controller = loader.getController();
            controller.setDati(i);

            boxFacolta.getChildren().add(card);
        }
    }


    public void tastoIndietro(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().resetAnno();
        SceneHandler.getInstance().sceneLoader("InterniFacolta.fxml");
    }


    public void tastoLogout(MouseEvent event) throws IOException {
        VisualizzazioneCorrente.getInstance().reset();
        UtenteCorrente.getInstance().logout();
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

}

