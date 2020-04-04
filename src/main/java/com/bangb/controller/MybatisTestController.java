package com.bangb.controller;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.annotate.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangb.common.view.SimpleView;
import com.bangb.service.MybatisTestService;
import com.bangb.user.bean.ClassDept;


@Controller
public class MybatisTestController {
	
	private static Logger log = LoggerFactory.getLogger(MybatisTestController.class);
	
	@Autowired
	private MybatisTestService testService;
	
	
	@RequestMapping(value="queryClassList.action",method=RequestMethod.GET)
	@JsonView(SimpleView.class)
	@ResponseBody
	public String queryStudent(HttpServletRequest request) {
		log.debug(">>>>>>>>>>>>>>>>>>>>>  spring is starting  <<<<<<<<<<<<<<<<<<<<<");
		
		ClassDept classDept = null;
		try {
			classDept = testService.queryAllClassDept();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return classDept.toString();
	}
	
//	@RequestMapping(value="queryClassList.action",method=RequestMethod.GET)
//	@ResponseBody
//	public String queryStudent(Model model) {
//		log.debug(">>>>>>>>>>>>>>>>>>>>> spring is starting  <<<<<<<<<<<<<<<<<<<<<");
//		
//		ClassDept classList = testService.queryClassList();
//		
//		JSON json = (JSON) JSONObject.toJSON(classList);
//		
//		return json.toJSONString();
//	}

}
