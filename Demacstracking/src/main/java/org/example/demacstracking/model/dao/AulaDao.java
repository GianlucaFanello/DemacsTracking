package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.strutture.Aula;
import org.example.demacstracking.model.dto.strutture.Distributore;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AulaDao {

    public AulaDao (){}

    // --- INSERISCI AULA ---
    public boolean aggiungiAula(Aula aula) throws SQLException{
        String query = "INSERT INTO aula (nome,ubicazione,capienza,cubo,descrizione) VALUES (?,?,?,?,?)";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, aula.getNome());
            stmt.setString(2, aula.getUbicazione());
            stmt.setInt(3, aula.getCapienza());
            stmt.setString(4, aula.getCubo());
            stmt.setString(5, aula.getDescrizione());
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
        String query = "UPDATE aula SET ubicazione=?,capienza=?,descrizione=? WHERE cubo=? AND nome=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, aula.getUbicazione());
            stmt.setInt(2, aula.getCapienza());
            stmt.setString(3, aula.getDescrizione());
            stmt.setString(4, aula.getCubo());
            stmt.setString(5, aula.getNome());

            int modificato =  stmt.executeUpdate();
            return modificato>0;
        }
    }

    public boolean aulaPresente(String nome, String cubo) throws SQLException {
        String query = "SELECT 1 FROM aula WHERE nome=? AND cubo=?";

        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, nome);
            stmt.setString(2, cubo);

            return stmt.executeQuery().next();
        }
    }

    public List<Aula> getAllAule() throws SQLException {
        String query = "SELECT * FROM aula WHERE cubo=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, VisualizzazioneCorrente.getInstance().getCuboCorrente().getNome());

            List<Aula> aule = new ArrayList<>();

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String ubicazione = rs.getString("ubicazione");
                String cubo = rs.getString("cubo");
                String nome = rs.getString("nome");
                int capienza = rs.getInt("capienza");
                String descrizione = rs.getString("descrizione");

                Aula aula = new Aula(cubo,ubicazione, nome, capienza,descrizione);
                aule.add(aula);
            }
            return aule;
        }
    }
}
