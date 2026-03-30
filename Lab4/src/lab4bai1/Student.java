package lab4bai1;

public class Student {
	private String id;
	private String name;
	private double gpa;
	
	// Contructor không tham số
	public Student() {}
	
	// Contructor có tham số
	public Student(String id, String name, double gpa) {
		setId(id);
        setName(name);
        setGpa(gpa);
	}
	
	// Getter và setter kèm xử lý Exception
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if ( id == null || id.trim().isEmpty()) {
			// dùng throw để ném ra 1 lỗi
			throw new IllegalArgumentException("Id không được để trống");
		}
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Tên không được để trống");
		}
		if(!name.matches("^[a-zA-Z\\sÀ-ỹ]+$")){ //Dấu .*\\d.* nghĩa là: "Bất kỳ ký tự nào + có số + bất kỳ ký tự nào
			throw new IllegalArgumentException("Tên không được phép chứa số");
		}
		this.name = name;
	}
	
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		if(gpa < 0 || gpa > 4) {
			throw new IllegalArgumentException("GPA phải nằm trong khoảng từ 0 đến 4");
		}
		this.gpa = gpa;
	}
	
	public void inThongTin() {
		System.out.printf("ID: %s | Tên: %s | GPA: %.2f%n", id, name, gpa);
	}
	
	
}
