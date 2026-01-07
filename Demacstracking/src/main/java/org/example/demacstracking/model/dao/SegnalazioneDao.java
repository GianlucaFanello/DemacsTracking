package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.Segnalazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SegnalazioneDao {

    public SegnalazioneDao() {}


    // --- METODO PER INSERIRE UNA SEGNALAZIONE ---
    public boolean inserisciSegnalazione(Segnalazione segnalazione) throws SQLException {
        String query = "INSERT INTO segnalazione (descrizione,utente,tipo) VALUES (?,?,?)";

        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(2, segnalazione.getDescrizione());
            stmt.setString(3, segnalazione.getUtente());
            stmt.setString(4, segnalazione.getTipo());

            return stmt.executeUpdate() > 0;
        }
    }

    // --- METODO PER ELIMINARE UNA SEGNALAZIONE ---
    public boolean eliminaSegnalazione(int id) throws SQLException {
        String query = "DELETE FROM segnalazione WHERE id=?";

        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
        ) {
           stmt.setInt(1, id);

           return stmt.executeUpdate() > 0;
        }
    }

    // --- METODO PER PRENDE UNA SEGNALAZIONE DALLA SUA PRIMARY KEY
        public Segnalazione  prendiSegnalazioneId(int id) throws SQLException {
            String query = "SELECT * FROM segnalazione WHERE id=?";

            try (Connection connection = DBManager.getInstance().getConnection();
                 PreparedStatement stmt = connection.prepareStatement(query);
            ) {
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                Segnalazione segnalazione  = null ;

                if(rs.next()) {

                    String descrizione = rs.getString("descrizione");
                    String utente = rs.getString("utente");
                    String tipo = rs.getString("tipo");

                    segnalazione = new Segnalazione(descrizione,utente,tipo);
                }
                return segnalazione;
            }
        }
}
