package lab4bai1;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
		private List<Student> list = new ArrayList<Student>();
		
		public void addStudent(Student s) {
			list.add(s);
			System.out.println("Thêm sinh viên thành công");
		}
		
		public void displayAll() {
			if(list.isEmpty()) {
				System.out.println("Danh sách trống");
				return;
			}
			System.out.println("Danh sách sinh viên");
			for(Student s : list) {
				s.inThongTin();
			}
		}
		
}
