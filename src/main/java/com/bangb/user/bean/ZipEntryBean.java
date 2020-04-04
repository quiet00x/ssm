package com.bangb.user.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ZipEntryBean {
	// 源文件资源路径
	private String srcFilePath;
	// 源文件名
	private String srcFileName;
	// 重命名
	private String fileReName;
	
	public ZipEntryBean() {
		super();
	}
	
	public ZipEntryBean(String srcFilePath) {
		super();
		this.srcFilePath = srcFilePath;
	}


	public ZipEntryBean(String srcFilePath, String srcFileName, String fileReName) {
		super();
		this.srcFilePath = srcFilePath;
		this.srcFileName = srcFileName;
		this.fileReName = fileReName;
	}
	
	public ZipEntryBean(String srcFilePath, String fileReName) {
		super();
		this.srcFilePath = srcFilePath;
		this.fileReName = fileReName;
	}

//	public String getSrcFilePath() {
//		return srcFilePath;
//	}
//	public void setSrcFilePath(String srcFilePath) {
//		this.srcFilePath = srcFilePath;
//	}
//	public String getSrcFileName() {
//		return srcFileName;
//	}
//	public void setSrcFileName(String srcFileName) {
//		this.srcFileName = srcFileName;
//	}
//	public String getFileReName() {
//		return fileReName;
//	}
//	public void setFileReName(String fileReName) {
//		this.fileReName = fileReName;
//	}
//	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((fileReName == null) ? 0 : fileReName.hashCode());
//		result = prime * result + ((srcFileName == null) ? 0 : srcFileName.hashCode());
//		result = prime * result + ((srcFilePath == null) ? 0 : srcFilePath.hashCode());
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ZipEntryBean other = (ZipEntryBean) obj;
//		if (fileReName == null) {
//			if (other.fileReName != null)
//				return false;
//		} else if (!fileReName.equals(other.fileReName))
//			return false;
//		if (srcFileName == null) {
//			if (other.srcFileName != null)
//				return false;
//		} else if (!srcFileName.equals(other.srcFileName))
//			return false;
//		if (srcFilePath == null) {
//			if (other.srcFilePath != null)
//				return false;
//		} else if (!srcFilePath.equals(other.srcFilePath))
//			return false;
//		return true;
//	}
//	
//	@Override
//	public String toString() {
//		return "ZipEntryBean [srcFilePath=" + srcFilePath + ", srcFileName=" + srcFileName + ", fileReName="
//				+ fileReName + "]";
//	}

}
