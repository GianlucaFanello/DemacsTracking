package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.strutture.Aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AulaDao {

    public AulaDao (){}

    // --- INSERISCI AULA ---
    public boolean aggiungiAula(Aula aula) throws SQLException{
        String query = "INSERT INTO aula (nome,ubicazione,capienza,cubo) VALUES (?,?,?,?)";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, aula.getNome());
            stmt.setString(2, aula.getUbicazione());
            stmt.setInt(3, aula.getCapienza());
            stmt.setString(4, aula.getCubo());
            int inserito = stmt.executeUpdate();

            return inserito > 0;
        }
    }

    // --- ELIMINA AULA ---
    public boolean eliminaAula(String nome, String cubo) throws SQLException{
        String query = "DELETE FROM aula WHERE nome=? AND cubo=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, nome);
            stmt.setString(2, cubo);

            int eliminato = stmt.executeUpdate();
            return eliminato > 0;
        }
    }

    // --- MODIFICA AULA ---
    public boolean modificaAula(Aula aula) throws SQLException{
        String query = "UPDATE aula SET ubicazione=?,capienza=? WHERE cubo=? AND nome=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, aula.getUbicazione());
            stmt.setInt(2, aula.getCapienza());
            stmt.setString(3, aula.getCubo());
            stmt.setString(4, aula.getNome());

            int modificato =  stmt.executeUpdate();
            return modificato>0;
        }
    }
}
