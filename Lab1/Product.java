package lab1;

public class Product {
	private String id;
	private String name;
	private double basePrice;
	
	public Product() {}
	
	// Khởi tạo Constructor
	public Product(String id, String name, double basePrice) {
		this.id = id;
		this.name = name;
		this.basePrice = basePrice;
	}	
	// Khởi tạo getter, setter
		
	public String getId() {
		return this.id;
	}
	
	// validate ID
	public boolean setId(String id) {
		if(id != "") {
			this.id = id;
			return true;
		}
		return false;				
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBasePrice() {
		return this.basePrice;
	}
	
	public boolean setBasePrice(double basePrice) {
		if(basePrice >=0) {
			this.basePrice = basePrice;
			return true;
		} return false;
			
		
	}
	
	// Method finalPrice = basePrice
	public double finalPrice() {
		return this.basePrice;
	}

	
	// Method toString( dùng để in thông tin object )
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", basePrice=" + basePrice +  ", finalPrice="+ finalPrice() + "]";
	}
	
	
	
	
	
	
}
	
	
	

