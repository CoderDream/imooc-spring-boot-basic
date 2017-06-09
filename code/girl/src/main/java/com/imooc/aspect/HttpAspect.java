package com.imooc.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {

	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	// 单个方法与所有的方法
	// @Before("execution(public *
	// com.imooc.controller.GirlController.girlList(..))")
	// @Before("execution(public * com.imooc.controller.GirlController.*(..))")
	// public void log(){
	// System.out.println("111111");
	// }
	//
	// @After("execution(public * com.imooc.controller.GirlController.*(..))")
	// public void doAfter(){
	// System.out.println("22222222");
	// }

	@Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
	public void log() {
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		// System.out.println("22222222");
		logger.info("1212");

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// url
		logger.info("url={}", request.getRequestURL());

		// method
		logger.info("method={}", request.getMethod());

		// ip
		logger.info("getRemoteHost={}", request.getRemoteHost());
		logger.info("getRemoteAddr={}", request.getRemoteAddr());

		// class method
		logger.info("class_method={}",
				joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

		// parameter
		logger.info("args={}", joinPoint.getArgs());

	}

	@After("log()")
	public void doAfter() {
		// System.out.println("333333333");
		logger.info("3434");
	}

	@AfterReturning(returning = "object", pointcut = "log()")
	public void doAfterReturing(Object object) {
		logger.info("response={}", object);
	}
}
