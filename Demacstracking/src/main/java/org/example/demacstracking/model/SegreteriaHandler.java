package org.example.demacstracking.model;

import org.example.demacstracking.model.FactoryMethod.CreaAula;
import org.example.demacstracking.model.FactoryMethod.CreaSegreteria;
import org.example.demacstracking.model.FactoryMethod.StrutturaFactory;
import org.example.demacstracking.model.dao.SegreteriaDao;
import org.example.demacstracking.model.dto.strutture.Segreteria;
import org.example.demacstracking.model.dto.strutture.Struttura;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.sql.SQLException;

public class SegreteriaHandler {
    private static SegreteriaHandler instance = new SegreteriaHandler();

    private static Struttura segreteria = new Segreteria();
    public static SegreteriaHandler getInstance() {
        return instance;
    }

    public void SegreteriaCreator() {
        StrutturaFactory strutturaFactory = new CreaSegreteria();
        segreteria = strutturaFactory.creaStruttura();
    }

    public void init(String ubicazione, String cubo) throws SQLException {
        segreteria.setCubo(cubo);
        segreteria.setUbicazione(ubicazione);
        SegreteriaDao segreteriaDao = new SegreteriaDao();
        segreteriaDao.inserisciSegreteria((Segreteria) segreteria);

        segreteria = null ;

    }

}
