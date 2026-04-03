package lab5bai3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
	private List<Student> list = new ArrayList<>();
	private final String filePath = "student.dat";
	
	public List<Student> getList(){
		return list;
	}
	// đọc file
	public void loadFromFile() {
		
		// file không tồn tại
		File file = new File(filePath);
		if (!file.exists()) {
	        System.out.println("Thông báo: File dữ liệu chưa tồn tại. Hệ thống sẽ khởi tạo danh sách mới.");
	        return;
	    }
		// file rỗng
		
		if(file.length() == 0) {
			System.out.println("File dữ liệu hiện đang rỗng");
			return;
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))){
			 Object data = ois.readObject();
		// sai định dạng	 
		        if (data instanceof List<?>) {
		            list = (List<Student>) data;
		            System.out.println("Đọc file thành công.");
		        } else {
		            System.out.println("Dữ liệu không đúng định dạng!");
		            list = new ArrayList<>();
		        }
			System.out.println("Đã đọc dữ liệu từ file");
		}catch(FileNotFoundException e) {
			System.out.println("File chưa tồn tại,cần tạo mới");
		}catch(IOException | ClassNotFoundException e) {
			System.out.println("File bị lỗi" + e.getMessage());
		}
	}
	// gi file 
	public void saveToFile() {
		if (this.list == null || this.list.isEmpty()) {
	        System.out.println("Cảnh báo: Danh sách trống, không có gì để lưu.");
	        
	    }
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
			oos.writeObject(list);
			System.out.println("Đã ghi file thành công");
		}catch(IOException e) {
			System.out.println("Lỗi ghi file" + e.getMessage());
		}
	}
	// cho phép nhập student
	
	public void inputStudent() {
	    Scanner sc = new Scanner(System.in);
	    String id, name;
	    double gpa;

	    while (true) {
	        System.out.print("Nhập mã SV: ");
	        id = sc.nextLine();
	        if (id.trim().isEmpty()) { 
	            System.out.println("Lỗi: Mã sinh viên không được để trống!");
	        } else {
	            break; 
	        }
	    }

	    
	    while (true) {
	        System.out.print("Nhập tên SV: ");
	        name = sc.nextLine();
	        if (name.trim().isEmpty()) {
	            System.out.println("Lỗi: Tên sinh viên không được để trống!");
	        } else {
	            break;
	        }
	    }

	    
	    while (true) {
	        try {
	            System.out.print("Nhập điểm GPA: ");
	            gpa = Double.parseDouble(sc.nextLine());
	            if (gpa < 0 || gpa > 10) {
	                System.out.println("Lỗi: Điểm GPA phải nằm trong khoảng từ 0 đến 10!");
	            } else {
	                break;
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Lỗi: Vui lòng nhập số thực cho điểm GPA!");
	        }
	    }
	    
	    list.add(new Student(id, name, gpa));
	    System.out.println("Thêm sinh viên thành công!");
	}
}
	

