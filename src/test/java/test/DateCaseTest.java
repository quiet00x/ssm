package test;

import com.bangb.common.exception.BusinessException;
import com.bangb.common.untils.DateUtils;

public class DateCaseTest {
	public static void main(String[] args) throws BusinessException {
		String dateStr = "20190515";
		int day = -1;
		String preDate = DateUtils.getBeforeDate(dateStr, day, "year");
		System.out.println(preDate);
	}
}
