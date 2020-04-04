package com.bangb.service;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bangb.common.exception.BusinessException;
import com.bangb.common.untils.SetVisitor;
import com.bangb.common.untils.TranceUtil;
import com.bangb.xml.bean.ReqUploadBean;

@Service
public class GetAndSetXMLService {
	private static Logger log = LoggerFactory.getLogger(GetAndSetXMLService.class);
	
	public void createSignAgree(Map<String, Object> map) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, BusinessException {
		String xmlPath = "createReq.xml";
		Document document = null;
		try {
			// 加载XML文件
			document = loadDocument(xmlPath);
		} catch (DocumentException e1) {
			log.error(e1.getMessage());
		}
		// 获取XML根节点
		Element root = document.getRootElement();
		SetVisitor visitor = new SetVisitor();
		ReqUploadBean xmlBean = new ReqUploadBean();
		// 初始化迭代参数Bean对象
		Map<String, Object> params = initXmlBean(xmlBean);
		visitor.setParams(params);
//		visitor.setReqUpBean(xmlBean);
		// 访客模式迭代遍历所有XML节点
		root.accept(visitor);
		writeXmlFile(document,new File("demo.xml"));
	}

	/**
	 * 初始化迭代参数
	 * @param xmlBean
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws BusinessException
	 */
	private static Map<String, Object> initXmlBean(ReqUploadBean xmlBean) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, BusinessException {
		Map<String, Object> params = new HashMap<String,Object>();
		xmlBean.setBatchIndex("123");
		
		xmlBean.setDocumentId("19910503");
		xmlBean.setDocumentType("pdf");
		xmlBean.setLocation("C:/temp/making/love");
		xmlBean.setBizType("loved");
		xmlBean.setCaseID("19911011");
		xmlBean.setDocumentIndex("0");
		xmlBean.setAttrType("0000000000");
		
		params = TranceUtil.beanToMap(xmlBean, xmlBean.getClass());
		return params;
	}


	/**
	 * 获取Document对象，加载XML文件
	 * @return
	 * @throws DocumentException
	 */
	public static Document loadDocument(String fileName) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(fileName);
		return document;
	}
	
	/**
	 * 将document写出到指定文件
	 * @param document
	 * @param 输出文件
	 */
	private static void writeXmlFile(Document document,File file) {
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(new File("demo.xml")),
			OutputFormat.createPrettyPrint());
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
