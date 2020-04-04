package com.bangb.aop;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bangb.common.exception.BusinessException;

@Aspect //该注解标示该类为切面类 
@Component //注入依赖
public class TrackAspect {
	private static Logger logger = LoggerFactory.getLogger(TrackAspect.class);
	
	private final String PARAMS_NAME = "userName";
	
	/**
	 * 定义切入点
	 * 方法上带有自定义注解@TrackerAnnotation的方法才会切入
	 * 切入顺序
	 * 有异常时：环绕通知增强方法->前置通知->环绕通知连接点->目标方法->（环绕通知异常处理）->后置通知->异常通知
	 * 无异常时：环绕通知增强方法->前置通知->环绕通知连接点->目标方法->环绕通知后续方法->后置通知->后置返回通知
	 */
	@Pointcut("@annotation(com.bangb.annotation.TrackerAnnotation)")
	public void advice() {
		
	}
	
	/**
	 * 前置通知
	 * 在连接点前面执行，如果连接点前有增强方法，会先执行增强方法，直到连接点，再去执行前置通知
	 * 前置通知不会影响连接点的执行，除非此处抛出异常。
	 * @param jp
	 */
	@Before("advice()")
	public void beforeAdvice(JoinPoint jp) {
		logger.debug("***************************** beforeAdvice is running *****************************");
		
		Object ret = getSignature(jp);
		
		logger.debug(">>>>>>>>>>>>>>>>>>>>>ret:{}<<<<<<<<<<<<<<<<<<<",ret);
		
		logger.debug("***************************** beforeAdvice is over *****************************");
	}
	
	
	/**
	 * 后置返回通知
	 * 在连接点正常执行完成后执行，如果连接点抛出异常，则不会执行。
     * 可以获取到环绕通知的返回值
	 * @param jp
	 */
	@AfterReturning(returning="jsonStr",pointcut="advice()")
	public void afterReturnAdvice(JoinPoint jp,Object jsonStr) {
		logger.debug("***************************** afterReturnAdvice is running *****************************");
		logger.debug("***************************** jsonStr:{}*****************************",jsonStr);
		logger.debug("***************************** afterReturnAdvice is over *****************************");
	}
	
	/**
	 * 后置通知
	 * 在连接点执行完成后执行，不管是正常执行完成，还是抛出异常，都会执行返回通知中的内容。
	 * @param jp
	 */
	@After("advice()")
	public void afterAdvice(JoinPoint jp) {
		logger.debug("***************************** afterAdvice is running *****************************");
	}
	
	
	/**
	 * 异常通知
	 * 在连接点抛出异常后执行
     * 但是不会捕获原方法抛出的异常
	 * 参数中异常的类型，决定了发生何种异常才会进入该方法
	 * 因此用法是针对特定的异常进行处理
	 * @param jp
	 */
	@AfterThrowing(value="advice()",throwing = "e")
	public void afterThrowing(JoinPoint jp, BusinessException e) {
		logger.debug("***************************** afterThrowing is running *****************************");
		String method  = jp.getSignature().getName();
		logger.error("method:{} has happened an BusinessException ,the exception message is {}",method,e.getMessage());
		logger.debug("***************************** afterThrowing is over *****************************");
	}

	/**
	 * 环绕通知
	 * 环绕通知围绕在连接点前后，比如一个方法调用的前后。能够对原有方法增强。
	 * 而且，环绕通知还需要负责决定是继续处理join point(调用ProceedingJoinPoint的proceed方法)还是中断执行
     * 可以设置返回值，返回值即为目标方法的返回值。
	 * @param jp
	 */
	@Around("advice()")
	public String processRecorder(ProceedingJoinPoint jp) throws Throwable {
		logger.debug("***************************** processRecorder around is running ********************************");
		Object proceed = jp.proceed();
		logger.debug(">>>>>>>>>>>>>>>>>>>>proceed:{}<<<<<<<<<<<<<<<<<<<<",proceed.toString());
		logger.debug("***************************** processRecorder around is over ********************************");
		return proceed.toString();
	}
	
	/**
	 * @param jp
	 * @return
	 */
	private Object getSignature(JoinPoint jp){
		Object ret = null;
		// 获取方法签名
		Signature signature = jp.getSignature();
		logger.debug(">>>>>>>>>>>>>>>>>>>>signature:{}<<<<<<<<<<<<<<<<<<<<",signature);
		//获取目标类名 
		String className = jp.getTarget().getClass().toString();
		logger.debug(">>>>>>>>>>>>>>>>>>>>className:{}<<<<<<<<<<<<<<<<<<<<",className);
		// 获取目标类简称
		className = className.substring(className.indexOf("com"));
		logger.debug(">>>>>>>>>>>>>>>>>>>>shortClassName：{}<<<<<<<<<<<<<<<<<<<<",className);
		//获取目标方法名
		String methodName = signature.getName();
		logger.debug(">>>>>>>>>>>>>>>>>>>>methodName：{}<<<<<<<<<<<<<<<<<<<<",methodName);
		
		// 获取所有参数名字
		MethodSignature methodSignature = (MethodSignature) signature;
		String[] parameterNames = methodSignature.getParameterNames();
		logger.debug(">>>>>>>>>>>>>>>>>>>>parameterNames:{}<<<<<<<<<<<<<<<<<<<<",parameterNames.toString());
		
		// 获取连接点所有参数
		Object[] parames = jp.getArgs();
		for (Object object : parames) {
			logger.debug(">>>>>>>>>>>>>>>>>>>>object:{}<<<<<<<<<<<<<<<<<<<<",object.toString());
		}
		
		// 获取指定名称参数
		int index = ArrayUtils.indexOf(parameterNames,PARAMS_NAME);
        if (index != -1) {
        	ret = parames[index];
            logger.debug(">>>>>>>>>>>>>>>>>>>>{}_{}<<<<<<<<<<<<<<<<<<<<",PARAMS_NAME,parames[index]);
        }
		return ret;
	}
	
}
