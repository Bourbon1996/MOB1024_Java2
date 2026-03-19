package SLIDE1;

public class Main {
	public static void main(String[] args) {
		 System.out.println("11 ps48249 Hoàng Văn Ba Đức");
		 // cách 1
//		Xe xe = new Xe();
//		
//		xe.setHangXe("Lamborghini");
//		xe.setNamSanXuat(1963);
//		 xe.xuat();
		 //cách 2 dùng Constructor có tham số 
		 
		 Xe xe = new Xe("Ferrari", 1939);
		 xe.xuat();
		 
		 Xe xe2 =  new Xe("Porcher", 1928);
		 xe2.xuat();
		 
	}
	
	

}
