package lab2;

import java.util.ArrayList;
import java.util.List;

public class Main {
		public static void main(String[] args) {
			
		int i = 1;
			
				List<Student>  list = new ArrayList<>();
				
				
				list.add(new Student("sv1", "Nguyễn Văn A", StudentType.REGULAR));
				
				list.add(new Student("sv2", "Hoàng Văn B", StudentType.PART_TIME));
				
				list.add(new Student("sv3", "Lê Thị C", StudentType.INTERNATIONAL));
				
				list.add(new Student("sv4", "Trần Thị D", StudentType.REGULAR));
				
				list.add(new Student("sv5", "Hoàng Văn E", StudentType.PART_TIME));
				
				list.add(new Student("sv6", "Hoàng Minh D", StudentType.INTERNATIONAL));
				
				for(Student x : list) {
					
					System.out.println(i + "." + x);
					i++;
				}
				
				
		}
				
}
