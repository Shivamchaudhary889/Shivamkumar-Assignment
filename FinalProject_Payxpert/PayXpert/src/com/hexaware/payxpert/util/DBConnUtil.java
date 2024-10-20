package com.hexaware.payxpert.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/payxpert";
    private static final String USER = "root";
    private static final String PASSWORD = "Sakshi@60#";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error establishing database connection", e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
