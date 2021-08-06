package com.test01;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		// today 호출 (오늘 날짜)
		Date today = factory.getBean("today", Date.class);
		System.out.println("----------------------------");
		System.out.println(today);
		
		System.out.println("----------------------------");
		
		// 2021.01.12
		Date start = factory.getBean("start", Date.class);
		System.out.println(start);
		
		System.out.println("----------------------------");
		
		// 왜 이 코드가 위에 start보다 콘솔창에 먼저 출력이 될까? xml에서 이미 만들어져있어서 먼저 출력된다.
		BeanTest bean = (BeanTest) factory.getBean("beanTest");
	}

}
