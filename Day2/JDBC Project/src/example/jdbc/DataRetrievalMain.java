package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRetrievalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Program to retrieve data from DB using SELECT query and display it.
		
		//1. Load the Driver
		String driverClass = "com.mysql.cj.jdbc.Driver"; //this driver is gives by oracle to use sql. It is a Type4 driver. Driver is class of Databse 
		try {
			System.out.println("Driver Loaded");
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //after that download "mysql-connector-java-8.0.11" this jar file 
		//then cretate a new folder inside a project "Library"
		// the inside this folder copy that jar file so that it locally available inside a project
		//build a path ->steps - right click on project->Build path -> configure Build Path -> libraries ->select jar file(module path)-> Add JAR'S -> Apply & close
		
		//2. Establish Connection
		String ConnectionUrl = "jdbc:mysql://localhost:3306/webbasedjava?useSSL=false";  //?useSSL=false after adding this exceptions are removed 
	    //main protocol is always jdbc, mysql - sub Protocol, IP Address - localhost , Port no -3306, Database Schema Name - webbasedjava 
		// based on "localhost:3306" this Socket 
		    
		String userId = "root";
		String password = "aai&dada123";
		Connection dbConnection = null; //step3
		Statement stmt = null;     //step3
		ResultSet rs = null;  //step4
		
		try {
			dbConnection =  //step3
			DriverManager.getConnection(ConnectionUrl, userId, password);
			System.out.println("Connected to DB");
			
			//3. Obtain some Statement
			stmt = dbConnection.createStatement();  //step3
			
			//4. Execute SQL Query
			String sqlQuery = 
					"select student_name, student_city, student_id from students";
			stmt.executeQuery(sqlQuery);
			rs = stmt.executeQuery(sqlQuery);
			
			//5. Perform navigation on Resultset => rs
			while(rs.next()) {
				String name = rs.getString(1); //name
				String city = rs.getString(2); //city
				int id = rs.getInt(3); //ID
				System.out.println(id + ","+ name + ","+ city);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

	}

}
