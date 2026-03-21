package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int i = 1;
		int chon = 0 ;
			
				List<Student>  list = new ArrayList<>();
				
				
				list.add(new Student("sv1", "Nguyễn Văn A", StudentType.REGULAR));
				
				list.add(new Student("sv2", "Hoàng Văn B", StudentType.PART_TIME));
				
				list.add(new Student("sv3", "Lê Thị C", StudentType.INTERNATIONAL));
				
				list.add(new Student("sv4", "Trần Thị D", StudentType.REGULAR));
				
				list.add(new Student("sv5", "Hoàng Văn E", StudentType.PART_TIME));
				
				list.add(new Student("sv6", "Hoàng Minh D", StudentType.INTERNATIONAL));
				
				
			
			
				do {
					System.out.println("------MENU------");
					System.out.println("1. Danh sách sinh viên");
					System.out.println("2. Danh sách từng loại sinh viên ");
					System.out.println("3. Số lượng sinh viên ");
					System.out.println("4. Thoát");
					System.out.println("Vui lòng nhập lại từ 1 -> 4");
					chon = s.nextInt();
					
					
					switch(chon){
					
					 		case 1:
					 			System.out.printf("%-5s %-20s %-15s\n", "ID", "NAME", "TYPE");
					 			System.out.println("------------------------------------------------");
					 			for(Student x : list) {	
								System.out.println(i + "." + x);
								i++;
									
								}
					 			
					 			break;
					 		case 2:
					 		    System.out.println("\nChon loai:");
					 		    System.out.println("1. REGULAR");
					 		    System.out.println("2. PART_TIME");
					 		    System.out.println("3. INTERNATIONAL");
					 		    int kieu = s.nextInt();

					 		    StudentType type = null;

					 		    switch (kieu) {
					 		        case 1:
					 		            type = StudentType.REGULAR;
					 		            break;
					 		        case 2:
					 		            type = StudentType.PART_TIME;
					 		            break;
					 		        case 3:
					 		            type = StudentType.INTERNATIONAL;
					 		            break;
					 		        default:
					 		            System.out.println("Lua chon khong hop le!");
					 		    }

					 		    
					 		    if (type != null) {
					 		        System.out.println("\nKet qua:");

					 		        for (Student sv : list) {
					 		            if (sv.getType() == type) {  
					 		                System.out.println(sv);
					 		            	
					 		            }
					 		        }
					 		    }
					 		    break;
					 			
					 	
					 		case 3:					 		
					 		    int regular = 0;
					 		    int partTime = 0;
					 		    int international = 0;

					 		    for (Student sv : list) {
					 		        switch (sv.getType()) {
					 		            case REGULAR:
					 		                regular++;
					 		                break;

					 		            case PART_TIME:
					 		                partTime++;
					 		                break;

					 		            case INTERNATIONAL:
					 		                international++;
					 		                break;
					 		        }
					 		    }

					 		    System.out.println("\nSo luong sinh vien:");
					 		    System.out.println("REGULAR: " + regular);
					 		    System.out.println("PART_TIME: " + partTime);
					 		    System.out.println("INTERNATIONAL: " + international);
					 		    break;
					 			
					 		case 4:
					 			System.out.println("Kết thúc chương trình");
					 			break;
					 		default:
			                    System.out.println(" Vui lòng nhập lại từ 1-->4");
						 
					 }
					
					
				}while(chon !=0);
		}
				
}
