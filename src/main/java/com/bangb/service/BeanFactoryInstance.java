package com.bangb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import com.bangb.user.bean.ClassDept;

public class BeanFactoryInstance implements BeanFactoryAware {
	
	private static BeanFactory factory;
	private static Logger logger = LoggerFactory.getLogger(BeanFactoryInstance.class);
	private static String woc = null; 
	
	@Override
	public void setBeanFactory(BeanFactory as) throws BeansException {
			logger.debug("**************************************************");
			woc = "hahhy";
			factory = as;
	}
	
	public Object getBeanInstanle() {
		return factory.getBean(ClassDept.class);
	}
	
	
}
