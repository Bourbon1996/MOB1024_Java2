package lab5bai2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("sv1", "Ba Đức", 3.5),
				new Student("sv2", "Minh Vũ", 3.8));
		
		String filePath = "sinhvien.txt";
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
			oos.writeObject(list);
			System.out.println("Ghi object thành công");
			
		}catch(IOException e) {
			System.out.println("Lỗi ghi " + e.getMessage());
		}finally {
			System.out.println("Kết thúc");
		}
		
		// Đọc object 
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))){
			List<Student> listread = (List<Student>) ois.readObject();
			
			for(Student x : list) {
				System.out.println(x);
			}			
		}catch(IOException | ClassNotFoundException e) {
			System.out.println("Lỗi đọc" + e.getMessage());
		}finally {
			System.out.println("Kết thúc");
		}
	}
}
