package com.bangb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bangb.common.untils.TranceUtil;
import com.bangb.mapper.UserMapper;
import com.bangb.user.bean.UserBean;

@Service
public class UserService{
	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserMapper userMapper;

	public List<UserBean> queryUserList(UserBean userBean) {
		log.debug("userBean:{}",userBean.toString());
		return userMapper.queryUserForList(userBean);
	}

	@SuppressWarnings("unchecked")
	public Boolean saveUsers(List<UserBean> userList) {
		Map<String, Object> params = new HashMap<>();
		
		if (CollectionUtils.isEmpty(userList)) {
			List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
			
			UserBean bean = new UserBean();
			bean.setUserName("hahhy2");
			bean.setAddress("哪里来的");
			bean.setAge("18");
			bean.setEmailAddr("shenma@126.com");
			bean.setPassword("123");
			bean.setSex('1');
			Map<String, Object> map = (Map<String, Object>) TranceUtil.objectToMap(bean);
			
			listMap.add(map);
			
			UserBean bean2 = new UserBean();
			bean2.setUserName("sb2");
			bean2.setAddress("哪里来的");
			bean2.setAge("18");
			bean2.setEmailAddr("shenma@126.com");
			bean2.setPassword("123");
			bean2.setSex('1');
			map = (Map<String, Object>) TranceUtil.objectToMap(bean2);
			listMap.add(map);
			
			params.put("userList", listMap);
		} else {
			JSON json = (JSON) JSONObject.toJSON(userList);
			params.put("userList", JSON.toJavaObject(json, Map.class));
		}
		
		return userMapper.addUsers(params)>0;
		
	}
	
}
