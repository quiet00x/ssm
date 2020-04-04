package com.bangb.service;

import java.util.Map;

import com.bangb.user.bean.CreditBaseBean;

public interface BV6070Service {

	public Map<String, Object> registerDepositCredit(CreditBaseBean creditBaseBean);

	public Map<String, Object> parseRegisterRet(Map<String, Object> register);

}
