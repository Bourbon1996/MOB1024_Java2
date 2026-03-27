package lab3bai4;

public class Student {
	private String id;
	private String name;
	private StudentType type;
	private double gpa;
	
		public Student(String id, String name, StudentType type, double gpa) {
			this.id = id;
			this.name = name;
			this.type = type;
			this.gpa = gpa;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public StudentType getType() {
			return type;
		}

		public void setType(StudentType type) {
			this.type = type;
		}

		public double getGpa() {
			return gpa;
		}

		public void setGpa(double gpa) {
			this.gpa = gpa;
		}
		
		public String toString() {
			return String.format("%-5s %-20s %-10s %10.0f", id, name, type, gpa);
		}
		
		
}
