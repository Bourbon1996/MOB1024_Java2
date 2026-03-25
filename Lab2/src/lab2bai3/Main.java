package lab2bai3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		Scanner s = new Scanner(System.in);
		int chon;
		
		do {
			System.out.println("\n--- QUẢN LÝ NHÂN VIÊN ---");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm nhân viên theo mã");
            System.out.println("4. Cập nhật lương");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = s.nextInt();
            s.nextLine();
			
            switch (chon) {
			case 1: 
				System.out.print("Nhập ID: ");
				String id = s.nextLine();
				
				System.out.print("Nhập tên: ");
				String name = s.nextLine();
				
				System.out.print("Nhập lương: ");
				double salary = s.nextDouble();
				
				service.add(new Employee(id, name, salary));
				break;
			case 2: 
				service.display();
				break;
			case 3: 
				System.out.print("Nhập mã cần tìm: "); 
				String search = s.nextLine();
                Employee found = service.find(search);
                if(found != null) {
                	System.out.println(service);
                }else {
                	System.out.println("Không Tìm Thấy");
                }                
                break;
			case 4: 
				System.out.println("Cập Nhật Mã Mới");
				String updateid = s.nextLine();
				System.out.println("Nhập luong mới");
				double newSalary =s.nextDouble();
				if(service.update(updateid, newSalary)) {
					System.out.println("Cập nhật thành công");
				}else {
					System.out.println("Mã Nhân Viên Không Tồn Tại");
				}
				break;
			case 5: 
				System.out.println("Thoát!");
				break;	

			default:
				throw new IllegalArgumentException("Unexpected value: " + chon);
			}
		}while(chon !=0);
		
	}
}
