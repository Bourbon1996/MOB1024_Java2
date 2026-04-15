package main;

import java.util.List;
import java.util.Scanner;

import entity.Employee;
import repository.EmployeeRepository;

public class Main {
    public static void main(String[] args) {

        EmployeeRepository repo = new EmployeeRepository();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Cập nhật nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm theo ID (Callable)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = s.nextInt();

            switch (choice) {

                
                case 1:
                    List<Employee> list = repo.findAll();
                    if (!list.isEmpty()) {
                        System.out.println("Danh sách nhân viên:");
                        list.forEach(System.out::println);
                    } else {
                        System.out.println("Danh sách trống!");
                    }
                    break;
              
                case 2:
                    System.out.print("Nhập ID: ");
                    int id = s.nextInt();
                    s.nextLine();

                    System.out.print("Nhập Name: ");
                    String name = s.nextLine();

                    System.out.print("Nhập Salary: ");
                    double salary = s.nextDouble();

                    Employee e = new Employee(id, name, salary);

                    if (repo.add(e)) {
                        System.out.println("Thêm thành công!");
                    } else {
                        System.out.println("Thêm thất bại!");
                    }
                    break;
                
                case 3:
                    System.out.print("Nhập ID cần cập nhật: ");
                    int idUpdate = s.nextInt();
                    Employee emp = repo.findById(idUpdate);
                    s.nextLine();
                    if(emp != null) {
                    	System.out.println("Họ tên cũ: " + emp.getName());
                    	System.out.println("Họ tên mới ( nếu không cập nhật thì nhấn Enter): ");
                    	String nameUpdate = s.nextLine();
                    	if(nameUpdate.isEmpty())
                    		nameUpdate = emp.getName();
                    	
                    	System.out.println("Lương cũ: " + emp.getSalary());
                    	System.out.println("Lương mới ( nếu không cập nhật thì nhấn Enter): ");
                    	String salarySt = s.nextLine();
                    	double salaryUpdate;
                    	if(salarySt.isEmpty()) {
                    		salaryUpdate = emp.getSalary();
                    	}else {
                            try {
                                salaryUpdate = Double.parseDouble(salarySt);
                            } catch (Exception e2) {
                                System.out.println("Lương không hợp lệ! Giữ nguyên.");
                                salaryUpdate = emp.getSalary();
                            }
                        }

                        // thêm
                        Employee updated = new Employee(idUpdate, nameUpdate, salaryUpdate);

                        if (repo.update(updated)) {
                            System.out.println("Cập nhật thành công!");
                        } else {
                            System.out.println("Cập nhật thất bại!");
                        }

                    } else {
                        System.out.println("Không tìm thấy nhân viên!");
                    }
                    break;
                                                                                                                             
                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    int idDelete = s.nextInt();

                    if (repo.delete(idDelete)) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Xóa thất bại! (ID không tồn tại)");
                    }
                    break;
               
                case 5:
                    System.out.print("Nhập ID cần tìm: ");
                    int idFind = s.nextInt();

                    Employee found = repo.findById(idFind);

                    if (found != null) {
                        System.out.println("Tìm kiếm thành công!");
                        System.out.println(found);
                    } else {
                        System.out.println("Tìm kiếm thất bại!");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    s.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}