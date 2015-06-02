package com.heqing.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)//指定优先级，值越小优先级越高
@Aspect
@Component
public class ValidationAspect {

	@Before("LoggingAspect.declareJointPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("the validate method: "+joinPoint.getSignature().getName());
		System.out.println("the validate args: "+Arrays.asList(joinPoint.getArgs()));
		
	}
	
	//20 01:06
}
