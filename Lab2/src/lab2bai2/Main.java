package lab2bai2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		
		list.add(new Product("P01", "Laptop Dell", 15000000, ProductCategory.ELECTRONIC));
        list.add(new Product("P02", "iPhone 13", 20000000, ProductCategory.ELECTRONIC));
        list.add(new Product("P03", "Áo thun", 200000, ProductCategory.CLOTHING));
        list.add(new Product("P04", "Quần jean", 500000, ProductCategory.CLOTHING));
        list.add(new Product("P05", "Bánh mì", 15000, ProductCategory.FOOD));
        list.add(new Product("P06", "Sữa Vinamilk", 30000, ProductCategory.FOOD));
        list.add(new Product("P07", "Nồi cơm điện", 800000, ProductCategory.ELECTRONIC));
        list.add(new Product("P08", "Quạt máy", 600000, ProductCategory.ELECTRONIC));
        
        System.out.printf("%-5s %-20s %-15s %-15s\n", "ID", "NAME", "PRICE", "CATEGORY");
        System.out.println("------------------------------------------------------------");

        // duyệt và in ra từng sản phẩm 
        for(Product x : list) {
            System.out.println(x);
        }
        // Sử dụng Map lấy khóa chính là enum để đếm số lượng
        
        Map<ProductCategory, Integer> countMap = new HashMap<>(); // khai báo map
        	for(Product y : list) { // duyệt vòng lặp từng sản phẩm trong list
        		ProductCategory type = y.getCategory(); //lấy loại 
        		if(countMap.containsKey(type)) { // xem loại này đã có trong map chưa 
        			countMap.put(type, countMap.get(type) + 1); //  lấy số lượng và cập nhât(put) vào map 
        		}else 
        			countMap.put(type, 1);       		
        	}
        	
        // Sử dụng Map để tính tổng 	
        Map<ProductCategory, Double> sumMap = new HashMap<>();	
        	for(Product z : list) {
        		ProductCategory type = z.getCategory();
        		if(sumMap.containsKey(type)) {
        			sumMap.put(type, sumMap.get(type) + z.getPrice());
        		}else
        			sumMap.put(type, z.getPrice());
        	}
		
        //in ra số lượng sản phẩm của mỗi loại 
        	System.out.println("Số lượng theo loại");
        	for(Map.Entry<ProductCategory, Integer> E : countMap.entrySet() ) {
        		System.out.println(E.getKey() + " : " + E.getValue());
        	}
       // in ra tổng giá trị sản phẩm theo từng loại
        	System.out.println("Tổng giá trị sản phẩm theo từng loại");
        	for(Map.Entry<ProductCategory, Double> S : sumMap.entrySet()) {
        		System.out.println(S.getKey() + " : " + S.getValue());
        	}
        	
	}
}
