package validator;

import entity.Document;
import exception.ValidationException;
import repository.DocumentRepository;

public class DocumentValidator {
	public static void validate(Document d, boolean isUpdate, DocumentRepository repo)
            throws ValidationException {

        if (d.getId() == null || d.getId().isBlank()) {
            throw new ValidationException("ID không được để trống");
        }

        if (d.getTitle() == null || d.getTitle().isBlank()) {
            throw new ValidationException("Title không được để trống");
        }

        if (d.getAuthor() == null || d.getAuthor().isBlank()) {
            throw new ValidationException("Author không được để trống");
        }

        if (!isUpdate && repo.existsById(d.getId())) {
            throw new ValidationException("ID đã tồn tại");
        }

        if (isUpdate && !repo.existsById(d.getId())) {
            throw new ValidationException("ID không tồn tại");
        }
    }
}
