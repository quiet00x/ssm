package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bangb.common.exception.BusinessException;
import com.bangb.common.untils.DateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerTest {

	private static Logger logger = LoggerFactory.getLogger(FreeMarkerTest.class);
	
	public static void main(String[] args) throws BusinessException {
		//Configuration cfg = new Configuration("配置文件路径");
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
		try {
			String templateDir = "D:" 
					+ File.separator + "temp" 
					+ File.separator + "freemarker" 
					+ File.separator + "templates";
			File dirFile = new File(templateDir);
			dirFile.mkdirs();
			cfg.setDirectoryForTemplateLoading(dirFile);
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			Template temp = cfg.getTemplate("word.ftl");
			Writer out = new FileWriter(new File(templateDir + File.separator + "test.doc"));
			Map<String, Object> root = initParams();
			temp.process(root, out);
			out.close();
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		} catch (TemplateException e) {
			logger.error(e.getMessage(),e);
		} 
	}
	
	private static Map<String,Object> initParams() throws BusinessException{
		Map<String, Object> root = new HashMap<>();
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		Map<String, Object> t1 = new HashMap<String, Object>();
		t1.put("cqCode", "Bocom1234567");
		t1.put("cqName", "银企对账优化需求");
		t1.put("systemName", "银企对账系统");
		t1.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t1);
		
		Map<String, Object> t2 = new HashMap<String, Object>();
		t2.put("cqCode", "Bocom5201314");
		t2.put("cqName", "回单批量打印需求");
		t2.put("systemName", "回单合成系统");
		t2.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t2);
		
		Map<String, Object> t3 = new HashMap<String, Object>();
		t3.put("cqCode", "Bocom1234567");
		t3.put("cqName", "银企对账优化需求");
		t3.put("systemName", "银企对账系统");
		t3.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t3);
		
		Map<String, Object> t4 = new HashMap<String, Object>();
		t4.put("cqCode", "Bocom5201314");
		t4.put("cqName", "回单批量打印需求");
		t4.put("systemName", "回单合成系统");
		t4.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t4);
		
		Map<String, Object> t5 = new HashMap<String, Object>();
		t5.put("cqCode", "Bocom1234567");
		t5.put("cqName", "银企对账优化需求");
		t5.put("systemName", "银企对账系统");
		t5.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t5);
		
		Map<String, Object> t6 = new HashMap<String, Object>();
		t6.put("cqCode", "Bocom5201314");
		t6.put("cqName", "回单批量打印需求");
		t6.put("systemName", "回单合成系统");
		t6.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t6);
		
		Map<String, Object> t7 = new HashMap<String, Object>();
		t7.put("cqCode", "Bocom1234567");
		t7.put("cqName", "银企对账优化需求");
		t7.put("systemName", "银企对账系统");
		t7.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t7);
		
		Map<String, Object> t8 = new HashMap<String, Object>();
		t8.put("cqCode", "Bocom5201314");
		t8.put("cqName", "回单批量打印需求");
		t8.put("systemName", "回单合成系统");
		t8.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t8);

		Map<String, Object> t9 = new HashMap<String, Object>();
		t9.put("cqCode", "Bocom1234567");
		t9.put("cqName", "银企对账优化需求");
		t9.put("systemName", "银企对账系统");
		t9.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t9);
		
		Map<String, Object> t10 = new HashMap<String, Object>();
		t10.put("cqCode", "Bocom5201314");
		t10.put("cqName", "回单批量打印需求");
		t10.put("systemName", "回单合成系统");
		t10.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t10);

		Map<String, Object> t11 = new HashMap<String, Object>();
		t11.put("cqCode", "Bocom1234567");
		t11.put("cqName", "银企对账优化需求");
		t11.put("systemName", "银企对账系统");
		t11.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t11);
		
		Map<String, Object> t12 = new HashMap<String, Object>();
		t12.put("cqCode", "Bocom5201314");
		t12.put("cqName", "回单批量打印需求");
		t12.put("systemName", "回单合成系统");
		t12.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t12);

		Map<String, Object> t13 = new HashMap<String, Object>();
		t13.put("cqCode", "Bocom1234567");
		t13.put("cqName", "银企对账优化需求");
		t13.put("systemName", "银企对账系统");
		t13.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t13);
		
		Map<String, Object> t14 = new HashMap<String, Object>();
		t14.put("cqCode", "Bocom5201314");
		t14.put("cqName", "回单批量打印需求");
		t14.put("systemName", "回单合成系统");
		t14.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t14);
		
		Map<String, Object> t15 = new HashMap<String, Object>();
		t15.put("cqCode", "Bocom1234567");
		t15.put("cqName", "银企对账优化需求");
		t15.put("systemName", "银企对账系统");
		t15.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t15);
		
		Map<String, Object> t16 = new HashMap<String, Object>();
		t16.put("cqCode", "Bocom5201314");
		t16.put("cqName", "回单批量打印需求");
		t16.put("systemName", "回单合成系统");
		t16.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t16);
		
		Map<String, Object> t17 = new HashMap<String, Object>();
		t17.put("cqCode", "Bocom1234567");
		t17.put("cqName", "银企对账优化需求");
		t17.put("systemName", "银企对账系统");
		t17.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t17);
		
		Map<String, Object> t18 = new HashMap<String, Object>();
		t18.put("cqCode", "Bocom5201314");
		t18.put("cqName", "回单批量打印需求");
		t18.put("systemName", "回单合成系统");
		t18.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t18);
		root.put("cqList", listMap);
		
		Map<String, Object> t19 = new HashMap<String, Object>();
		t19.put("cqCode", "Bocom1234567");
		t19.put("cqName", "银企对账优化需求");
		t19.put("systemName", "银企对账系统");
		t19.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t19);
		
		Map<String, Object> t20 = new HashMap<String, Object>();
		t20.put("cqCode", "Bocom5201314");
		t20.put("cqName", "回单批量打印需求");
		t20.put("systemName", "回单合成系统");
		t20.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t20);
		root.put("cqList", listMap);
		
		Map<String, Object> t21 = new HashMap<String, Object>();
		t21.put("cqCode", "Bocom1234567");
		t21.put("cqName", "银企对账优化需求");
		t21.put("systemName", "银企对账系统");
		t21.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t21);
		
		Map<String, Object> t22 = new HashMap<String, Object>();
		t22.put("cqCode", "Bocom5201314");
		t22.put("cqName", "回单批量打印需求");
		t22.put("systemName", "回单合成系统");
		t22.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t22);
		
		Map<String, Object> t23 = new HashMap<String, Object>();
		t23.put("cqCode", "Bocom5201314");
		t23.put("cqName", "回单批量打印需求");
		t23.put("systemName", "回单合成系统");
		t23.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t23);
		
		Map<String, Object> t24 = new HashMap<String, Object>();
		t24.put("cqCode", "Bocom5201314");
		t24.put("cqName", "回单批量打印需求");
		t24.put("systemName", "回单合成系统");
		t24.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t23);
		
		Map<String, Object> t25 = new HashMap<String, Object>();
		t25.put("cqCode", "Bocom5201314");
		t25.put("cqName", "回单批量打印需求");
		t25.put("systemName", "回单合成系统");
		t25.put("prdDate", DateUtils.StringToDate("20190906", "yyyyMMdd"));
		listMap.add(t25);
		
		
		root.put("cqList", listMap);
		return root;
	}

}
