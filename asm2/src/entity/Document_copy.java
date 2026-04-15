package entity;

public class Document_copy {
	private String id;
	private String documentId;
	private  Status status;
	
	public Document_copy() {}

	public Document_copy(String id, String documentId, Status status) {
		this.id = id;
		this.documentId = documentId;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
}
