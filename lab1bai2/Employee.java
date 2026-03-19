package lab1bai2;

public class Employee {
	
	private String id;
	private String name;
	private double basicSalaray;
	
	
	public Employee() {}
	
	// Tạo constructor 
	public Employee(String id, String name, double basicSalaray) {
		this.id =  id;
		this.name =  name;
		this.basicSalaray = basicSalaray;
	}
		
	// Tạo getter setter 
		public String getId() {
			return this.id;
		}
		
		public boolean setid(String id) {
			if(id != "") {
				this.id = id;
				return true;
			} 
				
			return false;
		}
		
		public String getName() {
			return this.name;
		}
		
		public void setname(String name) {
			this.name = name;
		}
		
		public double getBasicSalaray() {
			return this.basicSalaray;
		}
		
		public boolean setbasicSalaray(double basicSalaray) {
			if(basicSalaray >= 0) {
				this.basicSalaray = basicSalaray;
				return true;
			} 
			return false;
				
			
		}
		// Method income() =  basicSalaray
		public double income() {
			return basicSalaray;
		}

		
		// Method toString( dùng để in thông tin object )
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", basicSalaray=" + basicSalaray + "]";
		}
		
			
	}	
				
	
