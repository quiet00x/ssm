package com.bangb.common.untils;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Element;
import org.dom4j.VisitorSupport;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class GetVisitor extends VisitorSupport{
	// 封装需要遍历获取的节点名称
	private Map<String, Object> params = new HashMap<String, Object>();
	// 封装结果集
	private Map<String,Object> nodeMap = new HashMap<String, Object>();
	
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
	

	@Override
	public void visit(Element node) {
		if (node == null) {
			log.error("该节点为空！");
			return;
		}
		// 获取指定的节点信息
		if (params!=null && params.size()>0) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				String key = entry.getKey();
				if (key.equals(node.getName())) {
					nodeMap.put(key, node.getTextTrim());
				}
			}
		} else {// 获取所有节点信息
			String nodeName = node.getName();
			String nodeText = node.getTextTrim();
			nodeMap.put(nodeName, nodeText);
		}
	}

}
