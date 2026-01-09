package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.strutture.Distributore;
import org.example.demacstracking.model.dto.strutture.Segreteria;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SegreteriaDao {

    public SegreteriaDao() {}

    // --- INSERISCI SEGRETERIA ---
    public boolean inserisciSegreteria(Segreteria segreteria) throws SQLException {
        String query = "INSERT INTO segreteria (ubicazione,cubo) VALUES (?,?)";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, segreteria.getUbicazione());
            stmt.setString(2, segreteria.getCubo());

            int inserito = stmt.executeUpdate();
            return inserito > 0;
        }
    }

    // --- ELIMINA SEGRETERIA ---
    public boolean eliminaSegreteria(int id, String cubo) throws SQLException {
        String query = "DELETE FROM segreteria WHERE id=? AND cubo=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query);
        ) {
            stmt.setInt(1, id);
            stmt.setString(2, cubo);
            int eliminato = stmt.executeUpdate();
            return eliminato > 0;
        }
    }

    public void eliminaSegreteriaByCubo(String cubo) throws SQLException {
        String query = "DELETE FROM segreteria WHERE cubo=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);
        ){
            stmt.setString(1, cubo);
            stmt.executeUpdate();
        }
    }


    // --- MODIFICA SEGRETERIA ---
    public boolean modificaSegreteria(Segreteria segreteria) throws SQLException {
        String query = "UPDATE segreteria SET ubicazione=? WHERE id=? AND cubo=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query);
        ) {
            stmt.setString(1, segreteria.getUbicazione());
            stmt.setInt(2, segreteria.getId());
            stmt.setString(3, segreteria.getCubo());

            int modifica = stmt.executeUpdate();
            return modifica > 0;
        }
    }

    public List<Segreteria> getAllSegreterie() throws SQLException {
        String query = "SELECT * FROM segreteria WHERE cubo=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, VisualizzazioneCorrente.getInstance().getCuboCorrente().getNome());

            List<Segreteria> segreterie = new ArrayList<>();

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String ubicazione = rs.getString("ubicazione");
                String cubo = rs.getString("cubo");

                Segreteria segreteria = new Segreteria(id, ubicazione, cubo);
                segreterie.add(segreteria);
            }
            return segreterie;
        }
    }

}
