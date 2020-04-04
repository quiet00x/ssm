package com.bangb.bean;

import lombok.Data;

@Data
public class FuncCodeBean {
	// 功能吗
	private String funcCode;
	// 机构类型
	private String orgType;
	
	public FuncCodeBean(String funcCode, String orgType) {
		super();
		this.funcCode = funcCode;
		this.orgType = orgType;
	}
	
	

}
