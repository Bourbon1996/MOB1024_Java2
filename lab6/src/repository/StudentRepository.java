package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connect.DbConnect;
import entity.Student;

public class StudentRepository {
	//tât ca danh sach
	public List<Student> findAll(){
		List<Student> list = new ArrayList<>();
		try(Connection co = DbConnect.getConnection()) {
			String mysql = "select * from student";
			PreparedStatement ps = co.prepareStatement(mysql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				int id = rs.getInt("student_id");
				Student stu = new Student(
					rs.getInt("student_id"),
					rs.getString("student_name"),
					rs.getString("gender"),
					rs.getDouble("gpa"));
				list.add(stu);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi " + e.getMessage());
		}return null;
	}
	// tim theo id
	public Student findById(int Id) {
			try(Connection co = DbConnect.getConnection()) {
				String mysql = "select * from student where student_id = ?";
				PreparedStatement ps = co.prepareStatement(mysql);
				ps.setInt(1, Id);
				ResultSet rs = ps.executeQuery();
				rs.next();
				Student stu = new Student(
						rs.getInt("student_id"),
						rs.getString("student_name"),
						rs.getString("gender"),
						rs.getDouble("gpa"));
				return stu;				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
	}
	// them student

	public boolean insert(Student stu) {
		String sql = "INSERT INTO student (student_name, gender, gpa) values(?, ? ,?)";
		try(Connection co = DbConnect.getConnection()) {
			PreparedStatement ps = co.prepareStatement(sql);
			
				ps.setString(1, stu.getStudent_name());
				ps.setString(2, stu.getGender());
				ps.setDouble(3, stu.getGpa());
				
				return ps.executeUpdate() > 0;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	// sửa
	public boolean update(Student stu) {
		try (Connection co = DbConnect.getConnection()){
			String mysql = "update student set student_name=?, gender=?, gpa=? where student_id=?";
			PreparedStatement ps = co.prepareStatement(mysql);
			
			ps.setString(1, stu.getStudent_name());
	        ps.setString(2, stu.getGender());
	        ps.setDouble(3, stu.getGpa());
	        ps.setInt(4, stu.getStudent_id());
	        
	        return ps.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	        return false;	    
		}
	}
	// xoa student
	public boolean delete(Student stu) {
		try(Connection co = DbConnect.getConnection()) {
			String mysql = "delete from student where student_id=?";
			PreparedStatement ps = co.prepareStatement(mysql);
			
	        ps.setInt(1, stu.getStudent_id());
	        
	        return ps.executeUpdate() >0;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	        return false;	
		}
	}
							 	
}
