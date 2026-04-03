package asm1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DocumentService service = new DocumentService();
        Scanner sc = new Scanner(System.in);

        int chon;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Thêm tài liệu");
            System.out.println("2. Lưu file");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                chon = -1;
                continue;
            }

            switch (chon) {
                case 1:
                    try {
                        System.out.print("Nhập ID: ");
                        String id = sc.nextLine();

                        System.out.print("Nhập tên: ");
                        String title = sc.nextLine();

                        service.addDocument(new Document(id, title));
                        System.out.println("Thêm thành công!");

                    } catch (DuplicateIdException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;

                case 2:
                    service.saveToFile();
                    System.out.println("Đã lưu file!");
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Chọn sai!");
            }

        } while (chon != 0);
        sc.close();

    }
}