package org.example.demacstracking.model;

import org.example.demacstracking.model.FactoryMethod.CreaSegreteria;
import org.example.demacstracking.model.FactoryMethod.StrutturaFactory;
import org.example.demacstracking.model.dao.SegreteriaDao;
import org.example.demacstracking.model.dto.Segnalazione;
import org.example.demacstracking.model.dto.strutture.Segreteria;

import java.sql.SQLException;

public class tipoSegnalazioneHandler {
    private static tipoSegnalazioneHandler instance = new tipoSegnalazioneHandler();

    private static Segnalazione segnalazione = new Segnalazione();

    public static tipoSegnalazioneHandler getInstance() {
        return instance;
    }

   public String tipoSegnalazione() {
        return segnalazione.getTipo();

   }

    public void init(String tipo) throws SQLException {
        segnalazione = new Segnalazione("", "", tipo);
    }

}
