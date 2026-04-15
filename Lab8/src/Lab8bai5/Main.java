package Lab8bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Nhập 5 điểm (có thể bỏ trống):");

        for (int i = 0; i < 5; i++) {
            System.out.print("Điểm " + (i + 1) + ": ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            } else {
                try {
                    int score = Integer.parseInt(input);
                    if (score < 0 || score > 10) {
                        System.out.println("Điểm phải từ 0 đến 10!");
                        i--;
                        continue;
                    }
                    list.add(score);
                }catch (NumberFormatException e) {
                	System.out.println("Nhập sai! Nhập lại.");
                    i--; // nhập lại
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        int sum = 0;        

        for (Integer x : list) {          
                sum += x;               
            }        

        double avg = list.size() > 0 ? (double) sum / list.size() : 0;

        String rank;
        if (avg >= 8) rank = "Giỏi";
        else if (avg >= 6.5) rank = "Khá";
        else rank = "Trung bình";

        //  Text Block + formatted()
        String result = """
                ===== KẾT QUẢ =====
                Danh sách điểm: %s
                Điểm trung bình: %.2f
                Xếp loại: %s
                """.formatted(list, avg, rank);

        System.out.println(result);
    }
}
