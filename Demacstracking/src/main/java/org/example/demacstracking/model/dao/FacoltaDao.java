package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.Facolta;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacoltaDao {

    public FacoltaDao() throws SQLException {}


    // --- INSERIRE UNA NUOVA FACOLTA' ---
    public boolean inserisciFacolta(Facolta facolta) throws SQLException{

        String query = "INSERT INTO facolta(nome,durata,cfu,dipartimento,lingua) VALUES (?,?,?,?,?)";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, facolta.getNome());
            stmt.setInt(2, facolta.getDurata());
            stmt.setInt(3, facolta.getCfu());
            stmt.setString(4, facolta.getDipartimento());
            stmt.setString(5, facolta.getLingua());

            int inserito = stmt.executeUpdate();
            return inserito > 0;
        }
    }


    // --- ELIMINA UNA FACOLTA' ---
    public boolean eliminaFacolta(String nome) throws SQLException{
        String query = "DELETE FROM facolta WHERE nome=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, nome);

            int eliminato = stmt.executeUpdate();
            return eliminato > 0;
        }
    }

    // --- MODIFICA UNA FACOLTA' ---
    public boolean modificaFacolta(Facolta facolta) throws SQLException{
        String query = "UPDATE facolta SET durata=?, cfu=?, dipartimento=?, lingua=? WHERE nome=? ";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query);
        ) {
            stmt.setInt(1, facolta.getDurata());
            stmt.setInt(2, facolta.getCfu());
            stmt.setString(3, facolta.getDipartimento());
            stmt.setString(4, facolta.getLingua());
            stmt.setString(5, facolta.getNome());

            int modificato = stmt.executeUpdate();
            return modificato > 0;
        }
    }

    // --- RECUPERA UNA FACOLTA' DALLA CHIAVE PRIMARIA
    public Facolta getFacolta(String nome) throws SQLException {
        String query = "SELECT * FROM facolta WHERE nome=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Facolta facolta = null;
            if (rs.next()) {
                int durate = rs.getInt("durata");
                int cfu = rs.getInt("cfu");
                String dipartimento = rs.getString("dipartimento");
                String lingua = rs.getString("lingua");
                facolta = new Facolta(nome, durate, cfu, dipartimento, lingua);
            }
            return facolta;
        }
    }

    public List<Facolta> getAllFacolta() throws SQLException {
        String query = "SELECT * FROM facolta ORDER BY nome";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query);
        ){
            ResultSet rs = stmt.executeQuery();
            List<Facolta> allFacolta = new ArrayList<>();
            while(rs.next()){
                String nome = rs.getString("nome");
                int durata = rs.getInt("durata");
                int cfu = rs.getInt("cfu");
                String dipartimento = rs.getString("dipartimento");
                String lingua = rs.getString("lingua");

                Facolta f = new Facolta(nome,durata,cfu,dipartimento,lingua);

                allFacolta.add(f);
            }

            return allFacolta;
        }
    }

    public boolean nomeFacoltaEsistente(String nome) throws SQLException {
        String query = "SELECT 1 FROM facolta WHERE nome=?";

        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
        ){
            stmt.setString(1, nome);
            return stmt.executeQuery().next();
        }
    }

}
