package lab2;

public class Student {
	 
	private String id;
	private String name;
	private StudentType type;
	
	public Student(String id, String name, StudentType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public StudentType getType() {
		return this.type;
	}
	
	public void setType(StudentType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return String.format("%-5s %-20s %-15s", id, name, type);
	}
	
}
