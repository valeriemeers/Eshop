package be.vdab.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {

    public static final String URL = "jdbc:mysql://localhost:3306/eshop";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "admin";

    public static void main(String[] args) {

        try (Connection con = getConnection()) {
            System.out.println("Connectie ok");
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}

