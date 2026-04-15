package entity;

public class Document {
	private String id;
	private String title;
	private String author;
	private String category;
	
	public Document(String id, String title, String author, String category) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
	}

	public Document() {	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + "]";
	}
	
	

	
	
	
}
