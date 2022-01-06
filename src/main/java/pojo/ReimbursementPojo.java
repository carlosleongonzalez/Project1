package pojo;

public class ReimbursementPojo {
	
	private int reimbursementId;
	private String reimbursementDate;
	private int reimbursementAmount;
	private String reimbursementStatus;
	private String reimbursementWorker;
	private boolean reimbursementRemoved;
	public ReimbursementPojo() {
		super();
		
	}
	public ReimbursementPojo(int reimbursementId, String reimbursementDate, int reimbursementAmount,
			String reimbursementStatus, String reimbursementWorker, boolean reimbursementRemoved) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementDate = reimbursementDate;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementWorker = reimbursementWorker;
		this.reimbursementRemoved = reimbursementRemoved;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public String getReimbursementDate() {
		return reimbursementDate;
	}
	public void setReimbursementDate(String reimbursementDate) {
		this.reimbursementDate = reimbursementDate;
	}
	public int getReimbursementAmount() {
		return reimbursementAmount;
	}
	public void setReimbursementAmount(int reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}
	public String getReimbursementStatus() {
		return reimbursementStatus;
	}
	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}
	public String getReimbursementWorker() {
		return reimbursementWorker;
	}
	public void setReimbursementWorker(String reimbursementWorker) {
		this.reimbursementWorker = reimbursementWorker;
	}
	public boolean isReimbursementRemoved() {
		return reimbursementRemoved;
	}
	public void setReimbursementRemoved(boolean reimbursementRemoved) {
		this.reimbursementRemoved = reimbursementRemoved;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;	
		result = prime * result + reimbursementId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementPojo other = (ReimbursementPojo) obj;
		
		if (reimbursementId != other.reimbursementId)
			return false;		
		return true;
	}
	@Override
	public String toString() {
		return "ReimbursementPojo [reimbursementId=" + reimbursementId + ", reimbursementDate=" + reimbursementDate
				+ ", reimbursementAmount=" + reimbursementAmount + ", reimbursementStatus=" + reimbursementStatus
				+ ", reimbursementWorker=" + reimbursementWorker + ", reimbursementRemoved=" + reimbursementRemoved
				+ "]";
	}
	
}
