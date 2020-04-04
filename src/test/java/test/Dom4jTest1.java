package test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bangb.common.exception.BusinessException;
import com.bangb.common.untils.TranceUtil;
import com.bangb.xml.bean.ReqUploadBean;
import com.bangb.xml.bean.ResourceBean;
import com.bangb.xml.bean.XMLBaseBean;

public class Dom4jTest1 {
	public static Logger log = Logger.getLogger(Dom4jTest1.class);

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, BusinessException {
		
		String xmlPath = "createReq.xml";
		Map<String, Object> reqParams = initQueryParams();
		reqParams.put("xmlPath", xmlPath);
		Map<String, Object> reqDownRstMap = UploadFileTest.uploadFile(reqParams);
	}
	
	public static Map<String, Object> initQueryParams() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, BusinessException {
		ReqUploadBean reqUploadBean = new ReqUploadBean();
		XMLBaseBean xmlBaseBean = new XMLBaseBean();
		Map<String, Object> xmlBaseMap = initBaseBean(xmlBaseBean);
		Map<String, Object> reqUploadMap = initReqUploadXmlBean(reqUploadBean);
		reqUploadMap.putAll(xmlBaseMap);
		return reqUploadMap;
	}

	/**
	 * 初始化请求公共参数
	 * @param xmlBaseBean
	 * @throws BusinessException 
	 */
	public static Map<String, Object>  initBaseBean(XMLBaseBean xmlBaseBean) throws BusinessException {
		xmlBaseBean.setRequesterId("000");
		xmlBaseBean.setResponderId("001");
		xmlBaseBean.setESBServiceId("002");
		xmlBaseBean.setMessageType("003");
		xmlBaseBean.setESBReqTimestamp("004");
		xmlBaseBean.setESBRspTimestamp("005");
		xmlBaseBean.setVersion("006");
		xmlBaseBean.setReservedHead("007");

		xmlBaseBean.setTradeCode("100");
		xmlBaseBean.setReqSerialNo("101");
		xmlBaseBean.setTradeDate("102");
		xmlBaseBean.setTradeTime("103");
		xmlBaseBean.setEnterpriseId("104");
		xmlBaseBean.setTradeChannel("105");
		xmlBaseBean.setSubBankNo("106");
		xmlBaseBean.setOrganNo("107");
		xmlBaseBean.setTellerNo("108");
		xmlBaseBean.setTermNo("109");
		xmlBaseBean.setForeTradeCode("110");
		xmlBaseBean.setTradeNote("111");
		xmlBaseBean.setAuthLevel("112");
		xmlBaseBean.setSupervisor1("113");
		xmlBaseBean.setSupervisor2("114");
		xmlBaseBean.setSupv1Password("115");
		xmlBaseBean.setSupv2Password("116");
		xmlBaseBean.setAuthReason("117");
		xmlBaseBean.setReservedBody("118");
		xmlBaseBean.setRequestLevel("119");
		xmlBaseBean.setTotalSize("120");
		xmlBaseBean.setEventId("121");
		xmlBaseBean.setEventType("122");
		Map<String, Object> params = TranceUtil.beanToMap(xmlBaseBean, xmlBaseBean.getClass());
		return params;
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
	private static Map<String, Object> initReqUploadXmlBean(ReqUploadBean xmlBean) throws BusinessException{
		xmlBean.setBatchIndex("123");
		xmlBean.setDocumentId("19910503");
		xmlBean.setDocumentType("pdf");
		xmlBean.setLocation("C:/temp/making/love");
		xmlBean.setBizType("loved");
		xmlBean.setCaseID("19911011");
		xmlBean.setDocumentIndex("0");
		xmlBean.setAttrType("0000000000");
		
		ResourceBean resourceBean = new ResourceBean();
		resourceBean.setResourceObjectName("遇见未知的自己");
		resourceBean.setResourceObjectFullName("/MyBooks/遇见未知的自己.txt");
		ResourceBean resourceBean1 = new ResourceBean();
		resourceBean1.setResourceObjectName("爱再来一次");
		resourceBean1.setResourceObjectFullName("/MyBooks/爱再来一次.txt");
		List<ResourceBean> resourceList = new ArrayList<>();
		resourceList.add(resourceBean);
		resourceList.add(resourceBean1);
		
		xmlBean.setResourceList(resourceList);
		Map<String, Object> params = TranceUtil.beanToMap(xmlBean, xmlBean.getClass());
		return params;
	}
	
	
}
