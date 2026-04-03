package lab5bai1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
//try-with-resources tự đóng rồi nen không can close
public class Main {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Ba Đức", "Minh Vũ");
		// Ghi file
		String filePath = "data.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
			for(String name : list) {
				bw.write(name);
				bw.newLine();
				System.out.println("Ghi file thành công");
			}
		}catch(IOException e) {
			System.out.println("Lỗi ghi file " + e.getMessage());
		}finally {
			System.out.println(" Kết thúc");
		}
		// Đọc file
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			System.out.println("Đọc file thành công " + e.getMessage());
		}finally {
			
			System.out.println(" Kết thúc");
		}
	}
}


