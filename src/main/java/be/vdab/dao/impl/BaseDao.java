package be.vdab.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {
    protected Connection connection;

    public BaseDao() {
        String URL = "jdbc:mysql://localhost:3306/eshop";
        String USERNAME = "root";
        String PASSWORD = "admin";

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
