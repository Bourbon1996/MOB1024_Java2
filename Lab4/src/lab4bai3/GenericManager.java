package lab4bai3;

import lab4bai4.EmptyListException;
import java.util.ArrayList;
import java.util.List;

public class GenericManager<T> {
	private List<T> list = new ArrayList<>();

    // Thêm phần tử
    public void add(T item) {
        list.add(item);
    }

    // Hiển thị danh sách
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        for (T item : list) {
            System.out.println(item); // gọi toString()
        }
    }

    // Lấy số lượng
    public int size() {
        return list.size();
    }
    
 //Lấy phần tử đầu
    public T getFirst() throws EmptyListException {
        if (list.isEmpty()) {
            throw new EmptyListException("Danh sách rỗng, không có phần tử đầu!");
        }
        return list.get(0);
    }

    //Lấy phần tử cuối
    public T getLast() throws EmptyListException {
        if (list.isEmpty()) {
            throw new EmptyListException("Danh sách rỗng, không có phần tử cuối!");
        }
        return list.get(list.size() - 1);
    }
}
