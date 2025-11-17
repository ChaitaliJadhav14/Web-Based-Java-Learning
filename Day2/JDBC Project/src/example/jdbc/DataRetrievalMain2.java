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
		
		System.out.println("=======================================================");
//		Student std = daoRef.getOne(1003); //when we try to get not existing value then it give null as a result if we not write a if else block and a message,beacuse intinally we declared "foundStudent = null"
		Student std = daoRef.getOne(1003);
//		System.out.println(std);
		if(std != null)
			System.out.println(std);
		else
			System.out.println("Student with given Id does not exist");
	}

}
