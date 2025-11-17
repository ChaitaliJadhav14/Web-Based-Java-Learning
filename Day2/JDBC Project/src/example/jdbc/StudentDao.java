package example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				Statement stmt = dbConnection.createStatement();  //without parameter 
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

	@Override
	public Student getOne(Integer studentId) {
		
		//This method accept an  interger value indicating student id  
		//and returns the Student object matching with that id 
		//if the ID is non-existing,it returns null.
		
		Student foundStudent = null;
		String sqlQuery =
				"select student_name, student_city, student_id from students where student_id = ? ";
		try (
			Connection dbConnection = JdbcUtils.getConnection();
			PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);  //with parameter so it compile at once
		    ){
			//substituting studentId in place of '?'
			pstmt.setInt(1,studentId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString(1); //name
				String city = rs.getString(2); //city
				int id = rs.getInt(3); //ID
				foundStudent = new Student(id,name,city);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return foundStudent;
	}

	@Override
	public void create(Student studentObj) {
		//This method accepts a Student object and stores it as a record into
		//Student table
		String sqlQuery = "insert into students values(?,?,?)";
		try (
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);  //with parameter so it compile at once
			    ){
					//fetching the values from Student object
					int id = studentObj.getStudentId();
					String name = studentObj.getName();
					String city = studentObj.getCity();
					
					//Substituting these values in place of '?'
					pstmt.setInt(1, id);
					pstmt.setString(2, name);
					pstmt.setString(3, city);
					
					
					int count = pstmt.executeUpdate();
					System.out.println(count + "record inserted");  //after this create a new class DataInsertionMain and add new student after this when we add new data in this DataInsertionMain java class data is added into database table automatically 
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
	}

	@Override
	public void update(Student modifiedStudentObj) {
		//This method receives modified state of the Student Object and 
		//reflects that state back to DB to complete the UPDATE operation
		String sqlQuery =
				"update students set student_name = ?, student_city = ? where student_id = ?";
		try (
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);  //with parameter so it compile at once
			    ){
					//fetching the values from Student object
					int id = modifiedStudentObj.getStudentId();
					String name = modifiedStudentObj.getName();
					String city = modifiedStudentObj.getCity();
					
					//Substituting these values in place of '?'
					pstmt.setInt(3, id);
					pstmt.setString(1, name);
					pstmt.setString(2, city);
				    
					int count = pstmt.executeUpdate();
					System.out.println(count + "record updated");
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
	}

	@Override
	public void deleteOne(Integer studentId) {
		// This method accepts ID of the student and deletes the relevants records
		//from the DB table
		String sqlQuery=
				"delete from students where student_id = ?";
		try (
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);  //with parameter so it compile at once
			    ){
					
					pstmt.setInt(1, studentId);
				
					int count = pstmt.executeUpdate();
					if(count != 0) {
						System.out.println(count + "record deleted");
					}
					else {
						System.out.println("Student with given ID is not exist.");
					}
					
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		
	}

	

}
