package org.example.demacstracking.model;

import org.example.demacstracking.model.FactoryMethod.CreaAula;
import org.example.demacstracking.model.FactoryMethod.CreaDistributore;
import org.example.demacstracking.model.FactoryMethod.StrutturaFactory;
import org.example.demacstracking.model.dao.AulaDao;
import org.example.demacstracking.model.dao.DistributoreDao;
import org.example.demacstracking.model.dto.strutture.Aula;
import org.example.demacstracking.model.dto.strutture.Distributore;

import java.sql.SQLException;

public class DistributoreHandler {
    private static DistributoreHandler instance = new DistributoreHandler();

    private static Distributore distributore = new Distributore();

    public static DistributoreHandler getInstance() {
        return instance;
    }

    public void distributoreCreator() {
        StrutturaFactory strutturaFactory = new CreaDistributore();
        distributore = (Distributore) strutturaFactory.creaStruttura();


    }

    public void init(int id,  String ubicazione, String cubo) throws SQLException {
        distributore = new Distributore(id, ubicazione,cubo);
        DistributoreDao distributoreDao = new DistributoreDao();
        distributoreDao.inserisciDistributore(distributore);

    }

}
