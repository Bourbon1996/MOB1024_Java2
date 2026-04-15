package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connect.DbConnect;
import entity.Employee;

public class EmployeeRepository {

    // Lấy tất cả nhân viên
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection co = DbConnect.getConnection();
             PreparedStatement ps = co.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary")
                ));
            }

            return list;

        } catch (SQLException e) {
            logDataAccessException(e);
            return new ArrayList<>(); // tránh null
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Thêm nhân viên
    public boolean add(Employee el) {
        String sql = "INSERT INTO employee(id, name, salary) VALUES (?, ?, ?)";

        try (Connection co = DbConnect.getConnection();
             PreparedStatement ps = co.prepareStatement(sql)) {

            ps.setInt(1, el.getId());
            ps.setString(2, el.getName());
            ps.setDouble(3, el.getSalary());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            logDataAccessException(e);
            return false;
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
            return false;
        }
    }

    // Cập nhật nhân viên
    public boolean update(Employee el) {
        String sql = "UPDATE employee SET name = ?, salary = ? WHERE id = ?";

        try (Connection co = DbConnect.getConnection();
             PreparedStatement ps = co.prepareStatement(sql)) {

            ps.setString(1, el.getName());
            ps.setDouble(2, el.getSalary());
            ps.setInt(3, el.getId());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.err.println("Không tìm thấy ID: " + el.getId());
                return false;
            }

            return true;

        } catch (SQLException e) {
            logDataAccessException(e);
            return false;
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
            return false;
        }
    }

    // Xóa nhân viên
    public boolean delete(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection co = DbConnect.getConnection();
             PreparedStatement ps = co.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.err.println("Không tìm thấy ID: " + id);
                return false;
            }

            return true;

        } catch (SQLException e) {
            logDataAccessException(e);
            return false;
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
            return false;
        }
    }

    // Tìm theo ID (Callable)
    public Employee findById(int id) {
        String sql = "{call findbyid(?)}";

        try (Connection co = DbConnect.getConnection();
             CallableStatement cs = co.prepareCall(sql)) {

            cs.setInt(1, id);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("salary")
                    );
                }
            }

        } catch (SQLException e) {
            logDataAccessException(e);
            return null;
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
            return null;
        }

        return null;
    }

    // Log lỗi SQL gọn
    private static void logDataAccessException(SQLException e) {
        String state = e.getSQLState();
        int code = e.getErrorCode();

        if ("42S02".equals(state)) {
            System.err.println("Bảng không tồn tại!");
        } else if ("42000".equals(state) || code == 1305) {
            System.err.println("Sai hoặc không tồn tại stored procedure!");
        } else if ("08S01".equals(state) || "08000".equals(state)) {
            System.err.println("Mất kết nối MySQL!");
        } else {
            System.err.println("Lỗi SQL: " + e.getMessage());
        }
    }
}