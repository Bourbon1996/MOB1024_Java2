package lab2bai2;

import java.util.ArrayList;
import java.util.List;

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
	}

}
