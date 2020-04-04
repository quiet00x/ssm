package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.bangb.functionalinterface.SumDemo;

public class LambdaTest {
	
	private static Map<String, SumDemo> map = new HashMap<String, SumDemo>();

    public static void main(String[] args) {
    	
    	initLambda(map);
    	
        String value = "testA";
        int param = 2;
        int lambdaResult = lambdaSum(value,param);

        System.out.println("lamdaResult : " + lambdaResult);

        int ifResult = ifResult(value,param);
        System.out.println("ifResult : " + ifResult);
        
        List<String> list = Arrays.asList(new String[] {"b","a","c"});
        sortCollection(list);
        System.out.println(list);
        
        
       System.out.println(changeResult(15, x -> x+1));
        
   
    }

    // 2. 处理参数初始化
    public static void initLambda(Map<String,SumDemo> map) {
        /*
         *  map.put("testA",param -> param + 1);
         *  等同于以下方式 lambda 表达式中的param 
         *  即是抽象方法的形参 param + 1 则是抽象方法的实现 
         */
        map.put("testA", new SumDemo() {
			@Override
			public int sum(int x) {
				return x + 1;
			}
        	
        });
        map.put("testB",param -> param + 2);
        map.put("testC",param -> param + 3);
     }
     
     // 根据不同的条件，执行对应匿名方法
     private static int lambdaSum(String value, int param) {
    	 /*
    	  * 这个地方需要注意
    	  * 实际上是  通过创建接口的匿名对象
    	  * 调用抽象方法的实现
    	  * 具体的实现即是 lambda所表示的匿名函数 
    	  */
         return map.get(value).sum(param);
    }

     /**
      * 原始逻辑，根据不同的条件 执行不同的计算逻辑
      * @param value
      * @param param
      * @return
      */
    private static int ifResult(String value, int param) {
        if(StringUtils.equals(value, "testA")){
            return param + 1;
        }else if (StringUtils.equals(value, "testB")){
            return param + 2;
        }else if (StringUtils.equals(value, "testC")) {
            return param + 3;
        }else {
            return 0;
        }
    }
    
    private static List<String> sortCollection(List<String> list) {
    	
    	Collections.sort(list,(str1,str2) -> str1.compareTo(str2));
    	
    	// 等同于以下方式
    	Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
    	return list;
    }
    
    private static int changeResult(int i, SumDemo sumDemo) {
    	return sumDemo.sum(i);
    }
}
