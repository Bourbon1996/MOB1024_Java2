package repository;

import entity.Document;
import exception.ValidationException;
import validator.DocumentValidator;
import connect.DbConnect;

import java.sql.*;
import java.util.*;

public class DocumentRepository {
	
	public Document findById(String Id) {
		try(Connection co = DbConnect.getConnection()) {
			String mysql = "select * from document where id = ?";
			PreparedStatement ps = co.prepareStatement(mysql);
			ps.setString(1, Id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Document d = new Document(
					rs.getString("id"),
					rs.getString("title"),
					rs.getString("author"),
					rs.getString("category"));
			return d;				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
}

    public boolean existsById(String id) {
        String sql = "SELECT 1 FROM DOCUMENT WHERE id=?";
        try (Connection c = DbConnect.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeQuery().next();
        } catch (Exception e) { return false; }
    }

    
    // thêm (Creat)
    public boolean insert(Document d) {
        try {
            DocumentValidator.validate(d, false, this);

            String sql = "INSERT INTO DOCUMENT VALUES (?, ?, ?, ?)";
            try (Connection c = DbConnect.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql)) {

                ps.setString(1, d.getId());
                ps.setString(2, d.getTitle());
                ps.setString(3, d.getAuthor());
                ps.setString(4, d.getCategory());

                return ps.executeUpdate() > 0;
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
        	System.out.println("Lỗi DB: " + e.getMessage());
        }
        return false;
    }

    
    // Read
    public List<Document> findAll() {
        List<Document> list = new ArrayList<>();
        String sql = "SELECT * FROM DOCUMENT";

        try (Connection c = DbConnect.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Document(
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category")
                ));
            }
        } catch (Exception e) { 
        	System.out.println("Lỗi DB: " + e.getMessage());
        }

        return list;
    }

    // cập nhật (update)
    public boolean update(Document d) {
        try {
            DocumentValidator.validate(d, true, this);

            String sql = "UPDATE DOCUMENT SET title=?, author=?, category=? WHERE id=?";
            try (Connection c = DbConnect.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql)) {

                ps.setString(1, d.getTitle());
                ps.setString(2, d.getAuthor());
                ps.setString(3, d.getCategory());
                ps.setString(4, d.getId());

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    
    // xóa (delete)
    public boolean delete(String id) {
        try {
            if (!existsById(id))
                throw new ValidationException("ID không tồn tại");

            String sql = "DELETE FROM DOCUMENT WHERE id=?";
            try (Connection c = DbConnect.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql)) {

                ps.setString(1, id);
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
 // SORT (Stream API)
    public List<Document> sortByTitle() {
        return findAll().stream()
                .sorted(Comparator.comparing(Document::getTitle))
                .toList();
    }

    public List<Document> sortByAuthor() {
        return findAll().stream()
                .sorted(Comparator.comparing(Document::getAuthor))
                .toList();
    }
}
