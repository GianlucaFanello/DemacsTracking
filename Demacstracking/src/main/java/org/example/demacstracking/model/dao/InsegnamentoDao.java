package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.Insegnamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsegnamentoDao {

    public InsegnamentoDao() {}

    public boolean  inserisciInsegnamento(Insegnamento insegnamento) throws SQLException{
        String query = "INSERT INTO insegnamento (id,nome,cfu,descrizione,docente) VALUES (?,?,?,?,?) ";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query);
        ){
            stmt.setInt(1, insegnamento.getId());
            stmt.setString(2, insegnamento.getNome());
            stmt.setInt(3, insegnamento.getCfu());
            stmt.setString(4, insegnamento.getDescrizione());
            stmt.setString(5, insegnamento.getDocente());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean modificaInsegnamento(Insegnamento insegnamento) throws SQLException{
        String query = "UPDATE insegnamento SET nome=?, cfu=?, descrizione=?, docente=? WHERE id=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, insegnamento.getNome());
            stmt.setInt(2, insegnamento.getCfu());
            stmt.setString(3, insegnamento.getDescrizione());
            stmt.setString(4, insegnamento.getDocente());
            stmt.setInt(5, insegnamento.getId());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean eliminaInsegnamento(int id) throws SQLException{
        String  query = "DELETE FROM insegnamento WHERE id=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;
        }
    }

    public Insegnamento prendiInsegnamentoId(int id) throws SQLException{
        String  query = "SELECT * FROM insegnamento WHERE id=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)

        ) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            Insegnamento insegnamento = null ;
            if(rs.next()){
                String nome = rs.getString("nome");
                int cfu = rs.getInt("cfu");
                String descrizione = rs.getString("descrizione");
                String docente = rs.getString("docente");

                insegnamento = new Insegnamento(id,nome,cfu,descrizione,docente);
            }
            return insegnamento;
        }
    }
}
