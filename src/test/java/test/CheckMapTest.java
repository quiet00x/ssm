package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.bangb.common.exception.BusinessException;
import com.bangb.common.untils.MapCheckUtil;
import com.bangb.user.bean.UserBean;

public class CheckMapTest {
	
	private static Logger log = Logger.getLogger(CheckMapTest.class);

	public static void main(String[] args) throws BusinessException{
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> requiredList = new ArrayList<String>();
		List<String> requiredListSub = new ArrayList<String>();
		checkParams(map, requiredList, requiredListSub);
		// map统一去空
		MapCheckUtil.mapTrim(map);
		
		for (Map.Entry<String,Object> m : map.entrySet()) {
			log.debug(m.getKey() + ":" + m.getValue());
		}
	}
	
	/**
	 * 必输参数统一校验
	 * @param map
	 * @param requiredList
	 * @param requiredListSub
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	private static void checkParams(Map<String, Object> map, List<String> requiredList, List<String> requiredListSub)
			throws BusinessException {
		// 初始化参数
		initParams(map);
		// 组装第一层必输参数列表
		initRequiredList(requiredList);
		// 组装第二层必输参数列表
		initRequiredListSub(requiredListSub);
		// 参数校验
		MapCheckUtil.requiredCheck(requiredList, map);
		MapCheckUtil.requiredCheck(requiredListSub, (Map<String,Object>)map.get("subMap1"));
	}
	
	/**
	 * 第一层map必输参数列表组装
	 * @param requiredList
	 */
	private static void initRequiredList(List<String> requiredList) {
		// 必输参数    
		requiredList.add("cusNo");
		requiredList.add("acctNo");
		requiredList.add("idType");
		requiredList.add("idNo");
	}
	
	/**
	 * 第一层map必输参数列表组装
	 * @param requiredList
	 */
	private static void initRequiredListSub(List<String> requiredList) {
		// 必输参数    
		requiredList.add("cusNo1");
		requiredList.add("acctNo1");
		requiredList.add("idType1");
		requiredList.add("idNo1");
	}

	// 初始化参数
	public static void initParams(Map<String,Object> map) {
		List<String> listStr = new ArrayList<String>();
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		Random random = new Random();
		UserBean userBean = new UserBean();
		UserBean userBean1 = new UserBean();
		
		Integer integer = 315;
		BigInteger bigInt = new BigInteger("128");
		Character character = 'c';
		Double db = 3.1415926; 
		userBean.setUserName("  hahhy    ");
		userBean.setAge(" 18   ");
		userBean.setId(1);
		
		// 给map赋值字符串
		for(int i = 1; i <= 2; i ++) {
			map.put(i + "", "  " + UUID.randomUUID().toString().substring(0, 5)+"   ");
		}
		
		for (int i = 0; i < 2; i++) {
			listStr.add("   " + random.nextInt(100)+"   ");
		}
		
		// 给map赋值空串字符串
		for (int i =3 ; i <=4; i++) {
			map.put(i + "", "    ");
		}
		
		// 给map赋值null
		for (int i =5 ; i <= 6 ; i++) {
			map.put(i + "", null);
		}
		
		// 给map赋值字符数组
		map.put("listStr", listStr);
		
		// 给map赋值Integer类型
		map.put("integer", integer);
		
		// 给map赋值Character类型
		map.put("character", character);
		
		// 给map赋值BigInteger类型
		map.put("bigInt", bigInt);
		
		// 给map赋值Double类型
		map.put("db", db);
		
		// map赋值引用类型
		map.put("bean", userBean);
		map.put("bean1", userBean1);
		// 给map赋值字符串
		map.put("cusNo", "130564789968");
		map.put("acctNo", "1236254789652");
		map.put("idType", "0102");
		map.put("idNo", "422365258986662515");
		
		Map<String, Object> subMap1 = new HashMap<String, Object>();
		Map<String, Object> subMap2 = new HashMap<String, Object>();
		subMap1.put("cusNo1", "  130564789968          ");
		subMap1.put("acctNo1", "  1236254789652       ");
		subMap1.put("idType1", "   0102    ");
		subMap1.put("idNo1", "   422365258986662515    ");
		// map中放map
		map.put("subMap1", subMap1);
		
		subMap2.put("cusNo2", "  130564789968          ");
		subMap2.put("acctNo2", "  1236254789652       ");
		subMap2.put("idType2", "   0102    ");
		subMap2.put("idNo2", "   422365258986662515    ");
		
		listMap.add(subMap1);
		listMap.add(subMap2);
		
		map.put("listMap", listMap);
		
	}
}
