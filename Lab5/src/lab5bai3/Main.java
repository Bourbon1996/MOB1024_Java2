package lab5bai3;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();
		
		// load dữ liệu khi bắt đầu
		service.loadFromFile();
		
		int choice;
		do {
			System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());
			
            switch (choice) {
				case 1: 
					service.inputStudent();
					break;
				case 2:
					if(service.getList().isEmpty()) {
						System.out.println("Danh sách rỗng");
					}else {
						service.getList().forEach(System.out::println);
					}
					break;
				case 0:
					service.saveToFile();
					
					System.out.println(" Đã lưu file");
			
			default:
				System.out.println("Lựa chọn không hợp lệ");
			}
		} while (choice != 0);
		
		
		
	}
}
