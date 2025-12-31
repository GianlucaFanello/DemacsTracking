package org.example.demacstracking.model;

import org.example.demacstracking.model.FactoryMethod.CreaAula;
import org.example.demacstracking.model.FactoryMethod.CreaSegreteria;
import org.example.demacstracking.model.FactoryMethod.StrutturaFactory;
import org.example.demacstracking.model.dao.SegreteriaDao;
import org.example.demacstracking.model.dto.strutture.Segreteria;

import java.sql.SQLException;

public class SegreteriaHandler {
    private static SegreteriaHandler instance = new SegreteriaHandler();

    private static Segreteria segreteria = new Segreteria();
    public static SegreteriaHandler getInstance() {
        return instance;
    }

    public void SegreteriaCreator() {
        StrutturaFactory strutturaFactory = new CreaSegreteria();
        segreteria = (Segreteria) strutturaFactory.creaStruttura();


    }

    public void init(int id,  String ubicazione, String cubo) throws SQLException {
        segreteria = new Segreteria(id, ubicazione, cubo);
        SegreteriaDao segreteriaDao = new SegreteriaDao();
        segreteriaDao.inserisciSegreteria(segreteria);

    }

}
