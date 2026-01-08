package org.example.demacstracking.model;

import org.example.demacstracking.model.FactoryMethod.CreaAula;
import org.example.demacstracking.model.FactoryMethod.StrutturaFactory;
import org.example.demacstracking.model.dao.AulaDao;
import org.example.demacstracking.model.dto.strutture.Aula;

import java.sql.SQLException;

public class AulaHandler {
    private static AulaHandler instance = new AulaHandler();

    private static Aula aula ;
    public static AulaHandler getInstance() {
        return instance;
    }

    public void aulaCreator() {
        StrutturaFactory strutturaFactory = new CreaAula();
        aula = (Aula) strutturaFactory.creaStruttura();
    }

    public void init(String nome,  String ubicazione, int capienza, String cubo,String descrizione) throws SQLException {
        aula.setNome(nome);
        aula.setUbicazione(ubicazione);
        aula.setCapienza(capienza);
        aula.setCubo(cubo);
        aula.setDescrizione(descrizione);

        AulaDao aulaDao = new AulaDao();
        aulaDao.aggiungiAula(aula);

        aula = null ;
    }
}
