package org.example.demacstracking.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.demacstracking.model.FactoryMethod.CreaAula;
import org.example.demacstracking.model.FactoryMethod.StrutturaFactory;
import org.example.demacstracking.model.dao.AulaDao;
import org.example.demacstracking.model.dto.strutture.Aula;
import org.example.demacstracking.model.dto.strutture.Struttura;

import java.io.IOException;
import java.sql.SQLException;

public class AulaHandler {
    private static AulaHandler instance = new AulaHandler();

    private static Aula aula = new Aula();
    public static AulaHandler getInstance() {
        return instance;
    }

    public void aulaCreator() {
        StrutturaFactory strutturaFactory = new CreaAula();
        aula = (Aula) strutturaFactory.creaStruttura();


    }

    public void init(String nome,  String ubicazione, int capienza, String cubo) throws SQLException {
        aula = new Aula(nome, ubicazione, capienza, cubo);
        AulaDao aulaDao = new AulaDao();
        aulaDao.aggiungiAula(aula);

    }


}
