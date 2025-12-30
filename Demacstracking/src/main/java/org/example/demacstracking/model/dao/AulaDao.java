package main.java.org.example.demacstracking.model.dao;

import main.java.org.example.demacstracking.model.db.DBManager;
import main.java.org.example.demacstracking.model.dto.strutture.Aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AulaDao {

    private final Connection connection;

    public AulaDao () throws SQLException {
        connection = DBManager.getInstance().getConnection();
    }

    // --- INSERISCI AULA ---
    public boolean aggiungiAula(Aula aula) throws SQLException{
        String query = "INSERT INTO aula (nome,ubicazione,capienza,cubo) VALUES (?,?,?,?)";

        PreparedStatement stmt = connection.prepareStatement(query);

        int inserito =  stmt.executeUpdate();
        stmt.close();

        return inserito>0;
    }

    // --- ELIMINA AULA ---
    public boolean eliminaAula(String nome, String cubo) throws SQLException{

        String query = "DELETE FROM aula WHERE nome=? AND cubo=?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, nome);
        stmt.setString(2, cubo);

        int eliminato = stmt.executeUpdate();
        stmt.close();

        return eliminato>0;
    }

    // --- MODIFICA AULA ---
    public boolean modificaAula(Aula aula) throws SQLException{
        String query = "UPDATE aula SET ubicazione=?,capienza=? WHERE cubo=? AND nome=?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, aula.getUbicazione());
        stmt.setInt(2, aula.getCapienza());
        stmt.setString(3, aula.getCubo());
        stmt.setString(4, aula.getNome());


        int modificato =  stmt.executeUpdate();
        stmt.close();

        return modificato>0;
    }


}
