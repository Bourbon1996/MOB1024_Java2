package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DbConnect;
import entity.Document_copy;
import entity.Status;
import exception.ValidationException;
import validator.DocumentCopyValidator;

public class DocumentCopyRepository {

    public boolean existsById(String id) {
        String sql = "SELECT 1 FROM DOCUMENT_COPY WHERE id=?";
        try (Connection c = DbConnect.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeQuery().next();
        } catch (Exception e) {
        	System.out.println("Lỗi DB: " + e.getMessage());
        	return false; 
        }
    }

    public boolean documentExists(String docId) {
        String sql = "SELECT 1 FROM DOCUMENT WHERE id=?";
        try (Connection c = DbConnect.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, docId);
            return ps.executeQuery().next();
        } catch (Exception e) { return false; }
    }

    public boolean insert(Document_copy c) {
        try {
            DocumentCopyValidator.validate(c, false, this);

            String sql = "INSERT INTO DOCUMENT_COPY VALUES (?, ?, ?)";
            try (Connection conn = DbConnect.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, c.getId());
                ps.setString(2, c.getDocumentId());
                ps.setString(3, c.getStatus().name());

                return ps.executeUpdate() > 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean update(Document_copy c) {
        try {
            DocumentCopyValidator.validate(c, true, this);

            String sql = "UPDATE DOCUMENT_COPY SET status=? WHERE id=?";
            try (Connection conn = DbConnect.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, c.getStatus().name());
                ps.setString(2, c.getId());

                return ps.executeUpdate() > 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean delete(String id) {
        try {
            if (!existsById(id))
                throw new ValidationException("Copy không tồn tại");

            String sql = "DELETE FROM DOCUMENT_COPY WHERE id=?";
            try (Connection conn = DbConnect.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, id);
                return ps.executeUpdate() > 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // JOIN
    public void getAllWithDocument() {
    	String sql = """
    		    SELECT 
    		        d.id AS d_id,
    		        d.title,
    		        d.author,
    		        d.category,
    		        c.id AS c_id,
    		        c.document_id,
    		        c.status
    		    FROM DOCUMENT d
    		    JOIN DOCUMENT_COPY c ON d.id = c.document_id
    		""";

        try (Connection conn = DbConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

        	while (rs.next()) {
        	    System.out.println(
        	        "DOC[" +
        	        rs.getString("d_id") + " | " +
        	        rs.getString("title") + " | " +
        	        rs.getString("author") + " | " +
        	        rs.getString("category") +
        	        "]  || COPY[" +
        	        rs.getString("c_id") + " | " +
        	        rs.getString("document_id") + " | " +
        	        rs.getString("status") +
        	        "]"
        	    );
        	}
        } catch (Exception e) {
        	System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    // TRANSACTION
    public boolean updateStatusByDocument(String docId, Status status) {
        Connection conn = null;

        try {
            conn = DbConnect.getConnection();
            conn.setAutoCommit(false);

            if (!documentExists(docId))
                throw new ValidationException("Document không tồn tại");

            String sql = "UPDATE DOCUMENT_COPY SET status=? WHERE document_id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, status.name());
                ps.setString(2, docId);

                int rows = ps.executeUpdate();

                conn.commit();
                return rows > 0;
            }

        } catch (Exception e) {
            try { if (conn != null) conn.rollback(); } catch (Exception ex) {}
            System.out.println(e.getMessage());
        } finally {
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        return false;
    }
    
    public List<Document_copy> findByDocumentId(String docId) {
        List<Document_copy> list = new ArrayList<>();
        String sql = "SELECT * FROM DOCUMENT_COPY WHERE document_id=?";

        try (Connection conn = DbConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, docId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Document_copy(
                        rs.getString("id"),
                        rs.getString("document_id"),
                        Status.valueOf(rs.getString("status"))
                ));
            }

        } catch (Exception e) {
        	System.out.println("Lỗi DB: " + e.getMessage());
        }

        return list;
    }
}