package com.bangb.bean;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonView;

import com.bangb.common.view.SimpleView;

import lombok.Data;

@Data
public class HttpResult<T> {

	public static final String SUCCESS_CODE = "0";

	@JsonView(SimpleView.class)
	private String code;

	@JsonView(SimpleView.class)
	private String msg;

	@JsonView(SimpleView.class)
	private T data;

	@JsonView(SimpleView.class)
	private List<T> list;

	public static <T> HttpResult<T> success() {
		HttpResult<T> result = new HttpResult<>();
		result.setCode(SUCCESS_CODE);
		return result;
	}

	public static <T> HttpResult<T> success(T data) {
		return new HttpResult<T>(SUCCESS_CODE, null, data);
	}

	public static <T> HttpResult<T> success(List<T> list) {
		return new HttpResult<T>(SUCCESS_CODE, null, list);
	}

//	public static <T> HttpResult<T> success(Object data, Class<T> targetClass) {
//		HttpResult<T> result = success();
//		if (data instanceof List) {
//			result.setList(MapperUtils.copyProperties((List<?>) data, targetClass));
//		} else if (data instanceof Map) {
//			result.setData(MapperUtils.copyProperties((Map<?, ?>) data, targetClass));
//		} else {
//			result.setData(MapperUtils.copyProperties(data, targetClass));
//		}
//		return result;
//	}

//	public static <T> HttpResult<T> fail(ErrorCode errorCode, String... args) {
//		HttpResult<T> httpResult = new HttpResult<>();
//		httpResult.setCode(errorCode.value());
//		httpResult.setMsg(MessageUtils.getMessage(errorCode.value(), args));
//		return httpResult;
//	}

	public static <T> HttpResult<T> fail(String errorCode, String msg) {
		HttpResult<T> httpResult = new HttpResult<>();
		httpResult.setCode(errorCode);
		httpResult.setMsg(msg);
		return httpResult;
	}

	public HttpResult() {

	}

	public HttpResult(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public HttpResult(String code, String msg, List<T> list) {
	        this.code = code;
	        this.msg = msg;
	        this.list = list;
	    }
}
