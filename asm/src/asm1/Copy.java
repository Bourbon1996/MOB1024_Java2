package asm1;

public class Copy {
	private String copyId;
    private CopyStatus status;
    
	public Copy(String copyId, CopyStatus status) {
		this.copyId = copyId;
		this.status = status;
	}

	public String getCopyId() {
		return copyId;
	}

	public void setCopyId(String copyId) {
		this.copyId = copyId;
	}

	public CopyStatus getStatus() {
		return status;
	}

	public void setStatus(CopyStatus status) {
		this.status = status;
	}
    
	
	
    
}
