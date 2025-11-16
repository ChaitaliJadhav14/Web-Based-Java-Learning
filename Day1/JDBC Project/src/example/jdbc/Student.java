package example.jdbc;

public class Student {

		// TODO Auto-generated constructor stub
		private int studentId;
		private String name;
		private String city;
		
		public Student(int studentId ,String name, String city) {
			super();
			this.studentId = studentId;
			this.name = name;
			this.city = city;
		}

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", name=" + name + ", city=" + city + "]";
		}
		
		
	

}
