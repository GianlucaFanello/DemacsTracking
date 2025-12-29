package main.java.org.example.demacstracking.model.db;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static Connection con;
    private DBManager(){}

    public static Connection getConnection() throws SQLException {
        if(con==null){
            String url = "jdbc:sqlite:DemacsTracking.db";
            con = DriverManager.getConnection(url);
            System.out.println("Connected");
        }
        return con;
    }
}
