package com.bangb.user.bean;

import java.util.List;

public class Teacher {
	private String tchId;
	private String tchNme;
	private List<Source> scList;
	
	public String getTchId() {
		return tchId;
	}
	public void setTchId(String tchId) {
		this.tchId = tchId;
	}
	public String getTchNme() {
		return tchNme;
	}
	public void setTchNme(String tchNme) {
		this.tchNme = tchNme;
	}
	public List<Source> getScList() {
		return scList;
	}
	public void setScList(List<Source> scList) {
		this.scList = scList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scList == null) ? 0 : scList.hashCode());
		result = prime * result + ((tchId == null) ? 0 : tchId.hashCode());
		result = prime * result + ((tchNme == null) ? 0 : tchNme.hashCode());
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
		Teacher other = (Teacher) obj;
		if (scList == null) {
			if (other.scList != null)
				return false;
		} else if (!scList.equals(other.scList))
			return false;
		if (tchId == null) {
			if (other.tchId != null)
				return false;
		} else if (!tchId.equals(other.tchId))
			return false;
		if (tchNme == null) {
			if (other.tchNme != null)
				return false;
		} else if (!tchNme.equals(other.tchNme))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Teacher [tchId=" + tchId + ", tchNme=" + tchNme + ", scList=" + scList + "]";
	}
	
}
