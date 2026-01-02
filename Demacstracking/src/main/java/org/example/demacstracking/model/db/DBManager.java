package org.example.demacstracking.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static DBManager manager;

    private DBManager(){}

    public static DBManager getInstance(){
        if (manager == null) {
            manager = new DBManager();
        }
        return manager;
    }

    public Connection getConnection() throws SQLException {

        String url = "jdbc:sqlite:DemacsTracking.db";
        return DriverManager.getConnection(url);
    }
}
