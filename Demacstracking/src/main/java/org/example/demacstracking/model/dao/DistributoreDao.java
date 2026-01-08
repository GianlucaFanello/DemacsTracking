package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.strutture.Distributore;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistributoreDao {

    public DistributoreDao() {}

    // --- INSERISCI UN DISTRIBUTORE ---
    public boolean inserisciDistributore(Distributore distributore) throws SQLException {
        String query = "INSERT INTO distributore (ubicazione,cubo) VALUES (?,?)";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, distributore.getUbicazione());
            stmt.setString(2, distributore.getCubo());

            int inserito = stmt.executeUpdate();
            return inserito > 0;
        }
    }

    // --- ELIMINA DISTRIBUTORE ---
    public boolean eliminaDistributore(Distributore distributore) throws SQLException {
        String query = "DELETE FROM distributore WHERE id=? AND cubo=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query);
        ) {
            stmt.setInt(1, distributore.getId());
            stmt.setString(2, distributore.getCubo());

            int eliminato = stmt.executeUpdate();
            return eliminato > 0;
        }
    }

    // --- MODIFICA DISTRIBUTORE ---
    public boolean modificaDistributore(Distributore distributore) throws SQLException {
        String query = "UPDATE distributore SET  ubicazione=? WHERE id=? AND cubo=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, distributore.getUbicazione());
            stmt.setInt(2, distributore.getId());
            stmt.setString(3, distributore.getCubo());

            int modificato = stmt.executeUpdate();
            return modificato > 0;
        }
    }

    public List<Distributore> getAllDistributori() throws SQLException {
        String query = "SELECT * FROM distributore WHERE cubo=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, VisualizzazioneCorrente.getInstance().getCuboCorrente().getNome());

            List<Distributore> distributori = new ArrayList<>();

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String ubicazione = rs.getString("ubicazione");
                String cubo = rs.getString("cubo");

                Distributore distributore = new Distributore(id, ubicazione, cubo);
                distributori.add(distributore);
            }
            return distributori;
        }
    }
}
