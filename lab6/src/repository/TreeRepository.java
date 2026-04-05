package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DbConnect;
import entity.Tree;

public class TreeRepository {
	//tât ca danh sach
	public List<Tree> findAll(){
		List<Tree> list = new ArrayList<>();
		try(Connection co = DbConnect.getConnection()) {
			String sql = "select * from Tree";
			PreparedStatement ps = co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Tree tr = new Tree(
						rs.getInt("node_id"),
						rs.getString("node_name"),
						rs.getInt("parent_id"),
						rs.getInt("level"));
				list.add(tr);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
		}return list;
	}
	
	// tim theo id
	public Tree findbyId(int ID) {
		try(Connection co = DbConnect.getConnection()) {
			String sql = "select *from tree where node_id =?";
			PreparedStatement ps = co.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Tree(
					rs.getInt("node_id"),
					rs.getString("node_name"),
					rs.getInt("parent_id"),
					rs.getInt("level"));
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi " + e.getMessage());
			return null;
		}
	}
	// them Tree
	
	public boolean insert(Tree tr) {
		try(Connection co = DbConnect.getConnection()) {
			String sql = "insert into Tree(node_id, node_name, parent_id, level) values(?,?,?,?)";
			PreparedStatement ps = co.prepareStatement(sql);
			
			ps.setInt(1, tr.getNode_id());
	        ps.setString(2, tr.getNode_name());
	        ps.setInt(3, tr.getParent_id());
	        ps.setInt(4, tr.getLevel());
	        
	        return ps.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi thêm: " + e.getMessage());
	        return false;
		}
	}
	
	// sửa
		public boolean update(Tree tr) {
			try (Connection co = DbConnect.getConnection()){
				String mysql = "update tree set node_name=?, parent_id=?, level=? where node_id=?";
				PreparedStatement ps = co.prepareStatement(mysql);
				
				ps.setString(1, tr.getNode_name());
		        ps.setInt(2, tr.getParent_id());
		        ps.setInt(3, tr.getLevel());
		        ps.setInt(4, tr.getNode_id());
		        
		        return ps.executeUpdate() >0;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lỗi thêm: " + e.getMessage());
		        return false;	    
			}
		}
		// xoa 
		public boolean delete(Tree tr) {
			try(Connection co = DbConnect.getConnection()) {
				String mysql = "delete from tree where node_id=?";
				PreparedStatement ps = co.prepareStatement(mysql);
				
		        ps.setInt(1, tr.getNode_id());
		        
		        return ps.executeUpdate() >0;
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lỗi thêm: " + e.getMessage());
		        return false;	
			}
		}
}
