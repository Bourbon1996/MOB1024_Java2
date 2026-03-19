package lab1;

public class ImportedProduct extends Product {
	
	private  double importTaxRate;
	private double shippingFee;
	
	public ImportedProduct() {}
	
	public ImportedProduct(String id, String name, double basePrice,
			double importTaxRate, double shippingFee) {
		super(id, name, basePrice);
		this.importTaxRate = importTaxRate;
		this.shippingFee = shippingFee;
	}
	
	public double getImportTaxRate() {
		return this.importTaxRate;
	}
	
	public boolean setImportTaxRate(double importTaxRate) {
		if(importTaxRate >= 0 && importTaxRate <=1) {
			 this.importTaxRate = importTaxRate;
			 return true;
		} 
			return false;
	}
	
	public double getShippingFee() {
		return this.shippingFee;
		
	}
	
	public boolean setShippingFee(double shippingFee) {
		if(shippingFee >=0) {
			this.shippingFee = shippingFee;
			return true;
		}
			return false;
	}
	
	@Override
	
	public double finalPrice() {
		return super.finalPrice() + super.finalPrice()* this.importTaxRate + this.shippingFee;
	}

	@Override
	public String toString() {
		return super.toString() + "ImportedProduct [importTaxRate=" + importTaxRate + ", shippingFee=" + shippingFee + "]";
	}
	
	
}
