package lab1;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
//		Product sp1 = new Product("SP1", "Nước Ngọt", 15000);
//		Product sp2 = new Product("SP2" ,"Bánh Kẹo", 10000);
//		Product sp3 = new Product("SP3", "Đồ ăn vặt", 50000);
//		
//		ImportedProduct sp4 = new ImportedProduct("SP4", "Coffe", 25000, 0.5, 5000);
//		ImportedProduct sp5 = new ImportedProduct("SP5", "Thuốc lá", 30000, 0.8, 5000);
//		
//		Product [] list = {sp1, sp2, sp3, sp4, sp5};
//		
//		// dùng for each để duyệt và in ra trong toString
//		
//		for(Product x : list) {
//			System.out.println(x);
//		}
//		
//		
//		// Tìm sản phẩm có giá cao nhất 
//		
//		Product max = list[0];
//		
//		for(Product x : list) {
//			if(x.finalPrice() > max.finalPrice()) {
//				max = x;
//			}
//		}
//		
//		System.out.println("The most expensive product");
//		System.out.println(max);
		
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		// tạo 5 sản phẩm 
		
		// cách 1 nhâp trực tiếp sau đó add vào list
		Product sp1 = new Product("SP1", "Nước Ngọt", 15 );
		list.add(sp1);
		
		// hoặc add và nhập trong add
		list.add(new Product ("SP2", "Bánh Kẹo", 10));
		list.add(new Product ("SP3", "Đồ Ăn Vặt", 5));
		
		list.add(new ImportedProduct("SP4", "Coffe", 25, 0.1, 1));
		list.add(new ImportedProduct("SP5", "Thuốc Lá", 10, 0.5, 1));
		
		for(Product x : list) {
			System.out.println(x.toString());
		}
		
		Product max = list.get(0);
		
		for(Product x : list) {
			if(x.finalPrice() > max.finalPrice()) {
				max = x;
			}
		}
		
		System.out.println("The most expensive product");
		System.out.println(max);

				
	}
}
