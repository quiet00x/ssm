package com.bangb.xml.bean;

import java.util.List;

public class ReqUploadBean {
	private String BatchIndex;
	private String AttrType;
	private String BizType;
	private String CaseID;
	private String DocumentId;
	private String DocumentIndex;
	private String DocumentType;
	private String Location;
	private List<ResourceBean> resourceList;
	public String getBatchIndex() {
		return BatchIndex;
	}
	public void setBatchIndex(String batchIndex) {
		BatchIndex = batchIndex;
	}
	public String getAttrType() {
		return AttrType;
	}
	public void setAttrType(String attrType) {
		AttrType = attrType;
	}
	public String getBizType() {
		return BizType;
	}
	public void setBizType(String bizType) {
		BizType = bizType;
	}
	public String getCaseID() {
		return CaseID;
	}
	public void setCaseID(String caseID) {
		CaseID = caseID;
	}
	public String getDocumentId() {
		return DocumentId;
	}
	public void setDocumentId(String documentId) {
		DocumentId = documentId;
	}
	public String getDocumentIndex() {
		return DocumentIndex;
	}
	public void setDocumentIndex(String documentIndex) {
		DocumentIndex = documentIndex;
	}
	public String getDocumentType() {
		return DocumentType;
	}
	public void setDocumentType(String documentType) {
		DocumentType = documentType;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public List<ResourceBean> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<ResourceBean> resourceList) {
		this.resourceList = resourceList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AttrType == null) ? 0 : AttrType.hashCode());
		result = prime * result + ((BatchIndex == null) ? 0 : BatchIndex.hashCode());
		result = prime * result + ((BizType == null) ? 0 : BizType.hashCode());
		result = prime * result + ((CaseID == null) ? 0 : CaseID.hashCode());
		result = prime * result + ((DocumentId == null) ? 0 : DocumentId.hashCode());
		result = prime * result + ((DocumentIndex == null) ? 0 : DocumentIndex.hashCode());
		result = prime * result + ((DocumentType == null) ? 0 : DocumentType.hashCode());
		result = prime * result + ((Location == null) ? 0 : Location.hashCode());
		result = prime * result + ((resourceList == null) ? 0 : resourceList.hashCode());
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
		ReqUploadBean other = (ReqUploadBean) obj;
		if (AttrType == null) {
			if (other.AttrType != null)
				return false;
		} else if (!AttrType.equals(other.AttrType))
			return false;
		if (BatchIndex == null) {
			if (other.BatchIndex != null)
				return false;
		} else if (!BatchIndex.equals(other.BatchIndex))
			return false;
		if (BizType == null) {
			if (other.BizType != null)
				return false;
		} else if (!BizType.equals(other.BizType))
			return false;
		if (CaseID == null) {
			if (other.CaseID != null)
				return false;
		} else if (!CaseID.equals(other.CaseID))
			return false;
		if (DocumentId == null) {
			if (other.DocumentId != null)
				return false;
		} else if (!DocumentId.equals(other.DocumentId))
			return false;
		if (DocumentIndex == null) {
			if (other.DocumentIndex != null)
				return false;
		} else if (!DocumentIndex.equals(other.DocumentIndex))
			return false;
		if (DocumentType == null) {
			if (other.DocumentType != null)
				return false;
		} else if (!DocumentType.equals(other.DocumentType))
			return false;
		if (Location == null) {
			if (other.Location != null)
				return false;
		} else if (!Location.equals(other.Location))
			return false;
		if (resourceList == null) {
			if (other.resourceList != null)
				return false;
		} else if (!resourceList.equals(other.resourceList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReqUploadBean [BatchIndex=" + BatchIndex + ", AttrType=" + AttrType + ", BizType=" + BizType
				+ ", CaseID=" + CaseID + ", DocumentId=" + DocumentId + ", DocumentIndex=" + DocumentIndex
				+ ", DocumentType=" + DocumentType + ", Location=" + Location + ", resourceBean=" + resourceList + "]";
	}
	
}
