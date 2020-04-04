package test.bean;

public class StmtBean {
	private int id;
	private String stmtId;
	private String cusNo;
	private String acctNo;
	private String stmtDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStmtId() {
		return stmtId;
	}
	public void setStmtId(String stmtId) {
		this.stmtId = stmtId;
	}
	public String getCusNo() {
		return cusNo;
	}
	public void setCusNo(String cusNo) {
		this.cusNo = cusNo;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getStmtDate() {
		return stmtDate;
	}
	public void setStmtDate(String stmtDate) {
		this.stmtDate = stmtDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((cusNo == null) ? 0 : cusNo.hashCode());
		result = prime * result + id;
		result = prime * result + ((stmtDate == null) ? 0 : stmtDate.hashCode());
		result = prime * result + ((stmtId == null) ? 0 : stmtId.hashCode());
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
		StmtBean other = (StmtBean) obj;
		if (acctNo == null) {
			if (other.acctNo != null)
				return false;
		} else if (!acctNo.equals(other.acctNo))
			return false;
		if (cusNo == null) {
			if (other.cusNo != null)
				return false;
		} else if (!cusNo.equals(other.cusNo))
			return false;
		if (id != other.id)
			return false;
		if (stmtDate == null) {
			if (other.stmtDate != null)
				return false;
		} else if (!stmtDate.equals(other.stmtDate))
			return false;
		if (stmtId == null) {
			if (other.stmtId != null)
				return false;
		} else if (!stmtId.equals(other.stmtId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StmtBean [id=" + id + ", stmtId=" + stmtId + ", cusNo=" + cusNo + ", acctNo=" + acctNo + ", stmtDate="
				+ stmtDate + "]";
	}
	
}
