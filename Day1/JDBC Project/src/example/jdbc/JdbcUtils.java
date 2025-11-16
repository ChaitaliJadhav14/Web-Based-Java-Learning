package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	public static Connection getConnection() throws SQLException {
		//This method is used to establish connection with DB and return the same
		String ConnectionUrl = "jdbc:mysql://localhost:3306/webbasedjava?useSSL=false"; 
		String userId = "root";
		String password = "aai&dada123";
		Connection dbConnection =
		DriverManager.getConnection(ConnectionUrl, userId, password); // for we need to add throws SQLException
		
		return dbConnection;
		
	}

}
