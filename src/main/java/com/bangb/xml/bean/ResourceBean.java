package com.bangb.xml.bean;

public class ResourceBean {
	private String ResourceObjectFullName;
	private String ResourceObjectName;
	public String getResourceObjectFullName() {
		return ResourceObjectFullName;
	}
	public void setResourceObjectFullName(String resourceObjectFullName) {
		ResourceObjectFullName = resourceObjectFullName;
	}
	public String getResourceObjectName() {
		return ResourceObjectName;
	}
	public void setResourceObjectName(String resourceObjectName) {
		ResourceObjectName = resourceObjectName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ResourceObjectFullName == null) ? 0 : ResourceObjectFullName.hashCode());
		result = prime * result + ((ResourceObjectName == null) ? 0 : ResourceObjectName.hashCode());
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
		ResourceBean other = (ResourceBean) obj;
		if (ResourceObjectFullName == null) {
			if (other.ResourceObjectFullName != null)
				return false;
		} else if (!ResourceObjectFullName.equals(other.ResourceObjectFullName))
			return false;
		if (ResourceObjectName == null) {
			if (other.ResourceObjectName != null)
				return false;
		} else if (!ResourceObjectName.equals(other.ResourceObjectName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ResourceBean [ResourceObjectFullName=" + ResourceObjectFullName + ", ResourceObjectName="
				+ ResourceObjectName + "]";
	}
	
}
