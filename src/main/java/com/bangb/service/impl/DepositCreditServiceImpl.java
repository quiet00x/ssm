package com.bangb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangb.common.constant.Constant;
import com.bangb.service.BV6070Service;
import com.bangb.user.bean.CreditBaseBean;

@Service
public class DepositCreditServiceImpl{
	
	@Autowired
	private BV6070Service bv6070ServiceImpl;

	/**
	 * 开立存款证明
	 * @param params
	 * @param printType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public CreditBaseBean openCreditProof(CreditBaseBean creditBaseBean, String printType) {
		Map<String, Object> register = bv6070ServiceImpl.registerDepositCredit(creditBaseBean);
		Map<String, Object> resultMap = bv6070ServiceImpl.parseRegisterRet(register);
		
		List<String> registerNoList = (List<String>) resultMap.get(Constant.CreditProof.REGISTER_NO_LIST_PARAM);
		String creditNo = (String) resultMap.get(Constant.CreditProof.CREDIT_NO_PARAM);
		
		creditBaseBean.setCreditNo(creditNo);
		creditBaseBean.setRegisterNoList(registerNoList.toString());
		
		
		return creditBaseBean;
	}

	

}
