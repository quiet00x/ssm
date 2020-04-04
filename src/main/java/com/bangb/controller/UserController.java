package com.bangb.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bangb.annotation.TrackerAnnotation;
import com.bangb.common.constant.Constant;
import com.bangb.common.exception.BusinessException;
import com.bangb.service.BeanFactoryInstance;
import com.bangb.service.UserService;
import com.bangb.user.bean.UserBean;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	private static Logger log = Logger.getLogger(UserController.class);
	
	@TrackerAnnotation()
	@RequestMapping("queryUserList.action")
	@ResponseBody
	public String queryUserList(UserBean userBean) throws BusinessException {
		log.debug(">>>>>>>>>>>>>>>>>>>>>spring is starting <<<<<<<<<<<<<<<<<<<<<");
		
		List<UserBean> userList = userService.queryUserList(userBean);
		
		if (!CollectionUtils.isEmpty(userList)) {
			throw new BusinessException(Constant.RSP_ERROR_CODE,"测试异常！");
		}
		JSON json = (JSON) JSONObject.toJSON(userList);
		String jsonStr = json.toJSONString();
		
		return jsonStr;
	}
	
	
	@RequestMapping("insertUsers.action")
	@ResponseBody
	public String saveUser() {
		log.debug(">>>>>>>>>>>>>>>>>>>>>spring is starting <<<<<<<<<<<<<<<<<<<<<");
		
		userService.saveUsers(null);
		
		return "OK";
	}
	
	@RequestMapping("user.action")
	@ResponseBody
	@JsonView(UserBean.UserDetailView.class)
	public UserBean queryUserInfo(UserBean userBean) {
		log.debug(">>>>>>>>>>>>>>>>>>>>>spring is starting <<<<<<<<<<<<<<<<<<<<<");
		
		UserBean user = new UserBean();
		user.setId(1);
		user.setUserName("hahhy");
		user.setPassword("101456");
		
		return user;
	}
	
	@RequestMapping("factory.action")
	public String beanFactory(Model model) {
		BeanFactoryInstance ins = new BeanFactoryInstance();
		return ins.getBeanInstanle().toString();
	}
	
}
