package lab4bai4;

import lab4bai1.Student;
import lab4bai2.Employee;
import lab4bai3.GenericManager;

public class Main {
	public static void main(String[] args) {
		GenericManager<Student> manager = new GenericManager<>();

        // Test khi danh sách rỗng
        try {
            System.out.println("Phần tử đầu: " + manager.getFirst());
        } catch (EmptyListException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        try {
            System.out.println("Phần tử cuối: " + manager.getLast());
        } catch (EmptyListException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        //Thêm dữ liệu
        manager.add(new Student("S01", "An", 3.2));
        manager.add(new Student("S02", "Binh", 3.5));

        // Test lại
        try {
            System.out.println("\nSau khi thêm dữ liệu:");
            System.out.println("Phần tử đầu: " + manager.getFirst());
            System.out.println("Phần tử cuối: " + manager.getLast());
        } catch (EmptyListException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
	
}
