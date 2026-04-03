package lab4bai3;

import lab4bai2.Employee;
import lab4bai1.Student;
public class Main {	

	    public static void main(String[] args) {

	        // Quản lý Student
	        GenericManager<Student> studentManager = new GenericManager<>();

	        studentManager.add(new Student("S01", "An", 3.2));
	        studentManager.add(new Student("S02", "Binh", 3.5));

	        System.out.println("=== Danh sách sinh viên ===");
	        studentManager.display();
	        System.out.println("Số lượng: " + studentManager.size());

	        // Quản lý Employee
	        GenericManager<Employee> employeeManager = new GenericManager<>();

	        employeeManager.add(new Employee("E01", "Cuong", 10000));
	        employeeManager.add(new Employee("E02", "Dung", 15000));

	        System.out.println("\n=== Danh sách nhân viên ===");
	        employeeManager.display();
	        System.out.println("Số lượng: " + employeeManager.size());
	    }
}
