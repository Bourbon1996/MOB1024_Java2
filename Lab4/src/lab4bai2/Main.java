package lab4bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Tìm nhân viên theo ID");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Nhập ID: ");
                        String id = sc.nextLine();

                        System.out.print("Nhập tên: ");
                        String name = sc.nextLine();

                        System.out.print("Nhập lương: ");
                        double salary = Double.parseDouble(sc.nextLine());

                        service.addEmployee(new Employee(id, name, salary));
                        System.out.println("Thêm thành công!");

                    } catch (DuplicateEmployeeException e) {
                        System.out.println("Lỗi trùng ID: " + e.getMessage());

                    } catch (InvalidSalaryException e) {
                        System.out.println("Lỗi lương: " + e.getMessage());

                    } catch (Exception e) {
                        System.out.println("Lỗi nhập dữ liệu!");
                    }
                    break;

                case 2:
                    System.out.print("Nhập ID cần tìm: ");
                    String searchId = sc.nextLine();

                    Employee emp = service.findById(searchId);

                    if (emp != null) {
                        System.out.println("Tìm thấy:");
                        emp.inThongTin();
                    } else {
                        System.out.println("Không tìm thấy nhân viên!");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Chọn sai, nhập lại!");
            }

        } while (choice != 0);

    }
}