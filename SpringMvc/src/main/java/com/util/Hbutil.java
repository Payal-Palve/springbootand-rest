package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hbutil {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankapp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
   
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=   DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
       return con;
       
    }

}
