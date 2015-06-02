package com.heqing.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//1. ����Spring IOC ����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2. ��IOC �����л�ȡbean ��ʵ��
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		//3. ʹ��bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println(result);
		
		result = arithmeticCalculator.div(12, 2);
		System.out.println(result);
		
	}
}
