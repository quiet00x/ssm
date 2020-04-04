package test;

import java.util.HashMap;
import java.util.Map;

public class MapPutAllTest {
	
	public static void main(String[] args) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		for(int i = 1;i<3;i++) {
			map1.put(i+"", i);
		}
		for(int i = 3;i<5;i++) {
			map2.put(i+"", i);
		}
		map1.putAll(map2);
		for (Map.Entry<String, Object> entry : map1.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
	