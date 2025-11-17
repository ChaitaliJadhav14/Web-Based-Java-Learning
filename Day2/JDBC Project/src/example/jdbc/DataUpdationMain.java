package example.jdbc;

public class DataUpdationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoInterface<Student,Integer> daoRef = new StudentDao();
		Student foundStudent = daoRef.getOne(104);
		if(foundStudent != null) {
			foundStudent.setName("Sakshi Anil Jadhav");
			foundStudent.setCity("solaapur");
			daoRef.update(foundStudent);
		}
		else {
			System.out.println("Student with given ID is not exist.");
		}

	}

}
