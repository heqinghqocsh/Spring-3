package com.heqing.spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @author heqing
 *
 */

@Order(2)
@Component
@Aspect
public class LoggingAspect {
	
	/**
	 * 定义一个方法用于声明切入点表达式,该方法中不需要填入其他代码
	 * 使用@Pointcut 来声明切入点表达式
	 */
	@Pointcut("execution(* com.heqing.spring.aop.ArithmeticCalculator.*(..))")
	public void declareJointPointExpression(){}

	@Before("declareJointPointExpression()")
	private void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins with "+args);
	}
	
	@After("declareJointPointExpression()")
	private void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends");
	}
	
	/**
	 * 在方法正常结束后执行的代码
	 * 返回通知是可以访问到方法的返回值的！
	 * @param joinPoint
	 */
	@AfterReturning(value = "execution(* com.heqing.spring.aop.ArithmeticCalculator.*(..))",
			returning = "result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with  "+result);
	}
	
	@AfterThrowing(value = "execution(* com.heqing.spring.aop.ArithmeticCalculator.*(..))",
			throwing = "ex")
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
//	@Around(value = "execution(* com.heqing.spring.aop.ArithmeticCalculator.*(..))")
//	public Object aroundMethod(ProceedingJoinPoint pjoinPoint){
//		System.out.println("The method aroundMethod execute:  ");
//		
//		return 100;
//	}
	
	//
}
