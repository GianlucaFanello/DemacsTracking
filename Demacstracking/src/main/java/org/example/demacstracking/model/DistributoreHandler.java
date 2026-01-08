package org.example.demacstracking.model;

import org.example.demacstracking.model.FactoryMethod.CreaDistributore;
import org.example.demacstracking.model.FactoryMethod.StrutturaFactory;
import org.example.demacstracking.model.dao.DistributoreDao;
import org.example.demacstracking.model.dto.strutture.Distributore;
import org.example.demacstracking.model.dto.strutture.Struttura;

import java.sql.SQLException;

public class DistributoreHandler {
    private static DistributoreHandler instance = new DistributoreHandler();

    private static Struttura distributore;

    public static DistributoreHandler getInstance() {
        return instance;
    }

    public void distributoreCreator() {
        StrutturaFactory strutturaFactory = new CreaDistributore();
        distributore = strutturaFactory.creaStruttura();
    }

    public void init(String ubicazione, String cubo) throws SQLException {
        distributore.setCubo(cubo);
        distributore.setUbicazione(ubicazione);

        DistributoreDao distributoreDao = new DistributoreDao();
        distributoreDao.inserisciDistributore((Distributore) distributore);

        distributore = null;
    }

}
