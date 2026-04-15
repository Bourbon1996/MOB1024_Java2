package Lab8bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Nhập 5 điểm kiểm tra:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Điểm " + (i + 1) + ": ");
            String input = sc.nextLine();

            if (input.isEmpty()) {
                list.add(null);
            } else {
                list.add(Integer.parseInt(input)); // autoboxing
            }
        }

        System.out.println("Danh sách điểm: " + list);

        int sum = 0;
        int count = 0;

        for (Integer x : list) {
            if (x != null) {
                sum += x; // unboxing
                count++;
            }
        }

        double avg = count > 0 ? (double) sum / count : 0;
        System.out.println("Điểm trung bình: " + avg);

        if (avg >= 8) {
            System.out.println("Xếp loại: Giỏi");
        } else if (avg >= 6.5) {
            System.out.println("Xếp loại: Khá");
        } else {
            System.out.println("Xếp loại: Trung bình");
        }
    }
}