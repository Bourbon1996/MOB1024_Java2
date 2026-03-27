package lab3bai3;

import java.util.ArrayList;
//import java.util.Comparator;
import java.util.List;

import lab3bai2.Employee;

public class Main {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee ("E01", "An", 18));
		list.add(new Employee ("E02", "Bình", 12));
		list.add(new Employee ("E03", "Anh Tuấn", 25));
		list.add(new Employee ("E04", "Cường", 14));
		list.add(new Employee ("E05", "Dũng", 20));
		list.add(new Employee ("E06", "Ân", 15));
		list.add(new Employee ("E07", "Giang", 30));
		list.add(new Employee ("E08", "Hạnh", 30));
		
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
		// chỉ in 1 người cao nhất 
//		Employee maxSalary = list.stream()
//		        .max(Comparator.comparing(Employee::getSalary))
//		        .orElse(null);
//		System.out.println("Lương cao nhất");
//		System.out.println(maxSalary.toString());
//		System.out.println("__________");

//		 OptionalDouble hightsalary = dsNhanVien.stream().mapToDouble(Employee::getSalary).max();
		// in ra tất cả người có luong cao nhất bằng nhau
		list.stream()
		        .filter(e -> e.getSalary() == list.stream()
		                .mapToDouble(Employee::getSalary)
		                .max()
		                .getAsDouble())
		        .forEach(System.out::println);
	}
}	
	
