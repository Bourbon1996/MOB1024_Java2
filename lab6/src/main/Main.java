package main;

import java.util.List;
import java.util.Scanner;

import entity.Student;
import repository.StudentRepository;

public class Main {

    public static Student inputStudent(Scanner sc, StudentRepository stur) {
        int id;

        while (true) {
            System.out.print("Nhập ID: ");
            id = sc.nextInt();
            sc.nextLine();

            if (stur.findById(id) != null) {
                System.out.println("ID đã tồn tại! Nhập lại.");
            } else {
                break;
            }
        }

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập giới tính: ");
        String gender = sc.nextLine();

        System.out.print("Nhập GPA: ");
        double gpa = sc.nextDouble();

        return new Student(id, name, gender, gpa);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentRepository stur = new StudentRepository();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Tìm theo ID");
            System.out.println("3. Thêm sinh viên");
            System.out.println("4. Sửa sinh viên");
            System.out.println("5. Xóa sinh viên");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    List<Student> list = stur.findAll();
                    if (list != null && !list.isEmpty()) {
                        list.stream().forEach(System.out::println);
                    } else {
                        System.out.println("Danh sách trống!");
                    }
                    break;

                case 2:
                    System.out.print("Nhập ID cần tìm: ");
                    int id = sc.nextInt();
                    Student s = stur.findById(id);
                    if (s != null) {
                        System.out.println(s);
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 3:
                    Student newStu = inputStudent(sc, stur);
                    if (stur.insert(newStu)) {
                        System.out.println("Thêm thành công!");
                    } else {
                        System.out.println("Thêm thất bại!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID cần sửa: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Student oldStu = stur.findById(updateId);
                    if (oldStu != null) {
                        System.out.println("Nhập thông tin mới:");

                        System.out.print("Tên: ");
                        String name = sc.nextLine();

                        System.out.print("Giới tính: ");
                        String gender = sc.nextLine();

                        System.out.print("GPA: ");
                        double gpa = sc.nextDouble();

                        Student updateStu = new Student(updateId, name, gender, gpa);

                        if (stur.update(updateStu)) {
                            System.out.println("Cập nhật thành công!");
                        } else {
                            System.out.println("Cập nhật thất bại!");
                        }
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 5:
                    System.out.print("Nhập ID cần xóa: ");
                    int deleteId = sc.nextInt();

                    Student del = stur.findById(deleteId);
                    if (del != null) {
                        if (stur.delete(del)) {
                            System.out.println("Xóa thành công!");
                        } else {
                            System.out.println("Xóa thất bại!");
                        }
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    sc.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}