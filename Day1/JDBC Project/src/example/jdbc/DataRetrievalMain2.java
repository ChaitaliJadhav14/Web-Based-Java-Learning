package example.jdbc;

import java.util.Collection;

public class DataRetrievalMain2 {

	public static void main(String[] args) {
		DaoInterface<Student,Integer> daoRef =
				new StudentDao();
		Collection<Student> allStudents = daoRef.getAll();
		/*
		for(Student st : allStudents)
			System.out.println(st);
		*/
		
		allStudents.stream().forEach(student -> System.out.println(student));
	}

}
