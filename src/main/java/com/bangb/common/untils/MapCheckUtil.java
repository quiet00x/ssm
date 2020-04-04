package com.bangb.common.untils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.bangb.common.constant.WsErrConstant;
import com.bangb.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class MapCheckUtil {
	/**
	 * map统一去空
	 * @param params
	 * @throws BusinessException 
	 */
	@SuppressWarnings("unchecked")
	public static void mapTrim(Map<String,Object> params) throws BusinessException {
		if (MapUtils.isEmpty(params)) {
			log.error(WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_CODE,"请求参数为空!");
			throw new BusinessException(WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_CODE,"请求参数为空!");
		}
		
		for (Map.Entry<String, Object> entry: params.entrySet()) {
			
			Object value = entry.getValue();
			// 除了null都需要进行处理  如果是空串也需要给变成null
			if (value != null) {
				if (value instanceof String) {
					value = (value!=null && !"".equals(value.toString().trim())) ?value.toString().trim():null;
					entry.setValue(value);
				}
				// 此处有个bug list中如果是map会抛类型转换异常
				if (value instanceof List<?>) {
					List<Map<String,Object>> tempList = new ArrayList<Map<String,Object>>();
					for (Object obj : (List<?>)value) {
						if (obj instanceof Map<?, ?>) {
							mapTrim((Map<String, Object>) obj);
							tempList.add((Map<String,Object>)obj);
						} 
					}
					entry.setValue(tempList);
				}
				if (value instanceof Map<?,?>) {
					// 递归去空
					mapTrim((Map<String, Object>) value);
				}
			}
		}
	}
	
	/**
	 * 必输参数校验 -但是需要每层分开校验
	 * @param list
	 * @param params
	 * @throws BusinessException 
	 */
	public static void requiredCheck(List<String> requiredList, Map<String,Object> params) throws BusinessException {
		if (params == null || params.size() ==0) {
			throw new BusinessException("请求参数为空！");
		}
		if (CollectionUtils.isEmpty(requiredList)) {
			throw new BusinessException("必输参数未装配！");
		}
		for (String str : requiredList) {
			Object value = (String) params.get(str);
			if (value instanceof String) {
				if(StringUtils.isBlank((String)value)) {
					throw new BusinessException("缺少必输参数:" + str);
				}
			} else {
				if(value == null) {
					throw new BusinessException("缺少必输参数:" + str);
				}
			}
			
		}
	}
	
}
