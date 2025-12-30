package main.java.org.example.demacstracking.model.dao;

import main.java.org.example.demacstracking.model.db.DBManager;
import main.java.org.example.demacstracking.model.dto.strutture.Distributore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DistributoreDao {

    private final Connection connection;

    public DistributoreDao() throws SQLException {
        connection = DBManager.getInstance().getConnection();
    }

    // --- INSERISCI UN DISTRIBUTORE ---
    public boolean inserisciDistributore(Distributore distributore) throws SQLException {
        String query = "INSERT INTO distributore (id,ubicazione,cubo) VALUES (?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, distributore.getId());
        stmt.setString(2, distributore.getUbicazione());
        stmt.setString(3, distributore.getCubo());

        int inserito =  stmt.executeUpdate();
        stmt.close();

        return inserito > 0;
    }

    // --- ELIMINA DISTRIBUTORE ---
    public boolean eliminaDistributore(Distributore distributore) throws SQLException {
        String query = "DELETE FROM distributore WHERE id=? AND cubo=?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, distributore.getId());

        int eliminato =  stmt.executeUpdate();
        stmt.close();
        return eliminato > 0;
    }

    // --- MODIFICA DISTRIBUTORE ---
    public boolean modificaDistributore(Distributore distributore) throws SQLException {
        String query = "UPDATE distributore SET  ubicazione=? WHERE id=? AND cubo=?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, distributore.getUbicazione());
        stmt.setInt(2, distributore.getId());
        stmt.setString(3, distributore.getCubo());

        int modificato =  stmt.executeUpdate();
        stmt.close();
        return modificato > 0;
    }
}
