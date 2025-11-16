package example.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao implements DaoInterface<Student, Integer> {

	@Override
	public Collection<Student> getAll() {
		/*  This method retrives all the records from Students table,
		 * converts them into Java objects of students class and returns
		 * all those objects in the form of Collection
		 */
		
		//Declaring an empty Collection meant for hoilding objects of type: Student
		Collection<Student> allStudents = new ArrayList<>();
		
		String sqlQuery = 
				"select student_name, student_city, student_id from students";
		
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery)
				){
					while(rs.next()) {
						String name = rs.getString(1); //name
						String city = rs.getString(2); //city
						int id = rs.getInt(3); //ID
						
						//Creating an object of Student class based upon ID ,Name ,City
						Student studentObj = 
								new Student(id,name,city);
						
						//Adding the Student object into Students collection : allStudents
						allStudents.add(studentObj);					}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return allStudents;
	}

	

}
