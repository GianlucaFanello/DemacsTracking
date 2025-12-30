package org.example.demacstracking.model.db;

import javafx.scene.image.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utente {
    public static boolean inserisciUtente(String nome, String cognome, String username, String email, String password, String status) throws SQLException {
        String insert = "INSERT INTO utente VALUES (?, ?, ?, ?, ?, ?);";

        Connection con = DBManager.getConnection();
        PreparedStatement stmt = con.prepareStatement(insert);
        stmt.setString(1, nome);
        stmt.setString(2, cognome);
        stmt.setString(3, username);
        stmt.setString(4, email);
        stmt.setString(5, password);
        stmt.setString(6, status);

        int valido = stmt.executeUpdate();
        stmt.close();

        if (valido > 0) {
            System.out.println("Locale aggiunto correttamente!");
            return true;
        } else {
            System.out.println("Errore nell'aggiunta del locale");
            return false;
        }
    }



    private static int recuperaUtente(Connection con,String username) throws SQLException {
        //IL METODO CONTA TUTTE LE RIGHE DELLA TABELLA utente
        int num = 0;
        String query = "Select * from utente where username = ?";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1,username);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            num = rs.getInt(1);
        }
        st.close();
        rs.close();
        return num+1;
    }




}
