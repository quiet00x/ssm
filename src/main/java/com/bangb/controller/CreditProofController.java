package com.bangb.controller;

import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangb.service.CreditProofService;

@RequestMapping("credit/")
@Controller
public class CreditProofController {
	
	@Autowired
	private CreditProofService creditProofImpl;
	
	@RequestMapping("openCreditProof.action")
	@ResponseBody
	@JsonView
	public Map<String, Object> openCreditProof(Map<String, Object> params){
		
		Map<String, Object> httpResult = creditProofImpl.openCreditProof(params);
		return httpResult;
	}
	
	@RequestMapping("openTradeProof.action")
	@ResponseBody
	@JsonView
	public Map<String, Object> openTradeProof(Map<String, Object> params){
		Map<String, Object> httpResult = creditProofImpl.openTradeProof(params);
		return httpResult;
	}
	
	
	@RequestMapping("queryCusOpenHis.action")
	@ResponseBody
	@JsonView
	public Map<String, Object> queryCusOpenHis(Map<String, Object> params){
		Map<String, Object> httpResult = creditProofImpl.queryCusOpenHis(params);
		return httpResult;
	}
	
	@RequestMapping("resendEmail.action")
	@ResponseBody
	@JsonView
	public Map<String, Object> resendEmail(Map<String, Object> params){
		Map<String, Object> httpResult = creditProofImpl.resendEmail(params);
		return httpResult;
	}
	
	
	@RequestMapping("queryCreditProofInfo.action")
	@ResponseBody
	@JsonView
	public Map<String, Object> queryCreditProofInfo(Map<String, Object> params){
		Map<String, Object> httpResult = creditProofImpl.queryCreditProofInfo(params);
		return httpResult;
	}

}
