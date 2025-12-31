package org.example.demacstracking.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static DBManager manager;
    private Connection con;

    private DBManager(){}

    public static DBManager getInstance(){
        if (manager == null) {
            manager = new DBManager();
        }
        return manager;
    }

    public Connection getConnection() throws SQLException {
        if(con==null){
            String url = "jdbc:sqlite:DemacsTracking.db";
            con = DriverManager.getConnection(url);
            System.out.println("Connected");
        }
        return con;
    }
}
