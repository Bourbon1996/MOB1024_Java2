package lab3bai4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
  public static void main(String[] args) {
	  List<Student> list =  new ArrayList<>();
			  	list.add(new Student("sv1", "An", StudentType.REGULAR, 3.5));
			  	list.add(new Student("sv2", "Binh", StudentType.INTERNATIONAL, 3.8));
			  	list.add(new Student("sv3", "Chi", StudentType.PART_TIME, 2.9));
			  	list.add(new Student("sv4", "David", StudentType.INTERNATIONAL, 3.1));
			  	list.add(new Student("sv5", "Elena", StudentType.INTERNATIONAL, 3.9));
			  	list.add(new Student("sv6", "Fanny", StudentType.REGULAR, 2.5));
			  	list.add(new Student("sv7", "Gia", StudentType.PART_TIME, 3.3));
			  	list.add(new Student("sv8", "Hana", StudentType.INTERNATIONAL, 3.2));
			  	list.add(new Student("sv9", "Ivan", StudentType.INTERNATIONAL, 3.7));
			  	list.add(new Student("sv10", "Jack", StudentType.REGULAR, 3.0));
	       
			  //Lọc danh sách INTERNATIONAL có GPA >= 3.2
			  	System.out.println("Danh sách sinh viên INTERNATIONAL có GPA >= 3.2 ");
		        
			  	
		        List<Student> GPAStudents = list.stream()
		                .filter(s -> s.getType() == StudentType.INTERNATIONAL)
		                .filter(s -> s.getGpa() >= 3.2)
		                .collect(Collectors.toList());
		        
		        GPAStudents.forEach(System.out::println);

		     //Sắp xếp giảm dần theo GPA và lấy Top 3
		        System.out.println("\nTop 3 sinh viên có GPA cao nhất");
		        
		        List<Student> top3Students = list.stream()
		                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
		                .limit(3)
		                .collect(Collectors.toList());

		        top3Students.forEach(System.out::println);
  }
}
