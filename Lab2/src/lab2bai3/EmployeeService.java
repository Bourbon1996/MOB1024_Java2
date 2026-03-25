package lab2bai3;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
	private List<Employee> list = new ArrayList<Employee>();
	
	public void add(Employee x) {
		list.add(x);
	}
	
	public void display() {
		if(list.isEmpty()) {
			System.out.println("Danh sách trống");
		}else {
			for(Employee y : list) {
				System.out.println(y);
			}
		}
	}
	
	public Employee  find(String id) {
		for(Employee z : list) {
			if(z.getId().equalsIgnoreCase(id)) {
				return z;
				}
		}return null;
	}
	
	public boolean update(String id, double newSalary) {
	    Employee s = find(id); 
	    if (s != null) {
	        s.setSalary(newSalary); 
	        return true; 
	    }
	    return false; 
	}
	
}
