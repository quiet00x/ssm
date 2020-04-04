package test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.bangb.common.exception.BusinessException;
import com.bangb.common.untils.TranceUtil;

import test.bean.SupBean;
import test.bean.UserBean;

public class SubTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws BusinessException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		SupBean bean = new SupBean();
		bean.setId(1);
		bean.setName("hahhy");
		bean.setAge(21);
		bean.setGender('0');
		bean.setMerry(false);
		UserBean user = new UserBean();
		user.setUserName("slag");
		user.setAddress("湖北省新洲区");
		user.setAge("20");
		bean.setBean(user);
	
		System.out.println(bean);
		Map<String,Object> map1 = (Map<String, Object>) TranceUtil.objectToMap(bean);
		Map<String, Object> map = (Map<String, Object>) TranceUtil.beanToMap(bean,SupBean.class);
		Map<String, Object> params = TranceUtil.beanToMapPro(bean);
		System.out.println(JSON.toJSON(map1));
		System.out.println(JSON.toJSON(map));
		System.out.println(JSON.toJSON(params));
	}

}
