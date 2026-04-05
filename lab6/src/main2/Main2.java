package main2;

import java.util.List;
import java.util.Scanner;

import entity.Tree;
import repository.TreeRepository;

public class Main2 {

    // Hàm nhập Tree
    public static Tree inputTree(Scanner sc, TreeRepository repo) {
        int id;

        while (true) {
            System.out.print("Nhập node_id: ");
            id = sc.nextInt();
            sc.nextLine();

            if (repo.findbyId(id) != null) {
                System.out.println("ID đã tồn tại! Nhập lại.");
            } else {
                break;
            }
        }

        System.out.print("Nhập node_name: ");
        String name = sc.nextLine();

        System.out.print("Nhập parent_id: ");
        int parentId = sc.nextInt();

        System.out.print("Nhập level: ");
        int level = sc.nextInt();

        return new Tree(id, name, parentId, level);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TreeRepository repo = new TreeRepository();

        while (true) {
            System.out.println("\n===== MENU TREE =====");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Tìm theo ID");
            System.out.println("3. Thêm node");
            System.out.println("4. Sửa node");
            System.out.println("5. Xóa node");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    List<Tree> list = repo.findAll();
                    if (list != null && !list.isEmpty()) {
                        list.forEach(System.out::println);
                    } else {
                        System.out.println("Danh sách trống!");
                    }
                    break;

                case 2:
                    System.out.print("Nhập ID cần tìm: ");
                    int id = sc.nextInt();

                    Tree tr = repo.findbyId(id);
                    if (tr != null) {
                        System.out.println(tr);
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 3:
                    Tree newTree = inputTree(sc, repo);
                    if (repo.insert(newTree)) {
                        System.out.println("Thêm thành công!");
                    } else {
                        System.out.println("Thêm thất bại!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID cần sửa: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Tree old = repo.findbyId(updateId);
                    if (old != null) {
                        System.out.println("Nhập thông tin mới:");

                        System.out.print("Tên: ");
                        String name = sc.nextLine();

                        System.out.print("Parent ID: ");
                        int parentId = sc.nextInt();

                        System.out.print("Level: ");
                        int level = sc.nextInt();

                        Tree updateTree = new Tree(updateId, name, parentId, level);

                        if (repo.update(updateTree)) {
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

                    Tree del = repo.findbyId(deleteId);
                    if (del != null) {
                        if (repo.delete(del)) {
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