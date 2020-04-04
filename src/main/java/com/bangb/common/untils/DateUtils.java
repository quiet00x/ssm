package com.bangb.common.untils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.bangb.common.constant.Constant;
import com.bangb.common.constant.WsErrConstant;
import com.bangb.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;


/**
 * 日期工具类
 * @author Preciousness
 */
@Slf4j
public class DateUtils {
	
	/**
	 * 日期转为String
	 * @param date
	 * @param formate
	 * @return
	 */
	public static String dateToString(Date date,String formate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		return  sdf.format(date);
	}
	
	/**
	 * String格式日期转换为Date
	 * @param date
	 * @param formate
	 * @return
	 * @throws BusinessException
	 */
	public static Date StringToDate(String dateStr,String formate) throws BusinessException {
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		Date dateD = null;
		try {
			dateD =  sdf.parse(dateStr);
		} catch (ParseException e) {
			log.error(e.getClass() + e.getMessage());
			throw new BusinessException(WsErrConstant.CLASS_CASE_EXCEPTION_CODE, e.getMessage(),e);
		}
		return dateD;
	}
	
	/**
	 * 获取制定日期前/后day天的日期
	 * @param dateStr
	 * @param day
	 * @return
	 * @throws BusinessException 
	 */
	public static String getBeforeDate(String dateStr, int day, String oprType) throws BusinessException {
		String preDate = null;
		Date date = null;
		Calendar c = Calendar.getInstance();
		try {
			date = StringToDate(dateStr, "yyyyMMdd");
			c.setTime(date);
			log.debug(c.getTime()+"");
			if (oprType.equals(Constant.DATE_OF_DAY)) {
				c.add(Calendar.DATE, day);
			} else if(oprType.equals(Constant.DATE_OF_WEEK)) {
				c.add(Calendar.WEEK_OF_YEAR, day);
			} else if(oprType.equals(Constant.DATE_OF_MONTH)) {
				c.add(Calendar.MONTH, day);
			}else if(oprType.equals(Constant.DATE_OF_YEAR)) {
				c.add(Calendar.YEAR, day);
			}
			preDate = dateToString(c.getTime(),"yyyyMMdd");
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(WsErrConstant.REQ_PARAMS_ERROR_MSG,e.getMessage());
		}
		return preDate;
	}
}
