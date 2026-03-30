package asm1;

import java.io.Serializable;
import java.util.ArrayList;
//Đây là một "đánh dấu" cho Java biết rằng đối tượng này có thể chuyển đổi thành chuỗi byte để ghi xuống file 
//.dat. Nếu thiếu dòng này, chương trình sẽ báo lỗi NotSerializableException khi bạn lưu file.
import java.util.List;

public class Document implements Serializable {
		private String docId;
		private String title;
		
		private List<Copy> copies = new ArrayList<Copy>(); //quan hệ 1 -N 1 tài liệu chứa 1 danh sách với N nhiều bản sao

		public Document(String docId, String title, List<Copy> copies) {
			this.docId = docId;
			this.title = title;
		}
		// thêm bản sao vào tài liệu 
		public void addCopy(Copy cp) {
			this.copies.add(cp);
		}
		// lấy ra dah sachs để hiển thị
		public List<Copy> getCopies(){
			return copies;
		}
		
		@Override
		public String toString() {
			return "Mã TL: " + docId + " | Tên: " + title + " | Số bản sao:" + copies.size();
		}
		
}
