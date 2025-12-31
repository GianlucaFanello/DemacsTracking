package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;

import java.sql.Connection;
import java.sql.SQLException;

public class InsegnamentoDao {

    private final Connection connection;

    public InsegnamentoDao() throws SQLException {
        connection = DBManager.getInstance().getConnection();
    }
}
