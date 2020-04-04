package com.bangb.service;

import java.util.Map;

public interface CreditProofService {

	public Map<String, Object> openCreditProof(Map<String, Object> map);

	public Map<String, Object> openTradeProof(Map<String, Object> map);

	public Map<String, Object> queryCusOpenHis(Map<String, Object> map);

	public Map<String, Object> resendEmail(Map<String, Object> map);

	public Map<String, Object> queryCreditProofInfo(Map<String, Object> map);

}
