package Main;

import entity.*;
import repository.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static DocumentRepository docRepo = new DocumentRepository();
    static DocumentCopyRepository copyRepo = new DocumentCopyRepository();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm Document");
            System.out.println("2. Xem tất cả Document");
            System.out.println("3. Sửa Document");
            System.out.println("4. Xóa Document");
            System.out.println("5. Sắp xếp Document theo Title");
            System.out.println("6. Sắp xếp Document theo Author");

            System.out.println("7. Thêm DocumentCopy");
            System.out.println("8. Xem Copy theo Document");
            System.out.println("9. Sửa trạng thái Copy");
            System.out.println("10. Xóa Copy");

            System.out.println("11. JOIN Document + Copy");
            System.out.println("12. Update trạng thái nhiều Copy (Transaction)");

            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());
            
            switch (choice) {
                case 1 -> addDocument();
                case 2 -> showAllDocument();
                case 3 -> updateDocument();
                case 4 -> deleteDocument();
                case 5 -> sortByTitle();
                case 6 -> sortByAuthor();

                case 7 -> addCopy();
                case 8 -> showCopyByDoc();
                case 9 -> updateCopy();
                case 10 -> deleteCopy();

                case 11 -> copyRepo.getAllWithDocument();
                case 12 -> updateManyCopy();

                case 0 -> System.out.println("Thoát...");
                default -> System.out.println("Sai lựa chọn!");
            }

        } while (choice != 0);
    }

    // ================= DOCUMENT =================

    static void addDocument() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        boolean result = docRepo.insert(new Document(id, title, author, category));
        System.out.println(result ? "Thêm thành công" : "Thêm thất bại");
    }

    static void showAllDocument() {
        List<Document> list = docRepo.findAll();
        if (list == null || list.isEmpty()) {
            System.out.println("Không có dữ liệu!");
            return;
        }
        list.forEach(d -> System.out.println(
                d.getId() + " | " + d.getTitle() + " | " + d.getAuthor() + " | " + d.getCategory()
        ));
    }

    static void updateDocument() {

        System.out.print("Nhập ID cần cập nhật: ");
        String id = sc.nextLine();

        Document doc = docRepo.findById(id);

        if (doc != null) {

            System.out.println("Title cũ: " + doc.getTitle());
            System.out.print("Title mới (Enter để giữ nguyên): ");
            String titleUpdate = sc.nextLine();
            if (titleUpdate.isEmpty()) {
                titleUpdate = doc.getTitle();
            }

            System.out.println("Author cũ: " + doc.getAuthor());
            System.out.print("Author mới (Enter để giữ nguyên): ");
            String authorUpdate = sc.nextLine();
            if (authorUpdate.isEmpty()) {
                authorUpdate = doc.getAuthor();
            }

            System.out.println("Category cũ: " + doc.getCategory());
            System.out.print("Category mới (Enter để giữ nguyên): ");
            String categoryUpdate = sc.nextLine();
            if (categoryUpdate.isEmpty()) {
                categoryUpdate = doc.getCategory();
            }

            boolean ok = docRepo.update(
                    new Document(id, titleUpdate, authorUpdate, categoryUpdate)
            );

            System.out.println(ok ? "Cập nhật thành công" : "Cập nhật thất bại");

        } else {
            System.out.println("Không tìm thấy Document!");
        }
    }

    static void deleteDocument() {
        System.out.print("Nhập ID cần xóa: ");
        String id = sc.nextLine();

        boolean result = docRepo.delete(id);
        System.out.println(result ? "Xóa thành công" : "Xóa thất bại");
    }

    static void sortByTitle() {
        docRepo.sortByTitle().forEach(d ->
            System.out.println(
                d.getId() + " | " +
                d.getTitle() + " | " +
                d.getAuthor() + " | " +
                d.getCategory()
            )
        );
    }

    static void sortByAuthor() {
        docRepo.sortByAuthor().forEach(d ->
            System.out.println(
                d.getId() + " | " +
                d.getTitle() + " | " +
                d.getAuthor() + " | " +
                d.getCategory()
            )
        );
    }

    // ================= COPY =================

    static void addCopy() {
        System.out.print("Copy ID: ");
        String id = sc.nextLine();

        System.out.print("Document ID: ");
        String docId = sc.nextLine();

        Status status = inputStatus();

        boolean result = copyRepo.insert(new Document_copy(id, docId, status));
        System.out.println(result ? "Thêm copy thành công" : "Thêm thất bại");
    }

    static void showCopyByDoc() {
        System.out.print("Nhập Document ID: ");
        String docId = sc.nextLine();

        List<Document_copy> list = copyRepo.findByDocumentId(docId);

        list.forEach(c -> System.out.println(
                c.getId() + " | " + c.getStatus()
        ));
    }

    static void updateCopy() {
        System.out.print("Nhập Copy ID: ");
        String id = sc.nextLine();

        System.out.print("Document ID: ");
        String docId = sc.nextLine();

        Status status = inputStatus();

        boolean result = copyRepo.update(new Document_copy(id, docId, status));
        System.out.println(result ? "Update thành công" : "Thất bại");
    }

    static void deleteCopy() {
        System.out.print("Nhập Copy ID: ");
        String id = sc.nextLine();

        boolean result = copyRepo.delete(id);
        System.out.println(result ? "Xóa thành công" : "Thất bại");
    }

    static void updateManyCopy() {
        System.out.print("Document ID: ");
        String docId = sc.nextLine();

        Status status = inputStatus();

        boolean result = copyRepo.updateStatusByDocument(docId, status);
        System.out.println(result ? "Update hàng loạt OK" : "Thất bại");
    }

    // ================= STATUS INPUT =================

    static Status inputStatus() {
        System.out.println("Chọn Status:");
        System.out.println("1. GOOD");
        System.out.println("2. DAMAGE");
        System.out.println("3. LOST");

        int choice = Integer.parseInt(sc.nextLine());

        return switch (choice) {
            case 1 -> Status.GOOD;
            case 2 -> Status.DAMAGE;
            case 3 -> Status.LOST;
            default -> {
                System.out.println("Sai, mặc định GOOD");
                yield Status.GOOD;
            }
        };
    }
}