package lab3bai1;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.List;





public class ComparatorPredicateforEach {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>(Arrays.asList("An", "Bình", "Chương", "Dương", "Giang", 
	            "Hương", "Khánh", "Linh", "Minh", "Nguyệt", "Phương"));
		
		
		// in toàn bộ danh sách bằng foreach
		System.out.println("Toàn Bộ Danh Sách");
		names.forEach(System.out::println);
		
		//Lọc và in các tên có độ dài > 5.
		System.out.println("Tên có độ dài >5");
		names.stream()
			.filter(x -> x.length()>5)
			.forEach(System.out::println);
		
		//Sắp xếp tên theo thứ tự A–Z và in ra.
		System.out.println("Tên theo thứ tự từ A-Z");
		names.stream()
			.sorted() //(Comparator.reverseOrder()) ngược lại
			.forEach(System.out::println);
		
		//Sắp xếp theo độ dài tên (tăng dần) và in ra
		System.out.println("Tên theo độ dài");
		names.stream()
			.sorted((a,b) -> a.length() - b.length())
			.forEach(System.out::println);
	}
}
