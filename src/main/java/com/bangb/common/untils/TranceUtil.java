package com.bangb.common.untils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.bangb.common.constant.WsErrConstant;
import com.bangb.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TranceUtil {
	
	/**
	* 百度的：将bean转化为另一种bean实体
	* @param object
	* @param entityClass
	* @return
	*/
	public static <T> T convertBean(Object object, Class<T> entityClass) {
	if(null == object) {
	return null;
	}
	return JSON.parseObject(JSON.toJSONString(object), entityClass);
	}


	/**
	* 方法说明：对象转换
	* 
	* @param source	原对象
	* @param target	目标对象
	* @param ignoreProperties	排除要copy的属性
	* @return
	 * @throws BusinessException 
	*/
	public static <T> T copy(Object source, Class<T> target, String...ignoreProperties) {
		T targetInstance = null;
		try {
			targetInstance = target.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new BusinessException(WsErrConstant.INSTANTIATION_EXCEPTION_CODE
					,WsErrConstant.INSTANTIATION_EXCEPTION_MSG,e);
		}
		if(ArrayUtils.isEmpty(ignoreProperties)) {
			BeanUtils.copyProperties(source, targetInstance);
		} else {
			BeanUtils.copyProperties(source, targetInstance, ignoreProperties);
		}
		return targetInstance;
	}

	/**
	* 百度的对象转换(List)
	* 
	* @param list	原对象
	* @param target	目标对象
	* @param ignoreProperties	排除要copy的属性
	* @return
	*/
	public static <T, E> List<T> copyList(List<E> list, Class<T> target, String...ignoreProperties){
		List<T> targetList = new ArrayList<>();
		if(CollectionUtils.isEmpty(list)) {
			return targetList;
		}
		for(E e : list) {
			targetList.add(copy(e, target, ignoreProperties));
		}
		return targetList;
	}

	/**
	* 百度的map转化为对象
	* 
	* @param map
	* @param t
	* @return
	* @throws InstantiationException
	* @throws IllegalAccessException
	* @throws InvocationTargetException
	*/
	public static <T> T mapToObject(Map<String, Object> map, Class<T> t) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		T instance = t.newInstance();
		org.apache.commons.beanutils.BeanUtils.populate(instance, map);
		return instance;
	}

	/**
	* 百度的对象转化为Map
	* 
	* @param object
	* @return
	*/
	public static Map<?, ?> objectToMap(Object object){
		return convertBean(object, Map.class);
	}
	
	/**
	 * 自己写的利用反射将bean转map
	 * @param clz
	 * @return
	 * @throws BusinessException
	 */
	public static Map<String, Object> beanToMap(Object obj, Class<?> clz) throws BusinessException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (clz == null || obj == null) {
			throw new BusinessException("参数异常");
		}
		// 获取父类字节码
		Class<?> supClz = clz.getSuperclass();
		// 获取子类属性数组
		Field[] fields = clz.getDeclaredFields();
		// 获取父类属性数组
		Field[] supFields = {};
		if (!supClz.equals(Object.class)) {
			supFields = supClz.getDeclaredFields();
		}
		
		Field[] descFields = new Field[fields.length+supFields.length];
		List<Field[]> fieldList = new ArrayList<Field[]>();
		fieldList.add(supFields);
		fieldList.add(fields);
		
		// 合并父类和子类数组
		descFields = mergeArray(descFields,fieldList);
		// 遍历数组转行为Map
		resultMap = forEachFields(obj,clz, descFields);
		return resultMap;
	}

	/**
	 * 合并数组
	 * @param fields
	 * @param supFields
	 * @param supFields2 
	 */
	public static Field[] mergeArray(Field[] descFields, List<Field[]> fieldList) {
		int descLength = 0;
		for (Field[] f : fieldList) {
			System.arraycopy(f, 0, descFields, descLength, f.length);
			descLength += f.length;
		}
		return descFields;
	}

	/**
	 * 遍历数组获取属性信息
	 * @param clz
	 * @param fields
	 * @throws BusinessException
	 */
	private static Map<String, Object> forEachFields(Object obj,Class<?> clz, Field[] fields) throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
		for (Field field : fields) {
			if (field!=null) {
				field.setAccessible(true);
				try {
					String fieldName = field.getName();
					Object fieldValue = field.get(obj);
					map.put(fieldName, fieldValue);
				} catch (Exception e) {
					throw new BusinessException(e.getMessage());
				}
			}
		}
		return map;
	}
	
	/**
	 * 自己写的利用Java内省
	 * PropertyDescriptor属性和PropertyUtils
	 * 获取属性名称
	 * 还可以获取属性的get方法并执行。
	 * 问题是获取的属性名符合驼峰命名法
	 * @param clz
	 * @return
	 * @throws BusinessException
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static Map<String, Object> beanToMapPro(Object obj) throws BusinessException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (obj == null) {
			throw new BusinessException("参数异常");
		}
		// 获取子类属性的get方法
		PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(obj);
		for (PropertyDescriptor pd : pds) {
			// 获取get方法
			PropertyUtils.getReadMethod(pd);
			// 获取set方法
			PropertyUtils.getWriteMethod(pd);
			
			if (pd!=null && !pd.getName().equals("class")) {
				resultMap.put(pd.getName(), PropertyUtils.getProperty(obj, pd.getName()));
			}
		}
		return resultMap;
	}
	
	/**
	 * 自己写的map转为Bean对象 只支持基本类型
	 * @param params 
	 * @param clz
	 * @return Bean对象
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toBean(Map<String, Object> params,Class<?> clz) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		if (MapUtils.isEmpty(params) || clz==null) {
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
