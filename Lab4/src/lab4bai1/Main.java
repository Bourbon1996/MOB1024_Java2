package lab4bai1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();
		int choice = 0;
		
		do {
			try {
				System.out.println("\n MENU");
				System.out.println("1. Thêm sinh viên");
				System.out.println("2. Hiển thị danh sách sinh viên");
				System.out.println("3. Thoát!");
				System.out.print("Mời bạn chọn: ");
				
				choice = Integer.parseInt(sc.nextLine());
				
				switch (choice) {
				case 1: 
					System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập GPA: ");
                    double gpa = Double.parseDouble(sc.nextLine());
                    
                    Student st =  new Student(id, name, gpa);
                    service.addStudent(st);
					
					break;
				
				case 2:
					service.displayAll();
					
					break;
				
				case 3:
					System.out.println("Thoát chương trình");
					break;
					
				default:
					System.out.println("Vui lòng lựa chọn từ 1 -> 2");
				}
			}catch (NumberFormatException e) {
				System.out.println("LỖI: Vui lòng nhập số, không nhập chữ!");
				choice = -1; // gán lại giá trị để vòng lặp không bị thoát nhầm 
			}catch (IllegalArgumentException e) {
				System.out.println("Lỗi dữ liệu: " + e.getMessage());
			}catch (Exception e) {
				System.out.println("Đã có lỗi xảy ra: " + e.getMessage());
			}
			
		}while(choice !=4);
		sc.close();
	}
}
