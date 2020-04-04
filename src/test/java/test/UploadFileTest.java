package test;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bangb.common.untils.MyXMLUtils;
import com.bangb.common.untils.SetVisitor;

public class UploadFileTest {
	public static Logger log = LoggerFactory.getLogger(UploadFileTest.class);
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> uploadFile(Map<String, Object> params) {
		String xmlPath = (String)params.get("xmlPath");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Document document = null;
		Element root = null;
		SetVisitor visitor = new SetVisitor();
		Map<String, Object>  reqUploadMap = null;
		try {
			// 加载XML文件
			document = MyXMLUtils.loadDocument(xmlPath);
			// 获取XML根节点
			root = document.getRootElement();
			// 初始化迭代参数Bean对象
			reqUploadMap =  (Map<String, Object>) params.get("reqUploadMap");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		visitor.setParams(reqUploadMap);
//		visitor.setReqUpBean(xmlBean);
		// 访客模式迭代遍历所有XML节点
		root.accept(visitor);
		System.out.println(document.asXML());
		return resultMap;
	}
}
