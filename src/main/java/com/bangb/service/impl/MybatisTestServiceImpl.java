package com.bangb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangb.mapper.MybatisTestMapper;
import com.bangb.service.MybatisTestService;
import com.bangb.user.bean.ClassDept;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MybatisTestServiceImpl implements MybatisTestService {
	
	@Autowired
	private MybatisTestMapper mapper;

	@Override
	public ClassDept queryAllClassDept() {
		ClassDept classDept = mapper.queryAllClassDept();
		if (classDept == null) {
			classDept = new ClassDept();
			log.info("query none ClassDept");
		}
		log.debug(">>>>>>>>queryAllClassDeptResult:{}<<<<<<<<",classDept.toString());
		
		return classDept;
	}

}
