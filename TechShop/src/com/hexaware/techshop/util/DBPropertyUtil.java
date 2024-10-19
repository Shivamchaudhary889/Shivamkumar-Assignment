package com.hexaware.techshop.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {

    public static String getConnectionString(String propertyFileName) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(propertyFileName)) {
            properties.load(fis);
            String connectionString = properties.getProperty("db.connectionString");
            return connectionString;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
