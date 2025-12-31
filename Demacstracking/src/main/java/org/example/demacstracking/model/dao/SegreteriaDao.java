package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.strutture.Segreteria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SegreteriaDao {

    private Connection connection;

    public SegreteriaDao() throws SQLException {
        connection = DBManager.getInstance().getConnection();
    }

    // --- INSERISCI SEGRETERIA ---
    public boolean inserisciSegreteria(Segreteria segreteria) throws SQLException {
        String query = "INSERT INTO segreteria (id,ubicazione,cubo) VALUES (?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, segreteria.getId());
        stmt.setString(2, segreteria.getUbicazione());
        stmt.setString(3, segreteria.getCubo());

        int inserito = stmt.executeUpdate();
        stmt.close();

        return inserito > 0;
    }

    // --- ELIMINA SEGRETERIA ---
    public boolean eliminaSegreteria(int id, String cubo) throws SQLException {
        String query = "DELETE FROM segreteria WHERE id=? AND cubo=?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);

        int eliminato = stmt.executeUpdate();
        stmt.close();

        return eliminato > 0;

    }


    // --- MODIFICA SEGRETERIA ---
    public boolean modificaSegreteria(Segreteria segreteria) throws SQLException {
        String query = "UPDATE segreteria SET ubicazione=? WHERE id=? AND cubo=?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, segreteria.getUbicazione());
        stmt.setInt(2, segreteria.getId());
        stmt.setString(3, segreteria.getCubo());

        int modifica = stmt.executeUpdate();
        stmt.close();

        return modifica > 0;
    }

}
