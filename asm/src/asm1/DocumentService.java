package asm1;
import java.io.*;
import java.util.*;

public class DocumentService {
	private Map<String, Document> docMap = new HashMap<>();
    private final String FILE_PATH = "documents.dat";

    // 1. Thêm tài liệu mới
    public void addDocument(Document doc) throws DuplicateIdException {
        if (docMap.containsKey(doc.getDocId())) {
            throw new DuplicateIdException("Lỗi: Mã tài liệu " + doc.getDocId() + " đã tồn tại!");
        }
        docMap.put(doc.getDocId(), doc);
    }

    // Thêm bản sao cho 1 tài liệu cụ thể
    public void addCopyRef(String docId, Copy cp) {
        if (docMap.containsKey(docId)) {
            docMap.get(docId).addCopy(cp);
        } else {
            System.out.println("Không tìm thấy tài liệu có mã này!");
        }
    }

    // Ghi dữ liệu vào File (Object Serialization)
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(docMap);
            System.out.println("Đã lưu dữ liệu thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    // Đọc dữ liệu từ File
    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            docMap = (Map<String, Document>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}
