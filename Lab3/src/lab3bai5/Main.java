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
	  	list.add(new Student("sv4", "Duc", StudentType.INTERNATIONAL, 3.1));
	  	list.add(new Student("sv5", "Viet", StudentType.INTERNATIONAL, 3.9));
	  	
	  	//Thống kê số lượng sinh viên theo từng StudentType
	  	
	  	Map<StudentType, Long> countByType = list.stream()
	  	    .collect(Collectors.groupingBy(Student::getType, Collectors.counting()));

	  	System.out.println("Số lượng sinh viên theo loại");
	  	countByType.forEach((type, count) -> System.out.println(type + ": " + count));


	  	// Tính GPA trung bình theo từng StudentType
	  	Map<StudentType, Double> avgGpaByType = list.stream()
	  	    .collect(Collectors.groupingBy(Student::getType, 
	  	                                   Collectors.averagingDouble(Student::getGpa)));

	  	System.out.println("\n GPA trung bình theo loại");
	  	avgGpaByType.forEach((type, avg) -> System.out.printf("%s: %.2f\n", type, avg));


	  	//In loại sinh viên có GPA trung bình cao nhất
	  	System.out.println("\nLoại sinh viên có GPA trung bình cao nhất");
	  	avgGpaByType.entrySet().stream()
	  	    .max(Map.Entry.comparingByValue()) 
	  	    .ifPresent(entry -> {
	  	        System.out.println("Loại cao nhất là: " + entry.getKey());
	  	        System.out.printf("Điểm trung bình: %.2f\n", entry.getValue());
	  	    });
    }
}