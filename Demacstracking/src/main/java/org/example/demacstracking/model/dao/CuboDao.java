package main.java.org.example.demacstracking.model.dao;

import main.java.org.example.demacstracking.model.db.DBManager;
import main.java.org.example.demacstracking.model.dto.Cubo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CuboDao {

    private final Connection connection;

    public CuboDao() throws SQLException {
        connection = DBManager.getInstance().getConnection();
    }

    // --- INSERISCI CUBO ---
    public boolean inserisciCubo(Cubo cubo) throws SQLException {
        String query = "insert into cubo (nome) values (?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, cubo.getNome());

        int inserito = stmt.executeUpdate();
        stmt.close();
        return inserito > 0;
    }

    // --- ELIMINA CUBO ---
    public boolean eliminaCubo (Cubo cubo) throws SQLException {
        String query = "DELETE FROM cubo WHERE nome = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, cubo.getNome());

        int elimina = stmt.executeUpdate();
        stmt.close();
        return elimina > 0;
    }
}
