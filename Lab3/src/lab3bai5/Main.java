package lab3bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lab3bai4.Student;
import lab3bai4.StudentType;

public class Main {
    public static void main(String[] args) {
    	List<Student> list =  new ArrayList<>();
	  	list.add(new Student("sv1", "An", StudentType.REGULAR, 3.5));
	  	list.add(new Student("sv2", "Binh", StudentType.INTERNATIONAL, 3.8));
	  	list.add(new Student("sv3", "Chi", StudentType.PART_TIME, 2.9));
	  	list.add(new Student("sv4", "David", StudentType.INTERNATIONAL, 3.1));
	  	list.add(new Student("sv5", "Elena", StudentType.INTERNATIONAL, 3.9));
	  	
	  	// 1. Thống kê số lượng sinh viên theo từng StudentType
	  	// Kết quả trả về là một Map với Key là Loại sinh viên và Value là Số lượng (Long)
	  	Map<StudentType, Long> countByType = list.stream()
	  	    .collect(Collectors.groupingBy(Student::getType, Collectors.counting()));

	  	System.out.println("--- 1. Số lượng sinh viên theo loại ---");
	  	countByType.forEach((type, count) -> System.out.println(type + ": " + count));


	  	// 2. Tính GPA trung bình theo từng StudentType
	  	// Kết quả trả về là Map với Value là điểm trung bình (Double)
	  	Map<StudentType, Double> avgGpaByType = list.stream()
	  	    .collect(Collectors.groupingBy(Student::getType, 
	  	                                   Collectors.averagingDouble(Student::getGpa)));

	  	System.out.println("\n--- 2. GPA trung bình theo loại ---");
	  	avgGpaByType.forEach((type, avg) -> System.out.printf("%s: %.2f\n", type, avg));


	  	// 3. In loại sinh viên có GPA trung bình cao nhất
	  	System.out.println("\n--- 3. Loại sinh viên có GPA trung bình cao nhất ---");
	  	avgGpaByType.entrySet().stream()
	  	    .max(Map.Entry.comparingByValue()) // So sánh dựa trên giá trị GPA trung bình
	  	    .ifPresent(entry -> {
	  	        System.out.println("Loại cao nhất là: " + entry.getKey());
	  	        System.out.printf("Điểm trung bình: %.2f\n", entry.getValue());
	  	    });
    }
}