package com.heqing.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * @author heqing
 *
 */

public class LoggingAspect {
	
	/**
	 * 定义一个方法用于声明切入点表达式,该方法中不需要填入其他代码
	 * 使用@Pointcut 来声明切入点表达式
	 */
	public void declareJointPointExpression(){}

	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins with "+args);
	}
	
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends");
	}
	
	/**
	 * 在方法正常结束后执行的代码
	 * 返回通知是可以访问到方法的返回值的！
	 * @param joinPoint
	 */
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with  "+result);
	}
	
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs exception:  "+ex);
	}
	
	/**
	 * 环绕通知需要携带  ProceedingJoinPoint  类型的参数
	 * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint  类型的参数可以决定是否执行目标方法
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 * @param pjoinPoint
	 */
	public Object aroundMethod(ProceedingJoinPoint pjoinPoint){
		System.out.println("The method aroundMethod execute:  ");
		
		return 100;
	}
	
	//
}
