package lab2bai2;

public class Product {
		private String id;
		private String name;
		private double price;
		private ProductCategory category;

		public Product(String id, String name, double price, ProductCategory category ) {
			this.id = id;
			this.name = name;
			this.price = price;
			this.category = category;
		}
		
		public String getId() {
			return this.id;
		}
		
		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public ProductCategory getCategory() {
			return category;
		}

		public void setCategory(ProductCategory category) {
			this.category = category;
		}
		
		
		@Override
		public String toString() {
			return String.format("%-5s %-20s %15.0f %-15s", id, name, price, category );
		}
		
}
