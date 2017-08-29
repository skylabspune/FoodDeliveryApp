package com.jadhavrao.connection;
import java.sql.*;

public class DbConnection {

	static Connection con=null;
	public static Connection getdbconnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver registeration success..");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jadhavrao","root","");
			System.out.println("SUCESS to connect to Mysql Server");
		} catch (ClassNotFoundException e) {
			System.out.println("failed to register driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Failed to connect to Mysql Server");
			e.printStackTrace();
		}
		
		return con;
	}
	
}
