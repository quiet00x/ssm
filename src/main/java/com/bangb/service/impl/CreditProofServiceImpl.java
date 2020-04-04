package com.bangb.service.impl;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangb.common.constant.Constant;
import com.bangb.common.constant.WsErrConstant;
import com.bangb.common.exception.BusinessException;
import com.bangb.common.untils.MapCheckUtil;
import com.bangb.common.untils.TranceUtil;
import com.bangb.mapper.CrecitProofMapper;
import com.bangb.service.CreditProofService;
import com.bangb.user.bean.CreditBaseBean;

@Service
public class CreditProofServiceImpl extends CreditProofBaseService implements CreditProofService {
	
	private final static String[] OPEN_CRC_PARAM = new String[]{"creditType","cusNo","openDate","email"};

	@Autowired
	private DepositCreditServiceImpl depositCreditServiceImpl;
	@Autowired
	private DepositTradeCreditServiceImpl depositTradeCreditServiceImpl;
	@Autowired
	private FinancialCreditServiceImpl financialCreditServiceImpl;
	@Autowired
	private FinancialTradeCreditServiceImpl financialTradeCreditServiceImpl;
	@Autowired
	private GoldCreditServiceImpl goldCreditServiceImpl;
	@Autowired
	private FundCreditServiceImpl fundCreditServiceImpl;
	@Autowired
	private LoanCreditServiceImpl loanCreditServiceImpl;
	
	@Autowired
	private CrecitProofMapper crecitProofMapper;
	
	@Override
	public Map<String, Object> openCreditProof(Map<String, Object> params) {
		// 参数去空
		MapCheckUtil.mapTrim(params);
		// 参数校验
		MapCheckUtil.requiredCheck(Arrays.asList(OPEN_CRC_PARAM), params);
		// 获取唯一标识
		String openNo = Constant.BANGBB_SYSTEM_CODE 
				+ System.currentTimeMillis()
				+ new Random(100).nextInt();
		
		// 获取凭证类型
		String creditType = (String) params.get(Constant.CreditProof.CREDIT_TYPE_PARAM);
		
		String printType = (String) params.get(Constant.CreditProof.CREDIT_PRINT_TYPE_PARAM);
	
		CreditBaseBean retBean = null;
		try {
			retBean = TranceUtil.toBean(params, CreditProofBaseService.class);
			
			retBean.setOpenNo(openNo);
			// 保存开立记录
			crecitProofMapper.insertCreditOpenHis(retBean);
			
			switch (creditType) {
			case Constant.CreditProof.CREDIT_TYPE_DEPOSIT_CODE :
				retBean = depositCreditServiceImpl.openCreditProof(retBean,printType);
				break;
			case Constant.CreditProof.CREDIT_TYPE_DEPOSIT_TRADE_CODE :
				retBean = depositTradeCreditServiceImpl.openCreditProof(retBean,printType);
				break;
			case Constant.CreditProof.CREDIT_TYPE_FINANCIAL_CODE :
				retBean = financialCreditServiceImpl.openCreditProof(retBean,printType);
				break;
			case Constant.CreditProof.CREDIT_TYPE_FINANCIAL_TRADE_CODE :
				retBean = financialTradeCreditServiceImpl.openCreditProof(retBean,printType);
				break;
			case Constant.CreditProof.CREDIT_TYPE_GOLD_CODE :
				retBean = goldCreditServiceImpl.openCreditProof(retBean,printType);
				break;
			case Constant.CreditProof.CREDIT_TYPE_FUND_CODE :
				retBean = fundCreditServiceImpl.openCreditProof(retBean,printType);
				break;
			case Constant.CreditProof.CREDIT_TYPE_LOAN_CODE :
				retBean = loanCreditServiceImpl.openCreditProof(retBean,printType);
				break;
			default :
				throw new BusinessException(WsErrConstant.REQ_PARAMS_ERROR_CODE, 
						"暂不支持该种类型凭证开立，credit:" + creditType);
			}
		} catch (IllegalArgumentException e) {
			throw new BusinessException(WsErrConstant.ILLEGAL_ARGUMENT_EXCEPTION_CODE, 
					WsErrConstant.ILLEGAL_ARGUMENT_EXCEPTION_MSG,e);
		} catch (IllegalAccessException e) {
			throw new BusinessException(WsErrConstant.ILLEGAL_ACCESS_EXCEPTION_CODE, 
					WsErrConstant.ILLEGAL_ACCESS_EXCEPTION_MSG,e);
		} catch (InstantiationException e) {
			throw new BusinessException(WsErrConstant.INSTANTIATION_EXCEPTION_CODE, 
					WsErrConstant.INSTANTIATION_EXCEPTION_MSG,e);
		}
		// 更新开立记录信息
		crecitProofMapper.updateCreditProofBaseInfo(retBean);
		
		return null;
	}

	@Override
	public Map<String, Object> openTradeProof(Map<String, Object> params) {
		// 参数去空
		MapCheckUtil.mapTrim(params);
		// 参数校验
		MapCheckUtil.requiredCheck(Arrays.asList(OPEN_CRC_PARAM), params);
		
		// 获取唯一标识
		String openNo = Constant.BANGBB_SYSTEM_CODE 
				+ System.currentTimeMillis()
				+ new Random(100).nextInt();
		
		try {
			CreditBaseBean creditBaseBean = TranceUtil.toBean(params, CreditBaseBean.class);
			creditBaseBean.setOpenNo(openNo);
			crecitProofMapper.insertCreditOpenHis(creditBaseBean);
		} catch (IllegalArgumentException e) {
			throw new BusinessException(WsErrConstant.ILLEGAL_ARGUMENT_EXCEPTION_CODE, 
					WsErrConstant.ILLEGAL_ARGUMENT_EXCEPTION_MSG,e);
		} catch (IllegalAccessException e) {
			throw new BusinessException(WsErrConstant.ILLEGAL_ACCESS_EXCEPTION_CODE, 
					WsErrConstant.ILLEGAL_ACCESS_EXCEPTION_MSG,e);
		} catch (InstantiationException e) {
			throw new BusinessException(WsErrConstant.INSTANTIATION_EXCEPTION_CODE, 
					WsErrConstant.INSTANTIATION_EXCEPTION_MSG,e);
		}
		
		return null;
	}

	@Override
	public Map<String, Object> queryCusOpenHis(Map<String, Object> params) {
		// 参数去空
		MapCheckUtil.mapTrim(params);
		// 参数校验
		MapCheckUtil.requiredCheck(Arrays.asList(OPEN_CRC_PARAM), params);
		return null;
	}

	@Override
	public Map<String, Object> resendEmail(Map<String, Object> params) {
		// 参数去空
		MapCheckUtil.mapTrim(params);
		// 参数校验
		MapCheckUtil.requiredCheck(Arrays.asList(OPEN_CRC_PARAM), params);
		return null;
	}

	@Override
	public Map<String, Object> queryCreditProofInfo(Map<String, Object> params) {
		// 参数去空
		MapCheckUtil.mapTrim(params);
		// 参数校验
		MapCheckUtil.requiredCheck(Arrays.asList(OPEN_CRC_PARAM), params);
		return null;
	}

}
