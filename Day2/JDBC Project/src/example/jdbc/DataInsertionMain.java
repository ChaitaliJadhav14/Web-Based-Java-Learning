package example.jdbc;

public class DataInsertionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoInterface<Student,Integer> daoRef = new StudentDao();
		Student std = new Student(104,"Sakshi Jadhav","Pune");
		daoRef.create(std);
		
	}

}
