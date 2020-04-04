package com.bangb.user.bean;

import lombok.Data;

@Data
public class CreditBaseBean {
	
	private String openNo;
	
	private String creditNo;
	
	private String registerNoList;
	
	private String creditType;
	
	private String cusNo;
	
	private String cusName;
	
	private String email;
	
	private String openDate;
	
	private String openOrgCode;
	
	private String openOrgName;
	
	private String openBranchCode;
	
	private String openBranchName;
	
	private TradeUserBean trlUserBean;
	
	private String dealStatus;
	
	private String errMsg;
}
