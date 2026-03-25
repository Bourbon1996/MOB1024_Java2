package lab3bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		
			//Lọc nhân viên có salary >= 15_000_000.
			System.out.println("nhân viên có salary >= 15_000_000");
			list.stream()
			.filter(x -> x.getSalary()>= 15_000_000)
			.forEach(System.out::println);
			
			//Sắp xếp nhân viên theo salary giảm dần
			System.out.println("Nhân viên có lương giảm dần");
			list.stream()
		    .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
		    .forEach(System.out::println);
			
			//Lấy danh sách tên nhân viên (List<String>) từ danh sách nhân viên (map)
			System.out.println("Danh sách nhân viên từ map");
			List<String> names = list.stream()
			.map(Employee::getName)
			.collect(Collectors.toList());
			System.out.println(names);
			
			//Đếm số nhân viên có tên bắt đầu bằng chữ “A” (không phân biệt hoa thường).
			System.out.println("Nhân viên bắt đầu bằng chữ A: " +
			list.stream()
			.filter(x -> x.getName().toUpperCase().startsWith("A"))
			.count()
	);
			
			
	}
}
