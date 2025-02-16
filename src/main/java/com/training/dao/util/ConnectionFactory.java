package com.training.dao.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getMySqlConnection() {  
        Connection con = null;
        Properties dbProp = new Properties();
        
        try (InputStream fis = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (fis == null) {
                throw new IOException("db.properties file not found in classpath!");
            }
            dbProp.load(fis);
//          System.out.println("MYSQL_JDBC_URL: " + dbProp.getProperty("MYSQL_JDBC_URL"));
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded!");
            con = DriverManager.getConnection(
            		dbProp.getProperty("MYSQL_JDBC_URL")
            		+dbProp.getProperty("DATABASE"),
            		dbProp.getProperty("USERNAME"),
            		dbProp.getProperty("PASSWORD"));
            System.out.println("connected to mysql succesfully!");
        } 
        catch (IOException e) {
            System.out.println("Error loading properties: " + e.getMessage());
        } 
        catch (ClassNotFoundException e) {
        	System.out.println("pls load the driver! "+e.getLocalizedMessage());
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
        return con;
    }
}
