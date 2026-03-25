package lab3bai3;

import java.util.ArrayList;
import java.util.List;

import lab3bai2.Employee;

public class Main {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee ("E01", "An", 18_000_000));
		list.add(new Employee ("E02", "Bình", 12_000_000));
		list.add(new Employee ("E03", "Anh Tuấn", 25_000_000));
		list.add(new Employee ("E04", "Cường", 14_500_000));
		list.add(new Employee ("E05", "Dũng", 20_000_000));
		list.add(new Employee ("E06", "Ân", 15_500_000));
		list.add(new Employee ("E07", "Giang", 9_000_000));
		list.add(new Employee ("E08", "Hạnh", 30_000_000));
		
		//Tổng lương tất cả nhân viên.
		
		double SumSalary = list.stream()
				.mapToDouble(Employee::getSalary)
				.sum();
				System.out.printf("Tổng lương tất cả nhân viên: %,.0f\n", SumSalary);
				
				
		//Lương trung bình.
		
		double svgSalary = list.stream()
				.mapToDouble(Employee::getSalary)
				.average()
				.orElse(0.0);
		System.out.printf("Trung bình lương: %,.0f\n", svgSalary);
		
		//Nhân viên có lương cao nhất (kết quả là 1 Employee).
		
		Employee maxSalary = list.stream()
				.sorted((a,b) ->Double.compare(b.getSalary(), a.getSalary()))
				.findFirst()
				.orElse(null);
		System.out.println("Nhân viên có lương cao nhất là: ");
		if(maxSalary != null) {
			System.out.println(maxSalary);
		}else {
			System.out.println("Không có nhân viên nào trong danh sách.");
		}
	}
}	
	
