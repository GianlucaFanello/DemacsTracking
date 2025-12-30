package main.java.org.example.demacstracking.model.dao;

import main.java.org.example.demacstracking.model.db.DBManager;
import main.java.org.example.demacstracking.model.dto.Facolta;

import java.sql.*;

public class FacoltaDao {

    private final Connection connection;

    public FacoltaDao() throws SQLException {
        this.connection = DBManager.getInstance().getConnection();
    }


    // --- INSERIRE UNA NUOVA FACOLTA' ---
    public boolean inserisciFacolta(Facolta facolta) throws SQLException{

        String query = "INSERT INTO facolta(nome,durata,cfu,descrizione,dipartimento,lingua) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, facolta.getNome());
        stmt.setInt(2, facolta.getDurata());
        stmt.setInt(3, facolta.getCfu());
        stmt.setString(4, facolta.getDescrizione());
        stmt.setString(5, facolta.getDipartimento());
        stmt.setString(6, facolta.getLingua());

        int inserito = stmt.executeUpdate();
        stmt.close();
        return inserito > 0;
    }


    // --- ELIMINA UNA FACOLTA' ---
    public boolean eliminaFacolta(String nome) throws SQLException{
        String query = "DELETE FROM facolta WHERE nome=?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, nome);

        int eliminato = stmt.executeUpdate();
        stmt.close();
        return eliminato > 0;
    }

    // --- MODIFICA UNA FACOLTA' ---
    public boolean modificaFacolta(Facolta facolta) throws SQLException{
        String query = "UPDATE facolta SET durata=?, cfu=?, descrizione=?, dipartimento=?, lingua=? WHERE nome=? ";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, facolta.getDurata());
        stmt.setInt(2, facolta.getCfu());
        stmt.setString(3, facolta.getDescrizione());
        stmt.setString(4, facolta.getDipartimento());
        stmt.setString(5, facolta.getLingua());
        stmt.setString(6, facolta.getNome());

        int modificato = stmt.executeUpdate();
        stmt.close();
        return modificato > 0;
    }

    // --- RECUPERA UNA FACOLTA' DALLA CHIAVE PRIMARIA
    public Facolta getFacolta(String nome) throws SQLException{
        String query = "SELECT * FROM facolta WHERE nome=?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, nome);

        ResultSet rs = stmt.executeQuery();
        Facolta facolta = null;
        if(rs.next()){
            int durate = rs.getInt("durata");
            int cfu = rs.getInt("cfu");
            String descrizione = rs.getString("descrizione");
            String dipartimento  = rs.getString("dipartimento");
            String lingua = rs.getString("lingua");
            facolta = new Facolta(nome,  durate, cfu, descrizione, dipartimento, lingua);
        }

        stmt.close();
        return facolta;
    }








}
