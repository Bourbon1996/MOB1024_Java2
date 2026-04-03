package asm1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

	public class Document implements Serializable {
	    private String docId;
	    private String title;
	
	    private List<Copy> copies = new ArrayList<>();
	
	    //Constructor 2 tham số (dùng trong Main)
	    public Document(String docId, String title) {
	        this.docId = docId;
	        this.title = title;
	        this.copies = new ArrayList<>();
	    }
	
	    //constructor đầy đủ
	    public Document(String docId, String title, List<Copy> copies) {
	        this.docId = docId;
	        this.title = title;
	        this.copies = copies;
	    }
	
	    public String getDocId() {
	        return docId;
	    }
	
	    public void setDocId(String docId) {
	        this.docId = docId;
	    }
	
	    public String getTitle() {
	        return title;
	    }
	
	    public void setTitle(String title) {
	        this.title = title;
	    }
	
	    public void setCopies(List<Copy> copies) {
	        this.copies = copies;
	    }
	
	    public void addCopy(Copy cp) {
	        this.copies.add(cp);
	    }
	
	    public List<Copy> getCopies() {
	        return copies;
	    }
	
	    @Override
	    public String toString() {
	        return "Mã TL: " + docId + " | Tên: " + title + " | Số bản sao: " + copies.size();
	    }
}