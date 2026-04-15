package Lab8bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public record Student(String id, String name, double gpa) {
        public Student {
            if (gpa < 0 || gpa > 4.0) {
                throw new IllegalArgumentException("GPA không hợp lệ!");
            }
        }

        public boolean isScholarshipEligible() {
            return gpa >= 3.2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();

        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập sinh viên thứ " + (i + 1));

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Tên: ");
            String name = sc.nextLine();

            double gpa;
            while (true) {
                try {
                    System.out.print("GPA: ");
                    gpa = Double.parseDouble(sc.nextLine());

                    Student s = new Student(id, name, gpa); 
                    list.add(s);
                    break; 

                } catch (Exception e) {
                    System.out.println(" Lỗi: " + e.getMessage() + " → nhập lại!");
                }
            }
        }

        // danh sách
        System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
        for (Student s : list) {
            System.out.println(s);
        }

        // học bổng
        System.out.println("\n=== SINH VIÊN ĐỦ HỌC BỔNG ===");
        for (Student s : list) {
            if (s.isScholarshipEligible()) {
                System.out.println(s);
            }
        }
    }
}
