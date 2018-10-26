package edu.northeastern.cs5200;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://cs5200-fall2018-dalonzo.cdbytbcvrrjd.us-east-2.rds.amazonaws.com:3306/A3";
	private static final String USER = "dalonzom";
	private static final String PASSWORD = "Pandora1234!";

	public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
    	Class.forName(DRIVER);
    	return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static void closeConnection(java.sql.Connection conn) {
   	 try {
   		 conn.close();
   	 } catch (SQLException e) {
   		 // TODO Auto-generated catch block
   		 e.printStackTrace();
   	 }
	}

}
