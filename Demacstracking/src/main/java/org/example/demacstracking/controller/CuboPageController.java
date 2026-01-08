package org.example.demacstracking.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.example.demacstracking.model.Strategy.RoleStrategy;
import org.example.demacstracking.model.Strategy.StrategyFactory;
import org.example.demacstracking.model.dao.AulaDao;
import org.example.demacstracking.model.dao.DistributoreDao;
import org.example.demacstracking.model.dao.SegreteriaDao;
import org.example.demacstracking.model.dto.strutture.Aula;
import org.example.demacstracking.model.dto.strutture.Distributore;
import org.example.demacstracking.model.dto.strutture.Segreteria;
import org.example.demacstracking.service.utenteService.UtenteCorrente;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;
import org.example.demacstracking.view.SceneHandler;

import javax.management.relation.Role;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CuboPageController {
    @FXML
    private Label nome;
    @FXML
    private Button tastoModifica;
    @FXML
    private Button tastoElimina;
    @FXML
    private Button tastoAggiungi;
    @FXML
    private VBox boxAule;
    @FXML
    private VBox boxDistributori;
    @FXML
    private VBox boxSegreterie;

    private final BooleanProperty editMode = new SimpleBooleanProperty(false);
    private final BooleanProperty elimMode = new SimpleBooleanProperty(false);
    
    private final AulaDao aulaDao = new AulaDao();
    
    private final DistributoreDao distributoreDao = new DistributoreDao();
    
    private final SegreteriaDao segreteriaDao = new SegreteriaDao();
    
    public void initialize() throws IOException, SQLException {
        inserisciAule();
        inserisciDistributori();
        inserisciSegreterie();

        nome.setText(VisualizzazioneCorrente.getInstance().getCuboCorrente().getNome());

        gestioneButton();
    }

    private void gestioneButton() {
        RoleStrategy strategy = StrategyFactory.creaStrategy(UtenteCorrente.getInstance().getStatus());
        tastoModifica.setVisible(strategy.puoModificare());
        tastoElimina.setVisible(strategy.puoEliminare());
        tastoAggiungi.setVisible(strategy.puoCreare());
    }

    private void inserisciAule() throws SQLException {

        List<Aula> aule = aulaDao.getAllAule();

        for(Aula a: aule) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/org/example/demacstracking/Fxml/CardAula.fxml")
                );

                Parent card = loader.load();
                CardAulaController controller = loader.getController();
                controller.bindEditMode(editMode);
                controller.bindElimMode(elimMode);
                controller.inserisciDati(a);

                boxAule.getChildren().add(card);
            } catch (IOException e) {

            }
        }
    }

    private void inserisciDistributori() throws SQLException {
        List<Distributore> distributori = distributoreDao.getAllDistributori();

        for(Distributore d: distributori) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/org/example/demacstracking/Fxml/CardDistributore.fxml")
                );

                Parent card = loader.load();
                CardDistributoreController controller = loader.getController();
                controller.bindEditMode(editMode);
                controller.bindElimMode(elimMode);
                controller.inserisciDati(d);

                boxDistributori.getChildren().add(card);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void inserisciSegreterie() throws SQLException {
        List<Segreteria> segreterie = segreteriaDao.getAllSegreterie();

        for(Segreteria s: segreterie) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/org/example/demacstracking/Fxml/CardSegreteria.fxml")
                );

                Parent card = loader.load();
                CardSegreteriaController controller = loader.getController();
                controller.bindEditMode(editMode);
                controller.bindElimMode(elimMode);
                controller.inserisciDati(s);

                boxSegreterie.getChildren().add(card);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void tastoIndietro(MouseEvent mouseEvent) throws IOException {
        VisualizzazioneCorrente.getInstance().resetCubo();
        SceneHandler.getInstance().sceneLoader("SceltaCubo.fxml");
    }

    public void tastoLogout(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("SceltaAccesso.fxml");
    }

    public void tastoAggiungi(MouseEvent mouseEvent) throws IOException {
        SceneHandler.getInstance().sceneLoader("CosaInserire.fxml");
    }

    public void tastoModifica(MouseEvent mouseEvent) {
        editMode.set(!editMode.get());
    }

    public void tastoElimina(MouseEvent mouseEvent) {
        elimMode.set(!elimMode.get());
    }

}
