package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDao {

    private final Connection connection;

    public UtenteDao() throws SQLException {
        connection = DBManager.getInstance().getConnection();
    }

    // --- METODO PER L'INSERIMENTO DI UN UTENTE ---
    public boolean inserisciUtente(Utente utente, String password) throws SQLException {
        String insert = "INSERT INTO utente VALUES (?, ?, ?, ?, ?, ?);";

        PreparedStatement stmt = connection.prepareStatement(insert);
        stmt.setString(1, utente.getNome());
        stmt.setString(2, utente.getCognome());
        stmt.setString(3, utente.getUsername());
        stmt.setString(4, utente.getEmail());
        stmt.setString(5, password);
        stmt.setString(6, utente.getStatus());

        int valido = stmt.executeUpdate();
        stmt.close();

        if (valido > 0) {
            System.out.println("Utente aggiunto correttamente!");
            return true;
        } else {
            System.out.println("Errore nell'aggiunta dell'utente");
            return false;
        }
    }


    // --- METODO PER L'ELIMINAZIONE DI UN UTENTE ---
    public boolean eliminaUtente(String username) throws SQLException {

        String query = "DELETE FROM utente WHERE username = ?;";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, username);

        int eliminato = stmt.executeUpdate(); // Use executeUpdate for DELETE

        stmt.close();

        return eliminato > 0;
    }


    // --- RECUPERARE UN UTENTE DALLA SUA CHIAVE PRIMARIA ---

    public Utente getUtenteByPrimaryKey(String username) throws SQLException {

        String query = "SELECT * FROM utente WHERE username = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();
        Utente utente = null;

        if (rs.next()) {

            String nome =  rs.getString("nome");
            String cognome = rs.getString("cognome");
            String email =  rs.getString("email");
            String status = rs.getString("status");

            utente = new Utente(nome, cognome, username, email, status);
        }

        stmt.close();

        return utente ;
    }
}
