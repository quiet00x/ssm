package test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import test.bean.SupBean;

public class MapToBeanTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", "12");
		params.put("name", null);
		params.put("age", 12);
		params.put("merry",false);
		
		SupBean bean = toBean(params, SupBean.class);
		System.out.println(bean);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T toBean(Map<String, Object> params,Class<?> clz) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		if (params==null || params.size()==0 || clz==null) {
			return null;
		}
		T t = (T) clz.newInstance();
		Field[] fields = clz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = params.get(field.getName());
			Class<?> type = field.getType();
			if (params.containsKey(field.getName()) && value!=null && type.equals(value.getClass())) {
				field.set(t, value);
			}
		}
		return t;
	}

}
