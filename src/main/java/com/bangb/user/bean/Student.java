package com.bangb.user.bean;

import java.util.List;

public class Student {
	private String stdId;
	private String stdNme;
	private List<SourceCld> scList;
	
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getStdNme() {
		return stdNme;
	}
	public void setStdNme(String stdNme) {
		this.stdNme = stdNme;
	}
	public List<SourceCld> getScList() {
		return scList;
	}
	public void setScList(List<SourceCld> scList) {
		this.scList = scList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scList == null) ? 0 : scList.hashCode());
		result = prime * result + ((stdId == null) ? 0 : stdId.hashCode());
		result = prime * result + ((stdNme == null) ? 0 : stdNme.hashCode());
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
		Student other = (Student) obj;
		if (scList == null) {
			if (other.scList != null)
				return false;
		} else if (!scList.equals(other.scList))
			return false;
		if (stdId == null) {
			if (other.stdId != null)
				return false;
		} else if (!stdId.equals(other.stdId))
			return false;
		if (stdNme == null) {
			if (other.stdNme != null)
				return false;
		} else if (!stdNme.equals(other.stdNme))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdNme=" + stdNme + ", scList=" + scList + "]";
	}
	
	
	
}
