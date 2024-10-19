package com.hexaware.techshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/techshop"; 
    private static final String DB_USER = "root";  
    private static final String DB_PASSWORD = "Sakshi@60#"; 
    
    // This method establishes the database connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
        return conn;
    }

    
    // This method closes the database connection
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to close the connection.");
            }
        }
    }
}
