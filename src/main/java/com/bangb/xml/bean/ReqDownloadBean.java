package com.bangb.xml.bean;

public class ReqDownloadBean {
	private String RequestType;
	private String DocumentId;
	private String ResourceObjName;
	private String DownloadPath;
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	public String getDocumentId() {
		return DocumentId;
	}
	public void setDocumentId(String documentId) {
		DocumentId = documentId;
	}
	public String getResourceObjName() {
		return ResourceObjName;
	}
	public void setResourceObjName(String resourceObjName) {
		ResourceObjName = resourceObjName;
	}
	public String getDownloadPath() {
		return DownloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		DownloadPath = downloadPath;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DocumentId == null) ? 0 : DocumentId.hashCode());
		result = prime * result + ((DownloadPath == null) ? 0 : DownloadPath.hashCode());
		result = prime * result + ((RequestType == null) ? 0 : RequestType.hashCode());
		result = prime * result + ((ResourceObjName == null) ? 0 : ResourceObjName.hashCode());
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
		ReqDownloadBean other = (ReqDownloadBean) obj;
		if (DocumentId == null) {
			if (other.DocumentId != null)
				return false;
		} else if (!DocumentId.equals(other.DocumentId))
			return false;
		if (DownloadPath == null) {
			if (other.DownloadPath != null)
				return false;
		} else if (!DownloadPath.equals(other.DownloadPath))
			return false;
		if (RequestType == null) {
			if (other.RequestType != null)
				return false;
		} else if (!RequestType.equals(other.RequestType))
			return false;
		if (ResourceObjName == null) {
			if (other.ResourceObjName != null)
				return false;
		} else if (!ResourceObjName.equals(other.ResourceObjName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReqDownloadBean [RequestType=" + RequestType + ", DocumentId=" + DocumentId + ", ResourceObjName="
				+ ResourceObjName + ", DownloadPath=" + DownloadPath + "]";
	}
	
	
}
