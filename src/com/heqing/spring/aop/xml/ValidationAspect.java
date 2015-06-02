package com.heqing.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;


public class ValidationAspect {

	public void validateArgs(JoinPoint joinPoint){
		System.out.println("the validate method: "+joinPoint.getSignature().getName());
		System.out.println("the validate args: "+Arrays.asList(joinPoint.getArgs()));
		
	}
	
	//20 01:06
}
