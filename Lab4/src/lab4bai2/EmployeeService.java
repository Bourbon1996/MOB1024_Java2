package lab4bai2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
	private List<Employee> employees = new ArrayList<>();

    // Thêm nhân viên
    public void addEmployee(Employee emp)
            throws DuplicateEmployeeException, InvalidSalaryException {

        // Check trùng ID
        for (Employee e : employees) {
            if (e.getId().equals(emp.getId())) {
                throw new DuplicateEmployeeException("ID đã tồn tại!");
            }
        }

        // Check lương
        if (emp.getSalary() < 0) {
            throw new InvalidSalaryException("Lương không được âm!");
        }

        employees.add(emp);
    }

    // Tìm theo ID
    public Employee findById(String id) {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }
}
