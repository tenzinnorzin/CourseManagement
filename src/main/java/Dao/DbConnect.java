package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	static Connection conn = null;
	public static Connection getConnection() throws ClassNotFoundException {
		try {
			//loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// create the connection
			String user= "root";
            String url="jdbc:mysql://localhost:3306/courses";
            String password="password";
            conn= DriverManager.getConnection(url, user, password);


		}catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
}
