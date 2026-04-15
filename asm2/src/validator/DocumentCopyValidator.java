package validator;

import entity.Document_copy;
import exception.ValidationException;
import repository.DocumentCopyRepository;

public class DocumentCopyValidator {
	public static void validate(Document_copy c, boolean isUpdate, DocumentCopyRepository repo)
            throws ValidationException {

        // 1. ID
        if (c.getId() == null || c.getId().isBlank()) {
            throw new ValidationException("Copy ID không được để trống");
        }

        // 2. Status
        if (c.getStatus() == null) {
            throw new ValidationException("Status không hợp lệ");
        }

        // 3. Document ID
        if (c.getDocumentId() == null || c.getDocumentId().isBlank()) {
            throw new ValidationException("Document ID không hợp lệ");
        }

        // 🔥 4. FK phải tồn tại
        if (!repo.documentExists(c.getDocumentId())) {
            throw new ValidationException("Document không tồn tại");
        }

        // 5. Trùng ID
        if (!isUpdate && repo.existsById(c.getId())) {
            throw new ValidationException("Copy ID đã tồn tại");
        }

        // 6. Update nhưng không tồn tại
        if (isUpdate && !repo.existsById(c.getId())) {
            throw new ValidationException("Copy ID không tồn tại");
        }
    }
}
