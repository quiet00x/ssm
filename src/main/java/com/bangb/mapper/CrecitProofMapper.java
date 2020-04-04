package com.bangb.mapper;

import com.bangb.user.bean.CreditBaseBean;

public interface CrecitProofMapper {

	/**
	 * 保存证明开立记录
	 * @param params
	 */
	public void insertCreditOpenHis(CreditBaseBean retBean);
	
	/**
	 * 修改证明开立基本信息
	 * @param retBean
	 */
	public void updateCreditProofBaseInfo(CreditBaseBean retBean);


}
