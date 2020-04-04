package com.bangb.common.untils;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.bangb.common.constant.WsErrConstant;
import com.bangb.common.exception.BusinessException;

public class MyXMLUtils {
	/**
	 * 获取Document对象，加载XML文件
	 * @return
	 * @throws BusinessException 
	 * @throws DocumentException
	 */
	public static Document loadDocument(String fileName) throws BusinessException {
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(fileName);
		} catch (DocumentException e) {
			throw new BusinessException(WsErrConstant.XMLAbout.DOCUMENT_EXCEPTION_CODE, e.getMessage(),e);
		}
		return document;
	}
	
	/**
	 * 将document写出到指定文件
	 * @param document
	 * @param 输出文件
	 * @throws BusinessException 
	 */
	@SuppressWarnings("unused")
	private static void writeXmlFile(Document document,File file) throws BusinessException {
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(new File("demo.xml")),
			OutputFormat.createPrettyPrint());
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			throw new BusinessException(WsErrConstant.XMLAbout.DOCUMENT_EXCEPTION_CODE, e.getMessage(),e);
		}
	}
}
