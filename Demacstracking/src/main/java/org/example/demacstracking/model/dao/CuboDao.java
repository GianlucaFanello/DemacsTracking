package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.Cubo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CuboDao {

    public CuboDao() {}

    // --- INSERISCI CUBO ---
    public boolean inserisciCubo(Cubo cubo) throws SQLException {
        String query = "insert into cubo (nome) values (?)";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, cubo.getNome());

            int inserito = stmt.executeUpdate();
            stmt.close();
            return inserito > 0;
        }
    }

    // --- ELIMINA CUBO ---
    public boolean eliminaCubo (Cubo cubo) throws SQLException {
        String query = "DELETE FROM cubo WHERE nome = ?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, cubo.getNome());

            int elimina = stmt.executeUpdate();
            stmt.close();
            return elimina > 0;
        }
    }
}
