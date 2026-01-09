package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.Segnalazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SegnalazioneDao {

    public SegnalazioneDao() {}


    // --- METODO PER INSERIRE UNA SEGNALAZIONE ---
    public boolean inserisciSegnalazione(Segnalazione segnalazione) throws SQLException {
        String query = "INSERT INTO segnalazione (descrizione,utente,tipo) VALUES (?,?,?)";

        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, segnalazione.getDescrizione());
            stmt.setString(2, segnalazione.getUtente());
            stmt.setString(3, segnalazione.getTipo());

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



    public List<Segnalazione> prendiSegnalazioni(int limit, int offset) throws SQLException {

        String query = "SELECT * FROM segnalazione ORDER BY id LIMIT ? OFFSET ?";

        List<Segnalazione> lista = new ArrayList<>();

        try (Connection conn = DBManager.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, limit);
            stmt.setInt(2, offset);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Segnalazione s = new Segnalazione(
                        rs.getString("descrizione"),
                        rs.getString("utente"),
                        rs.getString("tipo")
                );
                s.setId(rs.getInt("id"));
                lista.add(s);
            }
        }
        return lista;
    }

}
