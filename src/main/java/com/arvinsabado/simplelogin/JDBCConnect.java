
package com.arvinsabado.simplelogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class JDBCConnect {
    
    private Connection connection;
    private final String user = "root";
    private final String password = "";
    
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplelogin", user, password);
            System.out.println("Connection status: " + connection.isValid(0));
        }
        catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return connection;
    }
}  
