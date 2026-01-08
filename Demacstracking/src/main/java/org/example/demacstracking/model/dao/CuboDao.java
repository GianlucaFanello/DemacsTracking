package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.Cubo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public boolean eliminaCubo (String cubo) throws SQLException {
        String query = "DELETE FROM cubo WHERE nome = ?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, cubo);

            int elimina = stmt.executeUpdate();
            stmt.close();
            return elimina > 0;
        }
    }

    public List<Cubo> getAllCubi() throws SQLException {
        String query = "SELECT * FROM cubo ORDER BY nome";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query);
        ){
            ResultSet rs = stmt.executeQuery();
            List<Cubo> allCubo = new ArrayList<>();
            while(rs.next()){
                String nome = rs.getString("nome");
                Cubo c = new Cubo(nome);

                allCubo.add(c);
            }
            return allCubo;
        }
    }

    public boolean isCuboPresente(String nome) throws SQLException {
        String query = "SELECT 1 FROM cubo WHERE nome = ?";

        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
        ){
            stmt.setString(1, nome);

            return  stmt.executeQuery().next();
        }
    }
}
