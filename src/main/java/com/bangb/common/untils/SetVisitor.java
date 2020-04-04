package com.bangb.common.untils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.dom4j.VisitorSupport;

import com.bangb.xml.bean.ReqDownloadBean;
import com.bangb.xml.bean.ResourceBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SetVisitor extends VisitorSupport{
	
	// 封装需要遍历获取的节点名称
	private Map<String, Object> params = new HashMap<String, Object>();
	// 封装结果集
	private Map<String,Object> nodeMap = new HashMap<String, Object>();
	// 和params二选一使用
	private ReqDownloadBean reqDownBean;
	
	
	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Map<String, Object> getNodeMap() {
		return nodeMap;
	}

	public void setNodeMap(Map<String, Object> nodeMap) {
		this.nodeMap = nodeMap;
	}

	public ReqDownloadBean getReqDownBean() {
		return reqDownBean;
	}

	public void setReqDownBean(ReqDownloadBean reqDownBean) {
		this.reqDownBean = reqDownBean;
	}


	@Override
	public void visit(Element node) {
		if (node == null) {
			log.error("该节点为空！");
			return;
		}
		if (params!=null && params.size()>0) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				if (value instanceof String 
						&& key.equals(node.getName())&& value!=null) {
					// value 为 null setText方法会抛异常
					node.setText((String)value);
					node.clone();
				}
				if (value instanceof List<?>) {
					System.out.println(node);
					if(node.getName().equals("ResourceObjectList")) {
						@SuppressWarnings("unchecked")
						List<ResourceBean> list = (List<ResourceBean>) params.get("resourceList"); 
						for(int i=0; i<list.size();i++) {
							if(node.getTextTrim()==null || node.getTextTrim().equals("")) {
								
							}
						}
					}
				}
			}
		}
		if (reqDownBean!=null) {
			setNodeByBean(node,reqDownBean);
		}
	}

	public void setNodeByBean(Element node,Object obj) {
		log.debug(">>>>>>>>>>>obj:{}<<<<<<<<<<<",obj);
		Class<?> clz = obj.getClass();
		Class<?> clzSup = clz.getSuperclass();
		Field[] fields = clz.getDeclaredFields();
		Field[] supFields = clzSup.getDeclaredFields();
		Field[] descFields = new Field[fields.length+supFields.length];
		List<Field[]> fieldList = new ArrayList<Field[]>();
		fieldList.add(fields);
		fieldList.add(supFields);
		descFields = TranceUtil.mergeArray(descFields, fieldList);
		forEachBean(node, descFields,obj);
	}

	private void forEachBean(Element node, Field[] fields,Object obj) {
		for (Field field : fields) {
			if (field != null) {
				field.setAccessible(true);
				String fieldName = field.getName();
				Object fieldValue = null;
				try {
					fieldValue = field.get(obj);
				} catch (IllegalArgumentException e) {
					log.error(e.getMessage());
				} catch (IllegalAccessException e) {
					log.error(e.getMessage());
				}
				if (field.getType().equals(String.class) && fieldValue != null) {
					if (fieldName.equals(node.getName())) {
						log.debug(fieldName + ":" + fieldValue);
						node.setText((String) fieldValue);
					}
				}
			}
		}
	}

}
