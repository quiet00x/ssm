package com.bangb.common.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BusinessException(String errorCode) {
		log.error(errorCode);
	}
	
	public BusinessException(String errorCode,String message) {
		super(errorCode);
		log.error(errorCode + ":" + message);
	}
	
	public BusinessException(String errorCode,String message,Throwable e) {
		super(errorCode,e);
		log.error("errCode:" + errorCode + "_message:" + message,e);
	}
}
